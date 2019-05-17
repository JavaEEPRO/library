package si.inspirited.system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jesus Lord Almighty
 * at 23.01.2018
 */

@Controller
class IndexController {

    @GetMapping("/")
    public String welcome() {
        return "index";
    }
}
