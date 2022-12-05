package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Dette implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDette;
    private String detteDesignation;
    private String detteFournisseur;
    private Date detteDate;
    private double montantDette;
    private double montantPayDette;
    private String produitEndette;
    private String descriptionDette;

    public Dette(String detteDesignation, String detteFournisseur, Date detteDate, double montantDette, double montantPayDette, String produitEndette, String descriptionDette) {
        this.detteDesignation = detteDesignation;
        this.detteFournisseur = detteFournisseur;
        this.detteDate = detteDate;
        this.montantDette = montantDette;
        this.montantPayDette = montantPayDette;
        this.produitEndette = produitEndette;
        this.descriptionDette = descriptionDette;
    }
}
