package lpm.project.lpm_v_1_2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Entity
public class PayementVente implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPayeVente;
    private Date datePayementVente;
    private String refVente;
    private String facVente;
    private String nomProduit;
    private double montantPayement;
    private String typePayement;
    private String nomClient;

    public PayementVente() {
    }



    public PayementVente(Date datePayementVente, String refVente, String facVente, double montantPayement, String typePayement, String nomClient) {
        this.datePayementVente = datePayementVente;
        this.refVente = refVente;
        this.facVente = facVente;
        this.montantPayement = montantPayement;
        this.typePayement = typePayement;
        this.nomClient = nomClient;
    }

    public PayementVente(Long idPayeVente, Date datePayementVente, String refVente, String facVente, String nomProduit, double montantPayement, String typePayement, String nomClient) {
        this.idPayeVente = idPayeVente;
        this.datePayementVente = datePayementVente;
        this.refVente = refVente;
        this.facVente = facVente;
        this.nomProduit = nomProduit;
        this.montantPayement = montantPayement;
        this.typePayement = typePayement;
        this.nomClient = nomClient;
    }

    public PayementVente(Date datePayementVente, String refVente, String facVente, String nomProduit, double montantPayement, String typePayement, String nomClient) {
        this.datePayementVente = datePayementVente;
        this.refVente = refVente;
        this.facVente = facVente;
        this.nomProduit = nomProduit;
        this.montantPayement = montantPayement;
        this.typePayement = typePayement;
        this.nomClient = nomClient;
    }

    public Date getDatePayementVente() {
        return datePayementVente;
    }

    public void setDatePayementVente(Date datePayementVente) {
        this.datePayementVente = datePayementVente;
    }

    public Long getIdPayeVente() {
        return idPayeVente;
    }

    public void setIdPayeVente(Long idPayeVente) {
        this.idPayeVente = idPayeVente;
    }

    public String getRefVente() {
        return refVente;
    }

    public void setRefVente(String refVente) {
        this.refVente = refVente;
    }

    public String getFacVente() {
        return facVente;
    }

    public void setFacVente(String facVente) {
        this.facVente = facVente;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getMontantPayement() {
        return montantPayement;
    }

    public void setMontantPayement(double montantPayement) {
        this.montantPayement = montantPayement;
    }

    public String getTypePayement() {
        return typePayement;
    }

    public void setTypePayement(String typePayement) {
        this.typePayement = typePayement;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
}
