package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.BeAchat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeAchatRepository extends JpaRepository<BeAchat,Integer> {
    BeAchat findTopByBeAchatOrderByDateBeAchatDesc(String ba);
}
