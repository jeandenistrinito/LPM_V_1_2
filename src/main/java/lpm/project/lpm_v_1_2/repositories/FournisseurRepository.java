package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    Fournisseur findFournisseurByNomFournisseur(String nomFournisseur);
}
