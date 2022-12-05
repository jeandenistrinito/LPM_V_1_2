package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinRepository extends JpaRepository<Magasin,Long> {
    Magasin findByNomMagasin(String nomMagasin);
}
