package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.PrixAchat;
import lpm.project.lpm_v_1_2.entities.PrixProduit;
import lpm.project.lpm_v_1_2.entities.PrixVente;
import lpm.project.lpm_v_1_2.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PrixVenteRepository extends JpaRepository<PrixVente,Long> {
    PrixVente findPrixVenteByNomProduitPV(String nomPV);
    PrixVente findTopByNomProduitPVOrderByDatePVDesc(String nomP);
    PrixVente findTopByNomProduitPVAndUnitePVOrderByDatePVDesc(String nomP,String unite);
    PrixVente findLastByNomProduitPVAndUnitePVOrderByDatePVDesc(String nomP,String unite);
    List<PrixVente> findAllByNomProduitPV(String nomP);
    List<PrixVente> findAllByUnitePV(String unite);
    List<PrixVente> findAllByPrixVente(double prixV);
    List<PrixVente> findAllByUnitePVOrderByDatePVDesc(String unite);
    List<PrixVente> findAllByNomProduitPVOrderByDatePVAsc(String nomP);
    List<PrixVente> findAllByUnitePVOrderByDatePVAsc(String unite);
    PrixVente findByUnitePV(String unite);
    PrixVente findByNomProduitPV(String nomP);
    List<PrixVente> findAllByDatePVBetweenOrderByDatePVAsc(Date date1, Date date2);
    List<PrixVente> findAllByNomProduitPVAndUnitePV(String nomP,String unite);
    List<PrixVente> findAllByDatePVBetweenAndNomProduitPVAndUnitePVOrderByDatePVAsc(Date date1,Date date2,String nomP,String unite);

    //void deletePrixVenteByNomProduitPV(String nomP);


    @Override
    void delete(PrixVente entity);
}
