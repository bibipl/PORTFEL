package pl.coderslab.tradeeq;


import pl.coderslab.equity.Equity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "TRADES_EQUITIES")
public class TradeEqu {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        LocalDate tradeDate;
        LocalDate settlementDate;
        private double price;
        private Long number;
        private double commision;
        private String description;

        @ManyToOne
        private Equity equity;

        @Transient
        double value;

        @Enumerated(EnumType.STRING)
        @Column(length = 10)
        TransEquType transEquType;

        public enum TransEquType {
            KUPNO, SPRZEDAŻ, DYWIDENDA
        }


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

        public TransEquType getTransEquType() {
        return transEquType;
        }

        public void setTransEquType(TransEquType transEquType) {
        this.transEquType = transEquType;
        }

        public Equity getEquity() {
                return equity;
        }

        public void setEquity(Equity equity) {
                this.equity = equity;
        }
}
