package pl.coderslab.equity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.List;

public interface EquityRepository extends JpaRepository<Equity,Long> {

    List<Equity> findByIsin(String isin);
    List<Equity> findByName(String name);


}
