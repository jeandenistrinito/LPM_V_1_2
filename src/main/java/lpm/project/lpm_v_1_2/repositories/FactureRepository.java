package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
