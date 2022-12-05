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
public class VenteProduit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_VenteProduit;
    private Date dateVenteProduit;
    private String nomProduit;
    private double quantiteProduit;
    private String uniteProduit;
    private double prixAchatProduit;
    private double prixVenteProduit;
    private double montant;
    private String client;

    public VenteProduit(Date dateVenteProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixAchatProduit, double prixVenteProduit) {
        this.dateVenteProduit = dateVenteProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.prixVenteProduit = prixVenteProduit;
    }

    public VenteProduit(Date dateVenteProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixAchatProduit, double prixVenteProduit, double montant) {
        this.dateVenteProduit = dateVenteProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.montant = montant;
    }

    public VenteProduit(Date dateVenteProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixAchatProduit, double prixVenteProduit, double montant, String client) {
        this.dateVenteProduit = dateVenteProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.montant = montant;
        this.client = client;
    }

    public VenteProduit(Date dateVenteProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixAchatProduit, double prixVenteProduit, String client) {
        this.dateVenteProduit = dateVenteProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.client = client;
    }
}
