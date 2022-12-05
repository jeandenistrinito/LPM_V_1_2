package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.PayementVente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayementVenteRepository extends JpaRepository<PayementVente,Long> {
    List<PayementVente> findAllByTypePayement(String type);
    List<PayementVente> findAllByTypePayementOrderByDatePayementVenteDesc(String typeVente);
    List<PayementVente> findAllByTypePayementAndNomClient(String typepaye, String nomClient);
}
