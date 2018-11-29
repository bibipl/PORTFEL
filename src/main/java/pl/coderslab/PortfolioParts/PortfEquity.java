package pl.coderslab.PortfolioParts;

import org.springframework.expression.EvaluationContext;
import pl.coderslab.equity.Equity;

import java.time.LocalDate;

public class PortfEquity extends Equity {
    private Long number;
    private double purchasePrice;
    private double currentPrice;
    private double changePrice;
    private LocalDate currentValuationDate;
    private double purchaseValuation;
    private double currentValuation;
    private  double changeValuation;
    private double percenOfThePortfolio;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public LocalDate getCurrentValuationDate() {
        return currentValuationDate;
    }

    public void setCurrentValuationDate(LocalDate currentValuationDate) {
        this.currentValuationDate = currentValuationDate;
    }

    public double getCurrentValuation() {
        return currentValuation;
    }

    public void setCurrentValuation(double currentValuation) {
        this.currentValuation = currentValuation;
    }

    public double getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(double changePrice) {
        this.changePrice = changePrice;
    }

    public double getChangeValuation() {
        return changeValuation;
    }

    public void setChangeValuation(double changeValuation) {
        this.changeValuation = changeValuation;
    }

    public double getPercenOfThePortfolio() {
        return percenOfThePortfolio;
    }

    public void setPercenOfThePortfolio(double percenOfThePortfolio) {
        this.percenOfThePortfolio = percenOfThePortfolio;
    }

    public double getPurchaseValuation() {
        return purchaseValuation;
    }

    public void setPurchaseValuation(double purchaseValuation) {
        this.purchaseValuation = purchaseValuation;
    }
}
