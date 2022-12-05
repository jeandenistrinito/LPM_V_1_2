package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class PlusProduit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_PlusProduit;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date datePlusProduit;
    private String designation;
    private int niveauP;
    private String unite;
    private Double quantite;
    private Double poids;
    private String categorie;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public PlusProduit(Date datePlusProduit, String designation, int niveauP, String unite, Double quantite, Double poids, String categorie, String image) {
        this.datePlusProduit = datePlusProduit;
        this.designation = designation;
        this.niveauP = niveauP;
        this.unite = unite;
        this.quantite = quantite;
        this.poids = poids;
        this.categorie = categorie;
        this.image = image;
    }

    public PlusProduit(String designation, int niveau, String unite, Double quantite, Double poids) {
        this.designation = designation;
        this.niveauP = niveau;
        this.unite = unite;
        this.quantite = quantite;
        this.poids = poids;
    }

    public PlusProduit(String designation, int niveauP, String unite, Double quantite, Double poids, String categorie, String image) {
        this.designation = designation;
        this.niveauP = niveauP;
        this.unite = unite;
        this.quantite = quantite;
        this.poids = poids;
        this.categorie = categorie;
        this.image = image;
    }
}
