package pl.coderslab.portfolioCash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Calculations.Calculator;
import pl.coderslab.account.Account;
import pl.coderslab.account.AccountService;
import pl.coderslab.operAcc.OperAcc;
import pl.coderslab.operAcc.OperAccService;

import java.time.LocalDate;
import java.util.*;
@Controller
@RequestMapping("/cash")
public class PortfolioCashController {

    @Autowired
    AccountService accountService;

    @Autowired
    OperAccService operAccService;

    @GetMapping("/calculate")
    public String porfolio(Model model) {

        double totalCashValue = 0;   // we need it to calculate later structure of the cash portfolio (val/totalVal)
        List<OperAcc> operations = operAccService.findAll();
        List<Account> accountInPortf = new ArrayList<>();

        Set<Long> accounts = new TreeSet<Long>();
        for (OperAcc operation : operations) {
            accounts.add(operation.getAccount().getId()); // The name. Should be uniqe
        }
        Iterator<Long> itCash = accounts.iterator();

        while (itCash.hasNext()) {
            Account account = accountService.find(itCash.next());
            LocalDate date = null;
            double price = 0;
            // We have account now we search for values, calculating operations to get valuation.

            if (operations.size() > 0) {
                double value = 0;
                long number = 0;
                for (OperAcc operation : operations) {
                    // below : if to take only proper equity (by isin we reconize)
                    if (operation.getAccount().getId() == account.getId()) {
                        if (date == null) date = operation.getTradeDate();// first date
                        else if (date.isBefore(operation.getTradeDate()))
                            date = operation.getTradeDate(); // to get last trade date
                        if (operation.getOperAccType().equals("SALDO")) {
                            value = Calculator.round(operation.getValue(), 2); // Saldo means we set new confirmed value that starts.
                        } else if (operation.getOperAccType().equals("WPŁATA") ||
                                operation.getOperAccType().equals("ODSETKI") ||     // %, KOREKTA we write with +/-
                                operation.getOperAccType().equals("KOREKTA")) {
                            value += operation.getValue();
                        } else if (operation.getOperAccType().equals("WYPŁATA")) {
                            value -= Calculator.round(operation.getValue(), 2);
                        }
                    }
                } // for
                totalCashValue += value;
                account.setValue(value);
                account.setDate(date);
                accountInPortf.add(account);
            }
        } // end of While iterator

        // Now we count the structure of the portfolio
        if (totalCashValue != 0) {
            for (Account acc : accountInPortf) {
                double tmpChange = (acc.getValue() / totalCashValue * 100);
                acc.setPartOfTotalCash(Calculator.round(tmpChange,1));
            }
        }

        //Now we calculate last position - aggregated account as sum of the parts
        Account totalAcc = new Account();
        totalAcc.setName("SUMA");
        totalAcc.setDate(LocalDate.now());
        totalAcc.setValue(Calculator.round(totalCashValue,2));
        totalAcc.setPartOfTotalCash(100);

        model.addAttribute("cashPortf", accountInPortf);
        model.addAttribute("suma", totalAcc);
        return "showPortfolioCash";
    }
}
