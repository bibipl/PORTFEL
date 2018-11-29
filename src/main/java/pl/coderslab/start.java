package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class start {

    @RequestMapping("/")
    public String start() {
        return "start";
    }
}
