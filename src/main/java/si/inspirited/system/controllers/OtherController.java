/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package si.inspirited.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Random;

/**
 * @author Jesus Lord Almighty
 *
 */
@Controller
class OtherController {


    @GetMapping("/task.html")
    public String showTask(Map<String, Object> model) {
        return "task/task";
    }

    @GetMapping("/librarian.html")
    public String iLibrarian(Map<String, Object> model) {
        model.put("suf", getImageSuffix());
        return "librarian/librarian";
    }

    @GetMapping("/about.html")
    public String aboutUs() {
        return "about/about";
    }

    @GetMapping("/comment.html")
    public String comment() {
        return "comment/comment";
    }


    // util

    public String getImageSuffix() {
        Random random = new Random();
        Double doub = random.nextDouble()*10;
        int res = doub.intValue();
        if (res%2 == 0 || res == 1 || res == 5) {return "librarian3.jpg";}

        else return "librarian1.jpg";
    }
}