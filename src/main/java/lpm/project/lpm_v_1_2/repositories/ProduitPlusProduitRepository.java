package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.ProduitPlusProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitPlusProduitRepository extends JpaRepository<ProduitPlusProduit,Long> {
    ProduitPlusProduit findByNomProduit(String nomP);

    //void deleteProduitPlusProduitByNomProduit(String nomP);

    @Override
    void delete(ProduitPlusProduit entity);
}
