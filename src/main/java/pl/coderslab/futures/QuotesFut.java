package pl.coderslab.futures;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "QUOTS_FUT")
public class QuotesFut {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private LocalDate date;
        private double price;

        @ManyToOne
        private Future future;

}
