package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.FacVente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FacVenteRepository extends JpaRepository<FacVente,Integer> {
    List<FacVente> findAllByDateFacVenteBetweenOrderByDateFacVenteDesc(Date dateDebut, Date dateFin);
}
