package pl.coderslab.quotFu;

import pl.coderslab.futures.Future;

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

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public LocalDate getDate() {
                return date;
        }

        public void setDate(LocalDate date) {
                this.date = date;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public Future getFuture() {
                return future;
        }

        public void setFuture(Future future) {
                this.future = future;
        }
}
