package si.inspirited.model.book.page;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Jesus Lord Almighty
 * at 24.01.2018
 */

public class PageValidator implements Validator {

    private static final String REQUIRED = "required";

    @Override
    public void validate(Object obj, Errors errors) {
        Page page = (Page) obj;
        String name = page.getName();
        // name validation
        if (!StringUtils.hasLength(name)) {
            errors.rejectValue("name", REQUIRED, REQUIRED);
        }

        // page type validation
        if (page.isNew() && page.getPageType() == null) {
            errors.rejectValue("pageType", REQUIRED, REQUIRED);
        }

        // written date validation
        if (page.getWrittenDate() == null) {
            errors.rejectValue("writtenDate", REQUIRED, REQUIRED);
        }
    }

    /**
     * This Validator validates *just* Page instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Page.class.isAssignableFrom(clazz);
    }
}