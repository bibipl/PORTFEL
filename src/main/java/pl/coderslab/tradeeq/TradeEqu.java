package pl.coderslab.tradeeq;


import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.equity.Equity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "TRADES_EQUITIES")
public class TradeEqu {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate tradeDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate settlementDate;
        private double price;
        private Long number;
        private double commision;
        private String description;

        @Transient
        List<String> operEqTypes = new ArrayList<>(Arrays.asList("KUPNO", "SPRZEDAŻ", "DYWIDENDA"));

        @ManyToOne
        private Equity equity;

        @Transient
        double value;

//      @Enumerated(EnumType.STRING)
        @Column(length = 10)
        String transEquType;


       /* public enum TransEquType {
            KUPNO, SPRZEDAŻ, DYWIDENDA
        }*/


        public TradeEqu() {
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

        public Long getNumber() {
                return number;
        }

        public void setNumber(Long number) {
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

        public double getValue() {
                return value;
        }

        public void setValue(double value) {
                this.value = value;
        }

        public String getTransEquType() {
        return transEquType;
        }

        public void setTransEquType(String transEquType) {
        this.transEquType = transEquType;
        }

        public Equity getEquity() {
                return equity;
        }

        public void setEquity(Equity equity) {
                this.equity = equity;
        }

}
