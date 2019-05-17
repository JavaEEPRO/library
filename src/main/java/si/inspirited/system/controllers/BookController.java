package si.inspirited.system.controllers;

/*import com.sun.org.apache.xpath.internal.operations.Bool;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import si.inspirited.model.Pager;
import si.inspirited.model.book.Book;
import si.inspirited.repository.BookRepository;
import si.inspirited.service.BookService;
import javax.validation.Valid;
import java.util.*;

/**
 * @author Jesus Lord Almighty
 * at 24.01.2018
 */
@Controller
class BookController {

    //repository
    private final BookService bookService;
    private final BookRepository books;

    //views
    private static final String VIEWS_BOOK_CREATE_OR_UPDATE_FORM = "books/createOrUpdateBookForm";
    private static final String VIEWS_BOOK_SEARCH_FORM = "books/findBooks";
    private static final String VIEWS_BOOKS_LIST = "books/booksList";

    //parameters for paginator
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {5, 10, 20};

    //constructor initializes repositories
    @Autowired
    public BookController(BookRepository libraryService, BookService bookService) {
        this.books = libraryService;
        this.bookService = bookService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/books/new")
    public String initCreationForm(Map<String, Object> model) {
        Book book = new Book();

        model.put("book", book);

        return VIEWS_BOOK_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/books/new")
    public String processCreationForm(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_BOOK_CREATE_OR_UPDATE_FORM;
        } else {
            book.setReadAlready(false);
            this.books.save(book);

            return "redirect:/books/" + book.getId();
        }
    }

    @GetMapping("/books/find")
    public String initFindForm(Map<String, Object> model) {

        model.put("book", new Book());

        return VIEWS_BOOK_SEARCH_FORM;
    }

    @GetMapping("/books")
    public String processFindForm(@RequestParam("pageSize") Optional<Integer> pageSize,
                                  @RequestParam("page") Optional<Integer> page,
                                  /*@RequestParam("pyear") Integer pyear,*/
                                  Book book, BindingResult result, Map<String, Object> model) {     //@RequestParam(value = "page", required = false)Integer page,

        // allow parameterless GET request for /books to return all records
        if (book.getTitle() == null) {
            book.setTitle(""); // empty string signifies broadest possible search
        }

        // find books by title
        Collection<Book> results = this.books.findByTitle(book.getTitle());
        if (results.isEmpty()) {
            // no books found
            //results =
            result.rejectValue("title", "notFound", "not found");

            return VIEWS_BOOK_SEARCH_FORM;

        } else if (results.size() == 1) {
            // 1 book found
            book = results.iterator().next();

            return "redirect:/books/" + book.getId();

            //count how many books in result list
        } else {

            // Evaluate page size. If requested parameter is null, return initial
            // page size
            int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
            // Evaluate page. If requested parameter is null or less than 0 (to
            // prevent exception), return initial size. Otherwise, return value of
            // param. decreased by 1.
            int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

            Page<Book> bookz = bookService.findAllPageable(new PageRequest(evalPage, evalPageSize));
            Pager pager = new Pager(bookz.getTotalPages(), bookz.getNumber(), BUTTONS_TO_SHOW);

            if (results.size() <= 10) {
                List<Book> resList = new ArrayList(results);
                final Page<Book> resPage = new PageImpl<>(resList);
                model.put("selections", resPage);}
            if (results.size() > 10) {model.put("selections", bookz);}

            model.put("selectedPageSize", evalPageSize);
            model.put("pageSizes", PAGE_SIZES);
            model.put("pager", pager);

            return VIEWS_BOOKS_LIST;
        }
    }

    @GetMapping("/books/unread")
    public String processFindUnread(@RequestParam("pageSize") Optional<Integer> pageSize,
                                    @RequestParam("page") Optional<Integer> page,

                                    Book book, BindingResult result, Map<String, Object> model) {     //@RequestParam(value = "page", required = false)Integer page,

        // find books by readAlready (false matches)
        Collection<Book> results = this.books.findByReadAlready();
        if (results.isEmpty()) {
            // no books found

            return VIEWS_BOOK_SEARCH_FORM;

        } else if (results.size() == 1) {
        // 1 book found
        book = results.iterator().next();

        return "redirect:/books/" + book.getId();

            //count how many books in result list
        } else {

            // Evaluate page size. If requested parameter is null, return initial
            // page size
            int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
            // Evaluate page. If requested parameter is null or less than 0 (to
            // prevent exception), return initial size. Otherwise, return value of
            // param. decreased by 1.
            int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

            List<Book> resList = new ArrayList(results);
            Pageable pageable = new Pageable() {
                @Override
                public int getPageNumber() {
                    return evalPage;
                }

                @Override
                public int getPageSize() {
                    return evalPageSize;
                }

                @Override
                public long getOffset() {
                    return 0;
                }

                @Override
                public Sort getSort() {
                    return null;
                }

                @Override
                public Pageable next() {
                    return null;
                }

                @Override
                public Pageable previousOrFirst() {
                    return null;
                }

                @Override
                public Pageable first() {
                    return null;
                }

                @Override
                public boolean hasPrevious() {
                    return false;
                }
            };
            Page<Book> resPage = new PageImpl<>(resList);             //(resList, pageable, 1);
            Pager pager = new Pager(1, evalPage, BUTTONS_TO_SHOW);
            System.out.println(resPage.getTotalPages());
            model.put("selections", resPage);

            model.put("selectedPageSize", 10);
            model.put("pageSizes", PAGE_SIZES);
            model.put("pager", pager);

            return VIEWS_BOOKS_LIST;
        }
    }

    @GetMapping("/books/afterYear")
    public String processFindAfterYear(@RequestParam("pageSize") Optional<Integer> pageSize,
                                       /*@RequestParam("afterYear") Integer afterYear,*/
                                       @RequestParam("page") Optional<Integer> page,
                                       Book book, BindingResult result, Map<String, Object> model) {
        // find books where printYear > afterYear
        Collection<Book> results = this.books.findByPrintYear(2017);
        if (results.isEmpty()) {
            // no books found

            return VIEWS_BOOK_SEARCH_FORM;

        } else if (results.size() == 1) {
            // 1 book found
            book = results.iterator().next();

            return "redirect:/books/" + book.getId();

        } else {

            // Evaluate page size. If requested parameter is null, return initial
            // page size
            int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
            // Evaluate page. If requested parameter is null or less than 0 (to
            // prevent exception), return initial size. Otherwise, return value of
            // param. decreased by 1.
            int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

            List<Book> resList = new ArrayList(results);

            Page<Book> resPage = new PageImpl<>(resList);
            Pager pager = new Pager(5, evalPage, BUTTONS_TO_SHOW);

            model.put("selections", resPage);

            model.put("selectedPageSize", 10);
            model.put("pageSizes", PAGE_SIZES);
            model.put("pager", pager);

            return VIEWS_BOOKS_LIST;
        }
    }

            @GetMapping("/books/{bookId}/edit")
    public String initUpdateBookForm(@PathVariable("bookId") int bookId, Model model) {
        Book book = this.books.findById(bookId);

        model.addAttribute(book);

        return VIEWS_BOOK_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/books/{bookId}/edit")
    public String processUpdateBookForm(@Valid Book book, BindingResult result, @PathVariable("bookId") int bookId) {
        if (result.hasErrors()) {

            return VIEWS_BOOK_CREATE_OR_UPDATE_FORM;
        } else {
            book.setId(bookId);
            this.books.save(book);

            return "redirect:/books/{bookId}";
        }
    }

    /**
     * Custom handler for displaying a book.
     *
     * @param bookId the ID of the book to display
     * @return a ModelMap with the model attributes for the view
     */
    @GetMapping("/books/{bookId}")
    public ModelAndView showBook(@PathVariable("bookId") int bookId) {
        ModelAndView mav = new ModelAndView("books/bookDetails");

        mav.addObject(this.books.findById(bookId));

        return mav;
    }

    @GetMapping("/books/{bookId}/read")
    public ModelAndView readBook(@PathVariable("bookId") int bookId) {
        Book readedBook = this.books.findById(bookId);

        readedBook.setReadAlready(true);
        this.books.save(readedBook);
        ModelAndView mav = new ModelAndView("books/readedBook");

        mav.addObject(this.books.findById(bookId));

        return mav;
    }

    @GetMapping("/books/{bookId}/delete")
    public ModelAndView removeBook(@PathVariable("bookId") int bookId) {
        this.books.deleteById(bookId);

        ModelAndView mav = new ModelAndView("books/removedBook");

        return mav;
    }
    //the wheal is reinvented successfully ))

    @GetMapping("/book/recommended")
    public String recommended(Map<String, Object> model) {

        Book book = new Book();
        book.setId(421);
        book.setTitle("Gospel according to John");
        book.setDescription(" And I have declared unto them thy name, and will declare [it]: that the love wherewith thou hast loved me may be in them, and I in them");
        book.setAuthor("Holy Ghost");
        book.setIsbn(143992);
        book.setPrintYear(2002);
        book.setReadAlready(false);
        model.put("book", book);

        return "books/bookDetails";
    }
}