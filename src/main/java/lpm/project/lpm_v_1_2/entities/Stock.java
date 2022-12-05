package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@AllArgsConstructor @NoArgsConstructor
public class Stock implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Stock;
    private Date dateStock;
    private int codeProduit;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imageProduit;
    private String nomProduit;
    private int niveauProduit;
    private double quantiteProduit;
    private double quantiteStock;
    private String uniteProduit;
    private double poidsproduit;
    private double prixAchat;
    private double prixVente;
    private double margeStock;
    private double montantTotalProduit;
    @ManyToOne @JoinColumn(name = "Id_Produit")
    private Produit produit;

    public Stock(Date dateStock, int codeProduit, String imageProduit, String nomProduit, int niveauProduit, double quantiteProduit, double quantiteStock, String uniteProduit, double poidsproduit, double prixAchat, double prixVente, double margeStock, double montantTotalProduit) {
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.imageProduit = imageProduit;
        this.nomProduit = nomProduit;
        this.niveauProduit = niveauProduit;
        this.quantiteProduit = quantiteProduit;
        this.quantiteStock = quantiteStock;
        this.uniteProduit = uniteProduit;
        this.poidsproduit = poidsproduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.margeStock = margeStock;
        this.montantTotalProduit = montantTotalProduit;
    }

    public Stock(Long id_Stock, Date dateStock, int codeProduit, String imageProduit, String nomProduit, int niveauProduit, double quantiteProduit, double quantiteStock, String uniteProduit, double poidsproduit, double prixAchat, double prixVente, double margeStock, double montantTotalProduit) {
        this.id_Stock = id_Stock;
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.imageProduit = imageProduit;
        this.nomProduit = nomProduit;
        this.niveauProduit = niveauProduit;
        this.quantiteProduit = quantiteProduit;
        this.quantiteStock = quantiteStock;
        this.uniteProduit = uniteProduit;
        this.poidsproduit = poidsproduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.margeStock = margeStock;
        this.montantTotalProduit = montantTotalProduit;
    }

    public Stock(Date dateStock, int codeProduit, String nomProduit, double quantiteProduit, String uniteProduit, double poidsproduit, double prixAchat, double prixVente) {
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.poidsproduit = poidsproduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
    }

    public Stock(Date dateStock, int codeProduit, String nomProduit, double quantiteProduit, String uniteProduit, double poidsproduit, double prixAchat, double prixVente, double montantTotalProduit) {
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.poidsproduit = poidsproduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.montantTotalProduit = montantTotalProduit;
    }

    public Stock(Long id_Stock, Date dateStock, int codeProduit, String nomProduit, double quantiteProduit, String uniteProduit, double prixAchat, double prixVente, double montantTotalProduit) {
        this.id_Stock = id_Stock;
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.montantTotalProduit = montantTotalProduit;
    }

    public Stock(Long id_Stock, Date dateStock, int codeProduit, String nomProduit, double quantiteProduit, String uniteProduit, double poidsproduit, double prixAchat, double prixVente, double montantTotalProduit) {
        this.id_Stock = id_Stock;
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.poidsproduit = poidsproduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.montantTotalProduit = montantTotalProduit;
    }

    public Stock(Date dateStock, String nomProduit, double quantiteProduit, String uniteProduit, double prixAchat, double prixVente, int codeProduit) {
        this.dateStock = dateStock;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.codeProduit = codeProduit;
    }

    public Stock(Long id_Stock, Date dateStock, String nomProduit, double quantiteProduit, String uniteProduit, double prixAchat, double prixVente, int codeProduit) {
        this.id_Stock = id_Stock;
        this.dateStock = dateStock;
        this.nomProduit = nomProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.codeProduit = codeProduit;
    }

    public Stock(Date dateStock, int codeProduit, String imageProduit, String nomProduit, int niveauProduit, double quantiteProduit, String uniteProduit, double poidsproduit, double prixAchat, double prixVente, double montantTotalProduit) {
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.imageProduit = imageProduit;
        this.nomProduit = nomProduit;
        this.niveauProduit = niveauProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.poidsproduit = poidsproduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.montantTotalProduit = montantTotalProduit;
    }

    public Stock(Date dateStock, int codeProduit, String imageProduit, String nomProduit, int niveauProduit, double quantiteProduit, double quantiteStock, String uniteProduit, double poidsproduit, double prixAchat, double prixVente, double montantTotalProduit) {
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.imageProduit = imageProduit;
        this.nomProduit = nomProduit;
        this.niveauProduit = niveauProduit;
        this.quantiteProduit = quantiteProduit;
        this.quantiteStock = quantiteStock;
        this.uniteProduit = uniteProduit;
        this.poidsproduit = poidsproduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.montantTotalProduit = montantTotalProduit;
    }

    public Stock(Date dateStock, int codeProduit, String imageProduit, String nomProduit, int niveauProduit, double quantiteProduit, String uniteProduit, double poidsproduit, double prixAchat, double prixVente) {
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.imageProduit = imageProduit;
        this.nomProduit = nomProduit;
        this.niveauProduit = niveauProduit;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.poidsproduit = poidsproduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
    }

    public Stock(Long id_Stock, Date dateStock, int codeProduit, String imageProduit, String nomProduit, int niveauProduit, double quantiteProduit, double quantiteStock, String uniteProduit, double poidsproduit, double prixAchat, double prixVente, double montantTotalProduit) {
        this.id_Stock = id_Stock;
        this.dateStock = dateStock;
        this.codeProduit = codeProduit;
        this.imageProduit = imageProduit;
        this.nomProduit = nomProduit;
        this.niveauProduit = niveauProduit;
        this.quantiteProduit = quantiteProduit;
        this.quantiteStock = quantiteStock;
        this.uniteProduit = uniteProduit;
        this.poidsproduit = poidsproduit;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.montantTotalProduit = montantTotalProduit;
    }

    public double getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(double quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public Long getId_Stock() {
        return id_Stock;
    }

    public void setId_Stock(Long id_Stock) {
        this.id_Stock = id_Stock;
    }

    public Date getDateStock() {
        return dateStock;
    }

    public void setDateStock(Date dateStock) {
        this.dateStock = dateStock;
    }

    public int getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(int codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getImageProduit() {
        return imageProduit;
    }

    public void setImageProduit(String imageProduit) {
        this.imageProduit = imageProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getNiveauProduit() {
        return niveauProduit;
    }

    public void setNiveauProduit(int niveauProduit) {
        this.niveauProduit = niveauProduit;
    }

    public double getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(double quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }

    public String getUniteProduit() {
        return uniteProduit;
    }

    public void setUniteProduit(String uniteProduit) {
        this.uniteProduit = uniteProduit;
    }

    public double getPoidsproduit() {
        return poidsproduit;
    }

    public void setPoidsproduit(double poidsproduit) {
        this.poidsproduit = poidsproduit;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public double getMontantTotalProduit() {
        return montantTotalProduit;
    }

    public void setMontantTotalProduit(double montantTotalProduit) {
        this.montantTotalProduit = montantTotalProduit;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getMargeStock() {
        return margeStock;
    }

    public void setMargeStock(double margeStock) {
        this.margeStock = margeStock;
    }
}
