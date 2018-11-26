package pl.coderslab.account;

import pl.coderslab.equity.TradeEqu;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="TRADES_CASH")
public class OperationAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    LocalDate tradeDate;
    LocalDate settlementDate;
    private double value;
    private double commision;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    TradeEqu.TransEquType transType;

    public enum TransEquType {
        WPŁATA, WYPŁATA
    }
}
