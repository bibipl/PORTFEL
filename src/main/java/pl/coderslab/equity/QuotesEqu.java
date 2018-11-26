package pl.coderslab.equity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "QUOTEQU")
public class QuotesEqu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double price;

    @ManyToOne
    private Equity equity;

}

