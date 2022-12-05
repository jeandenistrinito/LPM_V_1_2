package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Categorie findCategorieByNomCategorie(String nom);
    Page<Categorie> findCategorieByCodeCategorie(int code ,Pageable pageable);
}
