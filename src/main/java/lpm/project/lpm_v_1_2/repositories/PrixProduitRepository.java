package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.PrixProduit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrixProduitRepository extends JpaRepository<PrixProduit,Long> {
    PrixProduit findTopByNomProduitPPOrderByDatePPDesc(String nomP);
    PrixProduit findPrixProduitByNomProduitPP(String nomP);
    List<PrixProduit> findAllByNomProduitPPOrderByDatePPDesc(String nom);
    List<PrixProduit> findAllByNomProduitPP(String nomP);
    PrixProduit findTopByNomProduitPPAndUniteProduitPPOrderByDatePPDesc(String nomP,String uniteP);

    //void deletePrixProduitByNomProduitPP(String nomP);

    @Override
    void delete(PrixProduit entity);
}
