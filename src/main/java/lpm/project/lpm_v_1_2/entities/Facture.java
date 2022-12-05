package lpm.project.lpm_v_1_2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Facture implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Facture;
    private String nomPrenomClient;
    private String numFacture;
    private Date dateFacture;
    private String nomProduit;
    private String uniteFature;
    private Double quantiteFacture;
    private Double prixUnitaireProduit;
    private Double prixTotalProduit;
    private String observation;
    @ManyToOne @JoinColumn(name = "Id_Vente")
    private Vente vente;
    @OneToMany(mappedBy = "facture",fetch = FetchType.LAZY)
    private Collection<Caisse> caisseCollection;

    public Facture() {
    }

    public Facture(String nomPrenomClient, String numFacture, Date dateFacture, String nomProduit, String uniteFature, Double quantiteFacture, Double prixUnitaireProduit, Double prixTotalProduit, String observation) {
        this.nomPrenomClient = nomPrenomClient;
        this.numFacture = numFacture;
        this.dateFacture = dateFacture;
        this.nomProduit = nomProduit;
        this.uniteFature = uniteFature;
        this.quantiteFacture = quantiteFacture;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.prixTotalProduit = prixTotalProduit;
        this.observation = observation;
    }

    public Facture(Long id_Facture, String nomPrenomClient, String numFacture, Date dateFacture, String nomProduit, String uniteFature, Double quantiteFacture, Double prixUnitaireProduit, Double prixTotalProduit, String observation) {
        this.id_Facture = id_Facture;
        this.nomPrenomClient = nomPrenomClient;
        this.numFacture = numFacture;
        this.dateFacture = dateFacture;
        this.nomProduit = nomProduit;
        this.uniteFature = uniteFature;
        this.quantiteFacture = quantiteFacture;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.prixTotalProduit = prixTotalProduit;
        this.observation = observation;
    }

    public Facture(String nomPrenomClient, String numFacture, Date dateFacture, String nomProduit, String uniteFature, Double quantiteFacture, Double prixUnitaireProduit, Double prixTotalProduit, String observation, Vente vente) {
        this.nomPrenomClient = nomPrenomClient;
        this.numFacture = numFacture;
        this.dateFacture = dateFacture;
        this.nomProduit = nomProduit;
        this.uniteFature = uniteFature;
        this.quantiteFacture = quantiteFacture;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.prixTotalProduit = prixTotalProduit;
        this.observation = observation;
        this.vente = vente;
    }

    public Facture(Long id_Facture, String nomPrenomClient, String numFacture, Date dateFacture, String nomProduit, String uniteFature, Double quantiteFacture, Double prixUnitaireProduit, Double prixTotalProduit, String observation, Vente vente) {
        this.id_Facture = id_Facture;
        this.nomPrenomClient = nomPrenomClient;
        this.numFacture = numFacture;
        this.dateFacture = dateFacture;
        this.nomProduit = nomProduit;
        this.uniteFature = uniteFature;
        this.quantiteFacture = quantiteFacture;
        this.prixUnitaireProduit = prixUnitaireProduit;
        this.prixTotalProduit = prixTotalProduit;
        this.observation = observation;
        this.vente = vente;
    }

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public Collection<Caisse> getCaisseCollection() {
        return caisseCollection;
    }

    public void setCaisseCollection(Collection<Caisse> caisseCollection) {
        this.caisseCollection = caisseCollection;
    }

    public Long getId_Facture() {
        return id_Facture;
    }

    public void setId_Facture(Long id_Facture) {
        this.id_Facture = id_Facture;
    }

    public String getNomPrenomClient() {
        return nomPrenomClient;
    }

    public void setNomPrenomClient(String nomPrenomClient) {
        this.nomPrenomClient = nomPrenomClient;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getUniteFature() {
        return uniteFature;
    }

    public void setUniteFature(String uniteFature) {
        this.uniteFature = uniteFature;
    }

    public Double getQuantiteFacture() {
        return quantiteFacture;
    }

    public void setQuantiteFacture(Double quantiteFacture) {
        this.quantiteFacture = quantiteFacture;
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
