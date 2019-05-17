package si.inspirited.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import si.inspirited.model.book.Book;
import si.inspirited.repository.BookPagingRepository;
import si.inspirited.repository.BookRepository;
import si.inspirited.service.BookService;

/**
 * @author Jesus Lord Almighty
 * at 23.01.2018
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookPagingRepository bookPagingRepository;

    public BookServiceImpl(BookPagingRepository bookPagingRepository) {
        this.bookPagingRepository = bookPagingRepository;
    }

    @Override
    public Page<Book> findAllPageable(Pageable pageable) {
        return bookPagingRepository.findAll(pageable);
    }
}