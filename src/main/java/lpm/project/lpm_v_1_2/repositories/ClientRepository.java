package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientByNomPrenom(String nomPrenom);
}
