package pl.coderslab.operAcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.account.Account;
import pl.coderslab.account.AccountRepository;

import java.util.List;

@Controller
@RequestMapping("/opacc")
public class OperAccController {

    @Autowired
    OperAccService operAccService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<OperAcc> operAccs = operAccService.findAll();
        model.addAttribute("operAccs", operAccs);
        return "showOperAcc";
    }
}
