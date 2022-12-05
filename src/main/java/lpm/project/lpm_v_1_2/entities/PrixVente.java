package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class PrixVente implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_PV;
    private Date datePV;
    private String nomProduitPV;
    private String unitePV;
    private Double prixVente;

    public PrixVente(Date datePV, String nomProduitPV, Double prixVente) {
        this.datePV = datePV;
        this.nomProduitPV = nomProduitPV;
        this.prixVente = prixVente;
    }

    public PrixVente(Date datePV, String nomProduitPV, String unitePV, Double prixVente) {
        this.datePV = datePV;
        this.nomProduitPV = nomProduitPV;
        this.unitePV = unitePV;
        this.prixVente = prixVente;
    }
}
