package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @NoArgsConstructor
public class Caisse implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Caisse;
    private String refCaisse;
    private Date dateCaisse;
    private String designationCaisse;
    private Double montantCaisse;
    private Double encaissement;
    private Double decaissement;
    private String description;
    private String modePayement;
    private String refVente;
    private String facVente;
    @ManyToOne @JoinColumn(name = "Id_Facture")
    private Facture facture;
    @ManyToOne @JoinColumn(name = "Id_Utilisateur")
    private Utilisateur utilisateur;
    @ManyToOne @JoinColumn(name = "Id_BonDeReception")
    private BonDeReception bonDeReception;
    @ManyToOne @JoinColumn(name = "Id_Magasin")
    private Magasin magasin;

    public Caisse(Long id_Caisse, String refCaisse, Date dateCaisse, String designationCaisse, Double montantCaisse, String refVente, String facVente) {
        this.id_Caisse = id_Caisse;
        this.refCaisse = refCaisse;
        this.dateCaisse = dateCaisse;
        this.designationCaisse = designationCaisse;
        this.montantCaisse = montantCaisse;
        this.refVente = refVente;
        this.facVente = facVente;
    }

    public Caisse(String refCaisse, Date dateCaisse, String designationCaisse, Double montantCaisse, String description, String refVente, String facVente) {
        this.refCaisse = refCaisse;
        this.dateCaisse = dateCaisse;
        this.designationCaisse = designationCaisse;
        this.montantCaisse = montantCaisse;
        this.description = description;
        this.refVente = refVente;
        this.facVente = facVente;
    }

    public Caisse(Long id_Caisse, String refCaisse, Date dateCaisse, String designationCaisse, Double montantCaisse, Double encaissement, Double decaissement, String modePayement) {
        this.id_Caisse = id_Caisse;
        this.refCaisse = refCaisse;
        this.dateCaisse = dateCaisse;
        this.designationCaisse = designationCaisse;
        this.montantCaisse = montantCaisse;
        this.encaissement = encaissement;
        this.decaissement = decaissement;
        this.modePayement = modePayement;
    }

    public Caisse(String refCaisse, Date dateCaisse, String designationCaisse, Double montantCaisse, Double encaissement, Double decaissement, String modePayement, Facture facture, Utilisateur utilisateur, BonDeReception bonDeReception) {
        this.refCaisse = refCaisse;
        this.dateCaisse = dateCaisse;
        this.designationCaisse = designationCaisse;
        this.montantCaisse = montantCaisse;
        this.encaissement = encaissement;
        this.decaissement = decaissement;
        this.modePayement = modePayement;
        this.facture = facture;
        this.utilisateur = utilisateur;
        this.bonDeReception = bonDeReception;
    }

    public Caisse(Long id_Caisse, String refCaisse, Date dateCaisse, String designationCaisse, Double montantCaisse, Double encaissement, Double decaissement, String modePayement, Facture facture, Utilisateur utilisateur, BonDeReception bonDeReception, Magasin magasin) {
        this.id_Caisse = id_Caisse;
        this.refCaisse = refCaisse;
        this.dateCaisse = dateCaisse;
        this.designationCaisse = designationCaisse;
        this.montantCaisse = montantCaisse;
        this.encaissement = encaissement;
        this.decaissement = decaissement;
        this.modePayement = modePayement;
        this.facture = facture;
        this.utilisateur = utilisateur;
        this.bonDeReception = bonDeReception;
        this.magasin = magasin;
    }

    public Caisse(String refCaisse, Date dateCaisse, String designationCaisse, Double encaissement, Double decaissement, String description, Utilisateur utilisateur) {
        this.refCaisse = refCaisse;
        this.dateCaisse = dateCaisse;
        this.designationCaisse = designationCaisse;
        this.encaissement = encaissement;
        this.decaissement = decaissement;
        this.description = description;
        this.utilisateur = utilisateur;
    }

    public Caisse(String refCaisse, Date dateCaisse, String designationCaisse, Double encaissement, Double decaissement, String description) {
        this.refCaisse = refCaisse;
        this.dateCaisse = dateCaisse;
        this.designationCaisse = designationCaisse;
        this.encaissement = encaissement;
        this.decaissement = decaissement;
        this.description = description;
    }

    public Caisse(String refCaisse, Date dateCaisse, String designationCaisse,Double montantCaisse, Double encaissement, Double decaissement, String description) {
        this.refCaisse = refCaisse;
        this.dateCaisse = dateCaisse;
        this.designationCaisse = designationCaisse;
        this.montantCaisse = montantCaisse;
        this.encaissement = encaissement;
        this.decaissement = decaissement;
        this.description = description;
    }


}
