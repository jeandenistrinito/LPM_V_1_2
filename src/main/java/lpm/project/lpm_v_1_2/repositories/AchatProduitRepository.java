package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.AchatProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchatProduitRepository extends JpaRepository<AchatProduit,Long> {
    AchatProduit findAchatProduitByNomProduit(String nomP);
    AchatProduit findTopByNomProduit(String nomP);

}
