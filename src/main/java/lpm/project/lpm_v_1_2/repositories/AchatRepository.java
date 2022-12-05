package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Achat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchatRepository extends JpaRepository<Achat,Long> {
    List<Achat> findAllByNomArticleOrderByDateAchatAsc(String nomP);
}
