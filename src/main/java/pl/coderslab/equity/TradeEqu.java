package pl.coderslab.equity;


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

        @Enumerated(EnumType.STRING)
        @Column(length = 8)
        TransEquType transType;

        public enum TransEquType {
            KUP, SPRZEDAJ, DYWIDENDA
        }
}
