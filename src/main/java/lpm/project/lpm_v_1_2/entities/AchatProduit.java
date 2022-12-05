package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AchatProduit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_AchatProduit;
    private Date dateAchatProduit;
    private String nomProduit;
    private double quantiteProduit;
    private String uniteProduit;
    private double prixVenteProduit;
    private double prixAchatProduit;
    private double montant;
    private String fournisseur;

    public AchatProduit(Date dateAchatProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixVenteProduit, double prixAchatProduit) {
        this.dateAchatProduit = dateAchatProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.prixAchatProduit = prixAchatProduit;
    }

    public AchatProduit(Date dateAchatProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixVenteProduit, double prixAchatProduit, double montant) {
        this.dateAchatProduit = dateAchatProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.montant = montant;
    }

    public AchatProduit(Date dateAchatProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixVenteProduit, double prixAchatProduit, double montant, String fournisseur) {
        this.dateAchatProduit = dateAchatProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.montant = montant;
        this.fournisseur = fournisseur;
    }

    public AchatProduit(Date dateAchatProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixVenteProduit, double prixAchatProduit, String fournisseur) {
        this.dateAchatProduit = dateAchatProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.fournisseur = fournisseur;
    }
}
