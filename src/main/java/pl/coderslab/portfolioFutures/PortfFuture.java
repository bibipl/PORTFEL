package pl.coderslab.portfolioFutures;

import pl.coderslab.futures.Future;

public class PortfFuture extends Future {
    private double profit;
    private double purchasePrice;
    private double purchaseExposure;
    private double changePrice;
    private double changePts;
    private double changeValuation;
    private double percentOfTheExposure;


    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getPurchaseExposure() {
        return purchaseExposure;
    }

    public void setPurchaseExposure(double purchaseExposure) {
        this.purchaseExposure = purchaseExposure;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public double getPercentOfTheExposure() {
        return percentOfTheExposure;
    }

    public void setPercentOfTheExposure(double percentOfTheExposure) {
        this.percentOfTheExposure = percentOfTheExposure;
    }

    public double getChangepts() {
        return changePts;
    }

    public void setChangepts(double changepts) {
        this.changePts = changepts;
    }
}
