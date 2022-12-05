package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    Produit findProduitByNomProduit(String nomProduit);
    List<Produit> findAllByNomProduit(String nom);
    Produit findTopByNomProduit(String nomProduit);
    Produit findTopByNomProduitOrderByNiveauProduitAsc(String nomP);
    Produit findProduitByUniteProduit(String uniteP);
    List<Produit> findAllByNomProduitOrderByNiveauProduitDesc(String nomP);
    Produit findByNomProduitAndNiveauProduit(String nomP, int niveauP);
    Produit findByNomProduitAndUniteProduit(String nomP, String uniteP);

    //void deleteProduitByNomProduit(String nomP);


    @Override
    void delete(Produit entity);
}

