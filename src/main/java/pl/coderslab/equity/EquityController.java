package pl.coderslab.equity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/equ")
public class EquityController {

    @Autowired
    private EquityService equityService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Equity> equities = equityService.findAll();
        for (Equity equity : equities) {
            equity.setPriceDate(LocalDate.now());
        }
        model.addAttribute("equities", equities);
        return "showEquities";
    }

}






