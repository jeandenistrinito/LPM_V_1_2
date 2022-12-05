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
public class FacVtemp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_VenteProduit;
    private int br;
    private Date dateVenteProduit;
    private String nomProduit;
    private double quantiteProduit;
    private String uniteProduit;
    private double prixVenteProduit;
    private double prixAchatProduit;
    private double montant;
    private String Client;

    public FacVtemp(Date dateVenteProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixVenteProduit, double prixAchatProduit, double montant, String client) {
        this.dateVenteProduit = dateVenteProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.montant = montant;
        Client = client;
    }

    public FacVtemp(int br, Date dateVenteProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixVenteProduit, double prixAchatProduit, double montant, String client) {
        this.br = br;
        this.dateVenteProduit = dateVenteProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.montant = montant;
        Client = client;
    }
}
