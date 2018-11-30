package pl.coderslab.tradeFu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeFutRepository extends JpaRepository<TradeFut, Long> {

    List<TradeFut> findAllByFutureId (Long id);
}
