package pl.coderslab.tradeFu;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.futures.Future;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "TRADES_FUTURES")
public class TradeFut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tradeDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate settlementDate;
    private double price;
    private double number;
    private double commision;
    private String description;


    @Transient
    List<String> operFuTypes = new ArrayList<>(Arrays.asList("KUPNO", "SPRZEDAŻ"));

//    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    String transFutType;

    @ManyToOne
    private Future future;

    @Transient
    double exposure;

   /* public enum TransFutType {
        KUPNO, SPRZEDAŻ
    }*/

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

    public String getTransFutType() {
        return transFutType;
    }

    public void setTransFutType(String transFutType) {
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
