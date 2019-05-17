package si.inspirited.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import si.inspirited.model.book.Book;

/**
 * @author Jesus Lord Almighty
 * at 24.01.2018
 */
@Repository
public interface BookPagingRepository extends PagingAndSortingRepository<Book, Long> {}