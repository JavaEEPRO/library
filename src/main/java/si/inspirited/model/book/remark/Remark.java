package si.inspirited.model.book.remark;

import org.springframework.format.annotation.DateTimeFormat;
import si.inspirited.model.abstractModel.BaseEntity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author Jesus Lord Almighty
 * at 23.01.2018
 */
@Entity
@Table(name = "remarks")
public class Remark extends BaseEntity {

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @Column(name = "pageid")
    private Integer pageId;

    /**
     * Creates a new instance of Remark for the current date
     */
    public Remark() {
        this.date = new Date();
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPageId() {
        return this.pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }
}