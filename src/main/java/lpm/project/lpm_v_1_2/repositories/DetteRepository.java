package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Dette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetteRepository extends JpaRepository<Dette,Long> {
    List<Dette> findAllByDetteFournisseur(String nomFrs);
}
