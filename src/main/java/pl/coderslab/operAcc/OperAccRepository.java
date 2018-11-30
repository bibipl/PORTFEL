package pl.coderslab.operAcc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperAccRepository extends JpaRepository<OperAcc, Long> {

    List<OperAcc> findAllByAccountId (Long id);
}
