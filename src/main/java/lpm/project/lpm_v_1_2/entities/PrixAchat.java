package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class PrixAchat implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_PA;
    private Date datePA;
    private String nomProduitPA;
    private String unitePA;
    private Double prixAchat;

    public PrixAchat(Date datePA, String nomProduitPA, Double prixAchat) {
        this.datePA = datePA;
        this.nomProduitPA = nomProduitPA;
        this.prixAchat = prixAchat;
    }

    public PrixAchat(Date datePA, String nomProduitPA, String unitePA, Double prixAchat) {
        this.datePA = datePA;
        this.nomProduitPA = nomProduitPA;
        this.unitePA = unitePA;
        this.prixAchat = prixAchat;
    }
}
