package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Fonction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FonctionRepository extends JpaRepository<Fonction,Long> {
    Fonction findByNomFonction(String nomFonction);
}
