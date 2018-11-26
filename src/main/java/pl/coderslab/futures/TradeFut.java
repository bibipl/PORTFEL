package pl.coderslab.futures;

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
    private Long number;
    private double commision;
    private String description;


    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    TransFutType transFutType;

    public enum TransFutType {
        KUP, SPRZEDAJ
    }
}
