package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.VenteProduit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VenteProduitRepository extends JpaRepository<VenteProduit,Long> {
    VenteProduit findTopByNomProduit(String nomClient);
}
