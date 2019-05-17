package si.inspirited.model.book.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import si.inspirited.repository.PageRepository;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

/**
 * @author Jesus Lord Almighty
 * at 24.01.2018
 */

@Component
public class PageTypeFormatter implements Formatter<PageType> {

    private final PageRepository pages;


    @Autowired
    public PageTypeFormatter(PageRepository pages) {
        this.pages = pages;
    }

    @Override
    public String print(PageType pageType, Locale locale) {
        return pageType.getName();
    }

    @Override
    public PageType parse(String text, Locale locale) throws ParseException {
        Collection<PageType> findPageTypes = this.pages.findPageTypes();
        for (PageType type : findPageTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }
}