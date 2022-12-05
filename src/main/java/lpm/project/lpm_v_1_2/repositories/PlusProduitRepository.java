package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.PlusProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlusProduitRepository extends JpaRepository<PlusProduit,Long> {
    PlusProduit findTopByDesignationOrderByNiveauPAsc(String nomP);
}
