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
public class Vente implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Vente;
    private Date dateVente;
    //@ManyToOne @JoinColumn(name = "Id_refVente")
    private String refVente;
    //@ManyToOne @JoinColumn(name = "Id_FacVente")
    private String facVente;
    private String nomArticle;
    private double quantiteProduit;
    private String uniteProduit;
    private double prixVenteProduit;
    private double montant;
    //@ManyToOne @JoinColumn(name = "Id_Client")
    private String client;
    @OneToMany(mappedBy = "vente",fetch = FetchType.LAZY)
    private Collection<Facture> factureCollection;

    public Vente(Long id_Vente, Date dateVente, String refVente, String client) {
        this.id_Vente = id_Vente;
        this.dateVente = dateVente;
        this.refVente = refVente;
        this.client = client;
    }

    public Vente(Date dateVente, String refVente, String client) {
        this.dateVente = dateVente;
        this.refVente = refVente;
        this.client = client;
    }

    public Vente(Date dateVente, String refVente, String nomArticle, double quantiteProduit, String uniteProduit, double prixVenteProduit, double montant, String client) {
        this.dateVente = dateVente;
        this.refVente = refVente;
        this.nomArticle = nomArticle;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.montant = montant;
        this.client = client;
    }

    public Vente(Date dateVente, String refVente, String facVente, String nomArticle, double quantiteProduit, String uniteProduit, double prixVenteProduit, double montant, String client) {
        this.dateVente = dateVente;
        this.refVente = refVente;
        this.facVente = facVente;
        this.nomArticle = nomArticle;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixVenteProduit = prixVenteProduit;
        this.montant = montant;
        this.client = client;
    }
}
