package si.inspirited.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import si.inspirited.model.book.Book;
import si.inspirited.repository.BookPagingRepository;

public interface BookService {

    /**
     * Finds a "page" of books
     *
     * @param pageable
     * @return {@link Page} instance
     */
    Page<Book> findAllPageable(Pageable pageable);

}
