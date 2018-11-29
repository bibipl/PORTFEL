package pl.coderslab.equity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.List;

public interface EquityRepository extends JpaRepository<Equity,Long> {

    @Query("select i.name from Equity i where i.isin = ?1")
    Equity getFirstByIsin(String isin);


}
