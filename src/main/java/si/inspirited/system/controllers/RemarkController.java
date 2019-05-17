package si.inspirited.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import si.inspirited.model.book.page.Page;
import si.inspirited.repository.PageRepository;
import si.inspirited.model.book.remark.Remark;
import si.inspirited.repository.RemarkRepository;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author Jesus Lord Almighty
 * at 24.01.2018
 */
@Controller
class RemarkController {

    private final RemarkRepository remarks;
    private final PageRepository pages;


    @Autowired
    public RemarkController(RemarkRepository remarks, PageRepository pages) {
        this.remarks = remarks;
        this.pages = pages;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Called before each and every @RequestMapping annotated method.
     * 2 goals:
     * - Make sure we always have fresh data
     * - Since we do not use the session scope, make sure that Page object always has an id
     * (Even though id is not part of the form fields)
     *
     * @param pageId
     * @return Page
     */
    @ModelAttribute("remark")
    public Remark loadPageWithRemark(@PathVariable("pageId") int pageId, Map<String, Object> model) {
        Page page = this.pages.findById(pageId);
        model.put("page", page);
        Remark remark = new Remark();
        page.addRemark(remark);
        return remark;
    }

    // Spring MVC calls method loadPageWithRemark(...) before initNewRemarkForm is called
    @GetMapping("/books/*/pages/{pageId}/remarks/new")
    public String initNewRemarkForm(@PathVariable("pageId") int pageId, Map<String, Object> model) {
        return "pages/createOrUpdateRemarkForm";
    }

    // Spring MVC calls method loadPageWithRemark(...) before processNewRemarkForm is called
    @PostMapping("/books/{bookId}/pages/{pageId}/remarks/new")
    public String processNewRemarkForm(@Valid Remark remark, BindingResult result) {
        if (result.hasErrors()) {
            return "pages/createOrUpdateRemarkForm";
        } else {
            this.remarks.save(remark);
            return "redirect:/books/{bookId}";
        }
    }
}