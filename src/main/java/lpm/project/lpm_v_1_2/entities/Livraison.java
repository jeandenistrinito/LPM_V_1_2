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
public class Livraison implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivraison;
    private double montantDette;
    private double montantDettePayer;
    private String refAvance;
    private Date dateLivraison;

    public Livraison(double montantDette, double montantDettePayer, String refAvance, Date dateLivraison) {
        this.montantDette = montantDette;
        this.montantDettePayer = montantDettePayer;
        this.refAvance = refAvance;
        this.dateLivraison = dateLivraison;
    }
}
