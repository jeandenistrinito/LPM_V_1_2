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
public class PrixProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_PP;
    private Date datePP;
    private String nomProduitPP;
    private String uniteProduitPP;
    private Double prixAchatPP;
    private Double prixVentePP;
    @ManyToOne @JoinColumn(name = "Id_Produit")
    private Produit produit;

    public PrixProduit(Date datePP, String nomProduitPP, String uniteProduitPP, Double prixAchatPP, Double prixVentePP, Produit produit) {
        this.datePP = datePP;
        this.nomProduitPP = nomProduitPP;
        this.uniteProduitPP = uniteProduitPP;
        this.prixAchatPP = prixAchatPP;
        this.prixVentePP = prixVentePP;
        this.produit = produit;
    }

    public PrixProduit(Date datePP, String nomProduitPP, String uniteProduitPP, Double prixAchatPP, Double prixVentePP) {
        this.datePP = datePP;
        this.nomProduitPP = nomProduitPP;
        this.uniteProduitPP = uniteProduitPP;
        this.prixAchatPP = prixAchatPP;
        this.prixVentePP = prixVentePP;
    }

    public PrixProduit(Long id_PP, Date datePP, String nomProduitPP, String uniteProduitPP, Double prixAchatPP, Double prixVentePP) {
        this.id_PP = id_PP;
        this.datePP = datePP;
        this.nomProduitPP = nomProduitPP;
        this.uniteProduitPP = uniteProduitPP;
        this.prixAchatPP = prixAchatPP;
        this.prixVentePP = prixVentePP;
    }
}
