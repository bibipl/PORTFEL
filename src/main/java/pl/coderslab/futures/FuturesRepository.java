package pl.coderslab.futures;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuturesRepository extends JpaRepository<Future,Long> {

}
