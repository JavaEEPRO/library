package si.inspirited.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import si.inspirited.model.abstractModel.BaseEntity;
import si.inspirited.model.book.remark.Remark;
import java.util.List;

/**
 * @author Jesus Lord Almighty
 * at 24.01.2018
 */
public interface RemarkRepository extends Repository<Remark, Integer> {

    /**
     * Save a <code>Remark</code> to the data store, either inserting or updating it.
     *
     * @param remark the <code>Remark</code> to save
     * @see BaseEntity#isNew
     */
    void save(Remark remark) throws DataAccessException;

    List<Remark> findByPageId(Integer pageId);
}