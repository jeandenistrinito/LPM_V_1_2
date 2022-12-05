package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayementRepository extends JpaRepository<Payement,Long> {
    List<Payement> findAllByTypePayement(String typePaye);
}
