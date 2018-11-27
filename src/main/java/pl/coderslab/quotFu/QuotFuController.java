package pl.coderslab.quotFu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fuQ")
public class QuotFuController {

    @Autowired
    QuotFuService quotFuService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<QuotesFut> quFuts = quotFuService.findAll();
        model.addAttribute("quFuts", quFuts);
        return "showFuturesQuotes";
    }

}
