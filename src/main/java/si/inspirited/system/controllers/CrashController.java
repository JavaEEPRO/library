package si.inspirited.system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import java.util.Random;

/**
 * @author Jesus Lord Almighty
 * at 23.01.2018
 */

@Controller
class CrashController {

    @GetMapping("/crash")
    public String triggerException(Map<String, Object> model) {
        throw new RuntimeException("Expected: controller used to showcase what "
                + "happens when an exception is thrown (this is a default message, " +
                "if you see it - there is no any exception thrown indeed, but you just " +
                "called this controller method manually)");
    }
}