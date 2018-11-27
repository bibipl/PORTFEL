package pl.coderslab.quotEq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.operAcc.OperAcc;

import java.util.List;

@Controller
@RequestMapping("/eqQ")
public class QuotEqController {

    @Autowired
    QuotEqService quotEqService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<QuotesEqu> quEqs = quotEqService.findAll();
        model.addAttribute("quEqs", quEqs);
        return "showEquityQuotes";
    }


}
