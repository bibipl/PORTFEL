package pl.coderslab.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.PortfolioParts.PortfEquity;
import pl.coderslab.equity.Equity;
import pl.coderslab.equity.EquityService;
import pl.coderslab.operAcc.OperAcc;
import pl.coderslab.operAcc.OperAccService;
import pl.coderslab.quotEq.QuotEqService;
import pl.coderslab.quotEq.QuotesEqu;
import pl.coderslab.quotFu.QuotFuService;
import pl.coderslab.tradeFu.TradeFut;
import pl.coderslab.tradeFu.TradeFutService;
import pl.coderslab.tradeeq.TradeEqu;
import pl.coderslab.tradeeq.TradeEquService;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/portf")
public class PortfolioController {

    @Autowired
    TradeEquService tradeEquService;

    @Autowired
    QuotEqService quotEqService;

    @Autowired
    TradeFutService tradeFutService;

    @Autowired
    QuotFuService quotFuService;

    @Autowired
    OperAccService operAccService;

    @Autowired
    EquityService equityService;

    @GetMapping("/calculate")
    public String porfolio(Model model) {
    double totalEqValue = 0;   // we need it to calculate later structure of the equity portfolio (val/totalVal)
    List<TradeEqu> equityTrades = tradeEquService.findAll();
    List<QuotesEqu> equityQuotations = quotEqService.findAll();

    List<TradeFut> futureTrades = tradeFutService.findAll();
    List<OperAcc> accountOperations = operAccService.findAll();

    List<PortfEquity> eqInPortfolio = new ArrayList<>();


    Set<String> equities = new HashSet<String>();
    for (TradeEqu tradeEqu : equityTrades) {
        equities.add(tradeEqu.getEquity().getIsin()); // we upload uniqe isins to search transactions
    }
    Iterator<String> itEq = equities.iterator();

    while (itEq.hasNext()) {
        PortfEquity portfEquity = new PortfEquity();
        portfEquity.setIsin(itEq.next());
//        Equity eq =equityService.getFirstByIsin("PLPKN0000018");
//        portfEquity.setName(equity.getName());
        LocalDate date=null;
        double price=0;

        //Now we are going to find the latest quotation for sppecifies equity
        if (equityQuotations.size() > 0) {
            for (QuotesEqu quotesEqu : equityQuotations) {
                if(quotesEqu.getEquity().getIsin().equals(portfEquity.getIsin())) {
                    portfEquity.setName(quotesEqu.getEquity().getName());
                    if (date == null) {
                        date  = quotesEqu.getDate();
                        price = quotesEqu.getPrice();
                    }
                    if (!date.isAfter(quotesEqu.getDate())) {
                        // in case we have to replace todays trade price with todays quotation
                        // dates equal byt we prefer closing price
                        date = quotesEqu.getDate();
                        price = quotesEqu.getPrice();
                    }
                }
            }
            portfEquity.setCurrentValuationDate(date);
            portfEquity.setCurrentPrice(price);
        }
        // Here if price <>0 and date<>null we got last quotation and last date
        // Now we look for number of shares and purchase price

        if (equityTrades.size() > 0) {
            double value=0;
            long number =0;
            for (TradeEqu tradeEqu : equityTrades) {
                // below : if to take only propoer equity (by isin we reconize)
                if(tradeEqu.getEquity().getIsin().equals(portfEquity.getIsin())) {
                    if (tradeEqu.getTransEquType().equals("KUPNO")) {
                        number += tradeEqu.getNumber();
                        value += tradeEqu.getNumber() * tradeEqu.getPrice() + tradeEqu.getCommision();
                    } else if (tradeEqu.getTransEquType().equals("SPRZEDAŻ")) {
                        number -= tradeEqu.getNumber();
                        value -= tradeEqu.getNumber() * tradeEqu.getPrice() - tradeEqu.getCommision();
                    }
                    // below price and date - we update to keep last's transaction curent data,
                    // in case there is no quotation in the database yet
                    if(portfEquity.getCurrentPrice() == 0) portfEquity.setCurrentPrice(tradeEqu.getPrice());
                    if (portfEquity.getCurrentValuationDate() == null) portfEquity.setCurrentValuationDate(tradeEqu.getTradeDate());
                    if (number == 0) value = 0; // position closed completely = we start to count from 0;
                }
            } // for
            portfEquity.setPurchaseValuation(value);
            portfEquity.setNumber(number);
            if (number != 0) portfEquity.setPurchasePrice(value/number);
            else portfEquity.setPurchasePrice(0.0);
        } // finished one equity search, before next loop lets calculate avg prices etc....

        if (portfEquity.getPurchasePrice() != 0) {
            portfEquity.setChangePrice((portfEquity.getCurrentPrice()/portfEquity.getPurchasePrice()-1)*100);
        }
        portfEquity.setCurrentValuation(portfEquity.getCurrentPrice()*portfEquity.getNumber());
        if (portfEquity.getPurchaseValuation() != 0) {
            portfEquity.setChangeValuation((portfEquity.getCurrentValuation()/portfEquity.getPurchaseValuation()-1)*100);
        }
        totalEqValue += portfEquity.getCurrentValuation();
        eqInPortfolio.add(portfEquity);
        } // end of While iterator

        // Now we count the structure of the portfolio
        if (totalEqValue != 0) {
            for (PortfEquity portfEquity : eqInPortfolio ) {
                portfEquity.setPercenOfThePortfolio(portfEquity.getCurrentValuation()/totalEqValue*100);
            }
        }
        model.addAttribute("eqPortf",eqInPortfolio);
        return "showPortfolio";
    }

}
