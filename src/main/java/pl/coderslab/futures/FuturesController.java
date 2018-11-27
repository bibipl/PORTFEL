package pl.coderslab.futures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/fut")
public class FuturesController {

    @Autowired
    private FuturesService futuresService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Future> futures = futuresService.findAll();
        for (Future future : futures) {
            future.setPriceDate(LocalDate.now());
        }
        model.addAttribute("futures", futures);
        return "showFutures";
    }


}
