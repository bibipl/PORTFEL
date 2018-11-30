package pl.coderslab.tradeeq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface TradeEquRepository extends JpaRepository<TradeEqu, Long> {

    List<TradeEqu> findAllByEquityId (Long id);

    @Query("select t from TradeEqu t where t.equity.id = ?1 and t.transEquType = ?2 order by t.tradeDate asc")
    List<TradeEqu> findTradeEquByTransEquType(Long id, String transEquType);

}
