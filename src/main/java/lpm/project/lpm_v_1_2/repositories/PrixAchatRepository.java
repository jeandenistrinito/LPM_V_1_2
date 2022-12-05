package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.PrixAchat;
import lpm.project.lpm_v_1_2.entities.PrixProduit;
import lpm.project.lpm_v_1_2.entities.PrixVente;
import lpm.project.lpm_v_1_2.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrixAchatRepository extends JpaRepository<PrixAchat,Long> {
    PrixAchat findTopByNomProduitPAOrderByDatePADesc(String nomP);
    PrixAchat findPrixAchatByNomProduitPA(String nomP);
    List<PrixAchat> findAllByNomProduitPA(String nomP);
    List<PrixAchat> findAllByUnitePA(String unite);
    List<PrixAchat> findAllByPrixAchat(double prixA);
    PrixAchat findTopByPrixAchatOrderByDatePADesc(double prixA);
    List<PrixAchat> findAllByUnitePAOrderByDatePADesc(String unite);

    List<PrixAchat> findAllByUnitePAAndNomProduitPAOrderByDatePADesc(String unite,String nom);
    PrixAchat findByNomProduitPAAndUnitePA(String nomP,String uniteP);

    PrixAchat findTopByNomProduitPAAndUnitePAOrderByDatePADesc(String nomP,String unite);
    PrixAchat findLastByNomProduitPAAndUnitePAOrderByDatePADesc(String nomP,String unite);

    //void deletePrixAchatByNomProduitPA(String nomP);


    @Override
    void delete(PrixAchat entity);
}
