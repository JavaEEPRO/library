package si.inspirited.model.abstractModel;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

/**
 * @author Jesus Lord Almighty
 * at 23.01.2018
 */

@MappedSuperclass
public class LibraryEntity extends BaseEntity {

    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name="description")
    @NotEmpty
    private String description;

    @Column(name="author")
    @NotEmpty
    private String author;

    @Column(name="isbn")
    //@NotEmpty
    private Integer isbn;

    @Column(name="printyear")
    //@NotEmpty
    private Integer printYear;

    @Column(name="readalready")
    //@NotEmpty
    private Boolean readAlready;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getPrintYear() {
        return printYear;
    }

    public void setPrintYear(Integer printyear) {
        this.printYear = printyear;
    }

    public Boolean getReadAlready() {
        return readAlready;
    }

    public void setReadAlready(Boolean readAlready) {
        this.readAlready = readAlready;
    }
}
