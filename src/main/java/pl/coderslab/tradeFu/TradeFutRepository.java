package pl.coderslab.tradeFu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.tradeeq.TradeEqu;

import java.util.List;

public interface TradeFutRepository extends JpaRepository<TradeFut, Long> {

    List<TradeFut> findAllByFutureIdOrderByTradeDateAsc (Long id);
    @Query("select f from TradeFut f where f.future.id = ?1 and f.transFutType = ?2 order by f.tradeDate asc")
    List<TradeFut> findTradeFutByTransFutTypeOrderByTradeDateAsc(Long id, String transFutType);
}
