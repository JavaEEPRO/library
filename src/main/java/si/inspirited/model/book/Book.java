package si.inspirited.model.book;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;
import si.inspirited.model.book.page.Page;
import si.inspirited.model.abstractModel.LibraryEntity;
import javax.persistence.*;
import java.util.*;

/**
 * @author Jesus Lord Almighty
 * at 23.01.2018
 */
@Entity
@Table(name = "book")
public class Book extends LibraryEntity {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Set<Page> pages;

    protected Set<Page> getPagesInternal() {
        if (this.pages == null) {
            this.pages = new HashSet<>();
        }
        return this.pages;
    }

    protected void setPagesInternal(Set<Page> pages) {
        this.pages = pages;
    }

    public List<Page> getPages() {
        List<Page> sortedPages = new ArrayList<>(getPagesInternal());
        PropertyComparator.sort(sortedPages,
                new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPages);
    }

    public void addPage(Page page) {
        if (page.isNew()) {
            getPagesInternal().add(page);
        }
        page.setBook(this);
    }

    /**
     * Return the Page with the given name, or null if none found for this Book.
     *
     * @param name to test
     * @return true if page id is already in use
     */
    public Page getPage(String name) {
        return getPage(name, false);
    }

    /**
     * Return the Page with the given name, or null if none found for this Book.
     *
     * @param name to test
     * @return true if page name is already in use
     */
    public Page getPage(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Page page : getPagesInternal()) {
            if (!page.isNew()|| !ignoreNew) {
                String compName = page.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return page;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("id", this.getId()).append("new", this.isNew())
                .append("title", this.getTitle())
                .append("description", this.getDescription()).append("author", this.getAuthor())
                .append("isbn", this.getIsbn()).append("printYear", this.getPrintYear()).toString();
    }
}