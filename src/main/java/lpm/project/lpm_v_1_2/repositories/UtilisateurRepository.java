package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findUtilisateurByNomUtilisateur(String nomU);
}
