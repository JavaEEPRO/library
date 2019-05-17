package si.inspirited.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;
import si.inspirited.model.book.page.Page;
import si.inspirited.model.book.page.PageType;
import java.util.List;

/**
 * @author Jesus Lord Almighty
 * at 24.01.2018
 */
public interface PageRepository extends Repository<Page, Integer> {

    /**
     * Retrieve all {@link PageType}s from the data store.
     * @return a Collection of {@link PageType}s.
     */
    @Query("SELECT ptype FROM PageType ptype ORDER BY ptype.name")
    @Transactional(readOnly = true)
    List<PageType> findPageTypes();

    /**
     * Retrieve a {@link Page} from the data store by id.
     * @param id the id to search for
     * @return the {@link Page} if found
     */
    @Transactional(readOnly = true)
    Page findById(Integer id);

    /**
     * Save a {@link Page} to the data store, either inserting or updating it.
     * @param page the {@link Page} to save
     */
    void save(Page page);
}