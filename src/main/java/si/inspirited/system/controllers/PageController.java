package si.inspirited.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import si.inspirited.model.book.*;
import si.inspirited.model.book.page.Page;
import si.inspirited.repository.PageRepository;
import si.inspirited.model.book.page.PageType;
import si.inspirited.model.book.page.PageValidator;
import si.inspirited.repository.BookRepository;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * @author Jesus Lord Almighty
 * at 24.01.2018
 */
@Controller
@RequestMapping("/books/{bookId}")
class PageController {

    private static final String VIEWS_PAGES_CREATE_OR_UPDATE_FORM = "pages/createOrUpdatePageForm";
    private final PageRepository pages;
    private final BookRepository books;

    @Autowired
    public PageController(PageRepository pages, BookRepository books) {
        this.pages = pages;
        this.books = books;
    }

    @ModelAttribute("pagetypes")
    public Collection<PageType> populatePageTypes() {
        return this.pages.findPageTypes();
    }

    @ModelAttribute("book")
    public Book findBook(@PathVariable("bookId") int bookId) {
        return this.books.findById(bookId);
    }

    @InitBinder("book")
    public void initBookBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("page")
    public void initPageBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new PageValidator());
    }

    @GetMapping("/pages/new")
    public String initCreationForm(Book book, ModelMap model) {

        Page page = new Page();

        Calendar c = Calendar.getInstance();
        Date date =  c.getTime();
        page.setWrittenDate(date);

        book.addPage(page);
        model.put("page", page);
        return VIEWS_PAGES_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pages/new")
    public String processCreationForm(Book book, @Valid Page page, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(page.getName()) && page.isNew() && book.getPage(page.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        book.addPage(page);
        if (result.hasErrors()) {
            model.put("page", page);
            return VIEWS_PAGES_CREATE_OR_UPDATE_FORM;
        } else {
            this.pages.save(page);
            return "redirect:/books/{bookId}";
        }
    }

    @GetMapping("/pages/{pageId}/edit")
    public String initUpdateForm(@PathVariable("pageId") int pageId, ModelMap model) {
        Page page = this.pages.findById(pageId);
        model.put("page", page);
        return VIEWS_PAGES_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pages/{pageId}/edit")
    public String processUpdateForm(@Valid Page page, BindingResult result, Book book, ModelMap model) {
        if (result.hasErrors()) {
            page.setBook(book);
            model.put("page", page);
            return VIEWS_PAGES_CREATE_OR_UPDATE_FORM;
        } else {
            book.addPage(page);
            this.pages.save(page);
            return "redirect:/books/{bookId}";
        }
    }
}