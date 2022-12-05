package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface VenteRepository extends JpaRepository<Vente,Long> {
    List<Vente> findAllByNomArticleOrderByDateVenteAsc(String nomP);
    List<Vente> findAllByDateVenteBetweenOrderByDateVenteDesc(Date date1,Date date2);
}
