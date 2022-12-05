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
public class BRtemp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_AchatProduit;
    private int br;
    private Date dateAchatProduit;
    private String nomProduit;
    private double quantiteProduit;
    private String uniteProduit;
    private double prixVenteProduit;
    private double prixAchatProduit;
    private double montant;
    private String fournisseur;

    public BRtemp(int br, Date dateAchatProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixVenteProduit, double prixAchatProduit, double montant, String fournisseur) {
        this.br = br;
        this.dateAchatProduit = dateAchatProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.montant = montant;
        this.fournisseur = fournisseur;
    }

    public BRtemp(Date dateAchatProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixVenteProduit, double prixAchatProduit, double montant, String fournisseur) {
        this.dateAchatProduit = dateAchatProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.montant = montant;
        this.fournisseur = fournisseur;
    }
}
