package si.inspirited.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import si.inspirited.model.book.Book;
import java.util.Collection;

/**
 * @author Jesus Lord Almighty
 * at 24.01.2018
 */
public interface BookRepository extends Repository<Book, Integer> {

    /**
     * retrieves {@link Book}s from the data store by title, returning all books
     * whose title <i>starts</i> with the given title.
     * @param title Value to search for
     * @return a Collection of matching {@link Book}s (or an empty Collection if none
     * found)
     */
    @Query("SELECT DISTINCT book FROM Book book left join fetch book.pages WHERE book.title LIKE :title%")
    @Transactional(readOnly = true)
    Collection<Book> findByTitle(@Param("title") String title);

    /**
     * retrieves {@link Book}s from the data store by printYear, returning all books
     * whose printYear <i>matches</i> given year (or later).
     * @param printYear Value to search for
     * @return a Collection of matching {@link Book}s (or an empty Collection if none
     * found)
     */
    @Query("SELECT DISTINCT book FROM Book book left join fetch book.pages WHERE book.printYear >= :printYear")
    @Transactional(readOnly = true)
    Collection<Book> findByPrintYear(@Param("printYear") Integer printYear);

    /**
     * retrieves {@link Book}s from the data store by readAlready, returning all books
     * whose readAlready parameter <i>matches</i> false.
     * @return a Collection of matching {@link Book}s (or an empty Collection if none
     * found)
     */
    @Query("SELECT DISTINCT book FROM Book book left join fetch book.pages WHERE book.readAlready = FALSE")
    @Transactional(readOnly = true)
    Collection<Book> findByReadAlready();

    /**
     * Retrieve an {@link Book} from the data store by id.
     * @param id the id to search for
     * @return the {@link Book} if found
     */
    @Query("SELECT book FROM Book book left join fetch book.pages WHERE book.id =:id")
    @Transactional(readOnly = true)
    Book findById(@Param("id") Integer id);

    /**
     * Save an {@link Book} to the data store, either inserting or updating it.
     * @param book the {@link Book} to save
     */
    void save(Book book);

    void deleteById(int id);
}