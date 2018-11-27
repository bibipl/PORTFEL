package pl.coderslab.tradeFu;

import pl.coderslab.equity.Equity;
import pl.coderslab.futures.Future;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TRADES_FUTURES")
public class TradeFut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate tradeDate;
    private LocalDate settlementDate;
    private double price;
    private double number;
    private double commision;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    TransFutType transFutType;

    @ManyToOne
    private Future future;

    @Transient
    double exposure;

    public enum TransFutType {
        KUPNO, SPRZEDAŻ
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransFutType getTransFutType() {
        return transFutType;
    }

    public void setTransFutType(TransFutType transFutType) {
        this.transFutType = transFutType;
    }

    public double getExposure() {
        return exposure;
    }

    public void setExposure(double value) {
        this.exposure = value;
    }

    public Future getFuture() {
        return future;
    }

    public void setFuture(Future future) {
        this.future = future;
    }
}
