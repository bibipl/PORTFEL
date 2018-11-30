package pl.coderslab.futures;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FutureRepository extends JpaRepository<Future,Long> {

    List<Future> findByIsin(String isin);

}
