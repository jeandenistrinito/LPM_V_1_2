package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit,Long> {
    List<Credit> findAllByClientCredit(String nomCLient);
}
