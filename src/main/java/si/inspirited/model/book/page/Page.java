package si.inspirited.model.book.page;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;
import si.inspirited.model.book.Book;
import si.inspirited.model.abstractModel.NamedEntity;
import si.inspirited.model.book.remark.Remark;
import javax.persistence.*;
import java.util.*;

/**
 * @author Jesus Lord Almighty
 * at 23.01.2018
 */
@Entity
@Table(name = "pages")
public class Page extends NamedEntity {

    @Column(name = "writtendate")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date writtenDate;

    @ManyToOne
    @JoinColumn(name = "pagetype")
    private PageType pageType;

    @ManyToOne
    @JoinColumn(name = "bookid")
    private Book book;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pageId", fetch = FetchType.EAGER)
    private Set<Remark> remarks = new LinkedHashSet<>();

    public void setWrittenDate(Date writtenDate) {
        this.writtenDate = writtenDate;
    }

    public Date getWrittenDate() {
        return this.writtenDate;
    }

    public PageType getPageType() {
        return this.pageType;
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    Set<Remark> getRemarksInternal() {
        if (this.remarks == null) {
            this.remarks = new HashSet<>();
        }
        return this.remarks;
    }

    protected void setRemarksInternal(Set<Remark> remarks) {
        this.remarks = remarks;
    }

    public List<Remark> getRemarks() {
        List<Remark> sortedRemarks = new ArrayList<>(getRemarksInternal());
        PropertyComparator.sort(sortedRemarks,
                new MutableSortDefinition("date", false, false));
        return Collections.unmodifiableList(sortedRemarks);
    }

    public void addRemark(Remark remark) {
        getRemarksInternal().add(remark);
        remark.setPageId(this.getId());
    }
}
