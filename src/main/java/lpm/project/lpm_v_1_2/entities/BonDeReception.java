package lpm.project.lpm_v_1_2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
public class BonDeReception implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_BR;
    private String nomPrenomFRS;
    private String numBR;
    private Date dateBR;
    private String nomProduit;
    private String uniteProduit;
    private Double quantiteProduit;
    private Double prixUnitaireProduit;
    private Double prixTotalProduit;
    private String observation;
    @ManyToOne @JoinColumn(name = "Id_Achat")
    private Achat achat;
    @OneToMany(mappedBy = "bonDeReception")
    private Collection<Caisse> caisseCollection;

    public BonDeReception() {
    }

    public BonDeReception(String nomPrenomFRS, String numBR, Date dateBR, String nomProduit, String uniteProduit, Double quantiteProduit, Double prixUnitaireProduit, Double prixTotalProduit, String observation) {
        this.nomPrenomFRS = nomPrenomFRS;
        this.numBR = numBR;
        this.dateBR = dateBR;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.quantiteProduit = quantiteProduit;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.prixTotalProduit = prixTotalProduit;
        this.observation = observation;
    }

    public BonDeReception(Long id_BR, String nomPrenomFRS, String numBR, Date dateBR, String nomProduit, String uniteProduit, Double quantiteProduit, Double prixUnitaireProduit, Double prixTotalProduit, String observation) {
        this.id_BR = id_BR;
        this.nomPrenomFRS = nomPrenomFRS;
        this.numBR = numBR;
        this.dateBR = dateBR;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.quantiteProduit = quantiteProduit;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.prixTotalProduit = prixTotalProduit;
        this.observation = observation;
    }

    public BonDeReception(String nomPrenomFRS, String numBR, Date dateBR, String nomProduit, String uniteProduit, Double quantiteProduit, Double prixUnitaireProduit, Double prixTotalProduit, String observation, Achat achat) {
        this.nomPrenomFRS = nomPrenomFRS;
        this.numBR = numBR;
        this.dateBR = dateBR;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.quantiteProduit = quantiteProduit;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.prixTotalProduit = prixTotalProduit;
        this.observation = observation;
        this.achat = achat;
    }

    public BonDeReception(Long id_BR, String nomPrenomFRS, String numBR, Date dateBR, String nomProduit, String uniteProduit, Double quantiteProduit, Double prixUnitaireProduit, Double prixTotalProduit, String observation, Achat achat) {
        this.id_BR = id_BR;
        this.nomPrenomFRS = nomPrenomFRS;
        this.numBR = numBR;
        this.dateBR = dateBR;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.quantiteProduit = quantiteProduit;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.prixTotalProduit = prixTotalProduit;
        this.observation = observation;
        this.achat = achat;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public Collection<Caisse> getCaisseCollection() {
        return caisseCollection;
    }

    public void setCaisseCollection(Collection<Caisse> caisseCollection) {
        this.caisseCollection = caisseCollection;
    }

    public Long getId_BR() {
        return id_BR;
    }

    public void setId_BR(Long id_BR) {
        this.id_BR = id_BR;
    }

    public String getNomPrenomFRS() {
        return nomPrenomFRS;
    }

    public void setNomPrenomFRS(String nomPrenomFRS) {
        this.nomPrenomFRS = nomPrenomFRS;
    }

    public String getNumBR() {
        return numBR;
    }

    public void setNumBR(String numBR) {
        this.numBR = numBR;
    }

    public Date getDateBR() {
        return dateBR;
    }

    public void setDateBR(Date dateBR) {
        this.dateBR = dateBR;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getUniteProduit() {
        return uniteProduit;
    }

    public void setUniteProduit(String uniteProduit) {
        this.uniteProduit = uniteProduit;
    }

    public Double getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(Double quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public Double getPrixUnitaireProduit() {
        return prixUnitaireProduit;
    }

    public void setPrixUnitaireProduit(Double prixUnitaireProduit) {
        this.prixUnitaireProduit = prixUnitaireProduit;
    }

    public Double getPrixTotalProduit() {
        return prixTotalProduit;
    }

    public void setPrixTotalProduit(Double prixTotalProduit) {
        this.prixTotalProduit = prixTotalProduit;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
