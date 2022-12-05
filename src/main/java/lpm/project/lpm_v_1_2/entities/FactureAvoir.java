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

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class FactureAvoir implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacAvoir;
    private String facAvoir;
    private String refFacture;
    private Date dateFacAvoire;
    private String nomClient;
    private String nomProduit;
    private double quantiteProduit;
    private String uniteProduit;
    private double prixUnitaireProduit;
    private double montantFacVente;

    public FactureAvoir(String facAvoir, String refFacture, Date dateFacAvoire, String nomClient, String nomProduit, double quantiteProduit, String uniteProduit, double prixUnitaireProduit, double montantFacVente) {
        this.facAvoir = facAvoir;
        this.refFacture = refFacture;
        this.dateFacAvoire = dateFacAvoire;
        this.nomClient = nomClient;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.montantFacVente = montantFacVente;
    }
}
