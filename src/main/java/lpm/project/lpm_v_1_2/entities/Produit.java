package lpm.project.lpm_v_1_2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
public class Produit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Produit;
    private int niveauProduit;
    private int codeProduit;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String photoProduit;
    private String nomProduit;
    private String uniteProduit;
    private Double quantiteProduit;
    private Double poidsProduit;
    @ManyToOne @JoinColumn(name = "Id_Categorie")
    private Categorie categorie;
    /*@OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    private Collection<Vente> venteCollection;*/
    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    private Collection<Stock> stockCollection;


    public Produit() {
    }

    public Produit(int codeProduit, String nomProduit, String uniteProduit, Double poidsProduit) {
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.poidsProduit = poidsProduit;
    }

    public Produit(Long id_Produit, int codeProduit, String nomProduit, String uniteProduit, Double poidsProduit) {
        this.id_Produit = id_Produit;
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.poidsProduit = poidsProduit;
    }

    public Produit(int codeProduit, String nomProduit, String uniteProduit, Double poidsProduit, Categorie categorie) {
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.poidsProduit = poidsProduit;
        this.categorie = categorie;
    }

    public Produit(int niveauProduit, int codeProduit, String nomProduit, String uniteProduit, Double poidsProduit, Categorie categorie) {
        this.niveauProduit = niveauProduit;
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.poidsProduit = poidsProduit;
        this.categorie = categorie;
    }

    public Produit(Long id_Produit, int niveauProduit, int codeProduit, String nomProduit, String uniteProduit, Double poidsProduit, Categorie categorie) {
        this.id_Produit = id_Produit;
        this.niveauProduit = niveauProduit;
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.poidsProduit = poidsProduit;
        this.categorie = categorie;
    }

    public Produit(Long id_Produit, int niveauProduit, int codeProduit, String photoProduit, String nomProduit, String uniteProduit, Double poidsProduit, Categorie categorie) {
        this.id_Produit = id_Produit;
        this.niveauProduit = niveauProduit;
        this.codeProduit = codeProduit;
        this.photoProduit = photoProduit;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.poidsProduit = poidsProduit;
        this.categorie = categorie;
    }

    public Produit(Long id_Produit, int niveauProduit, int codeProduit, String photoProduit, String nomProduit, String uniteProduit, Double quantiteProduit, Double poidsProduit, Categorie categorie) {
        this.id_Produit = id_Produit;
        this.niveauProduit = niveauProduit;
        this.codeProduit = codeProduit;
        this.photoProduit = photoProduit;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.quantiteProduit = quantiteProduit;
        this.poidsProduit = poidsProduit;
        this.categorie = categorie;
    }

    public Produit(int niveauProduit, int codeProduit, String photoProduit, String nomProduit, String uniteProduit, Double quantiteProduit, Double poidsProduit, Categorie categorie) {
        this.niveauProduit = niveauProduit;
        this.codeProduit = codeProduit;
        this.photoProduit = photoProduit;
        this.nomProduit = nomProduit;
        this.uniteProduit = uniteProduit;
        this.quantiteProduit = quantiteProduit;
        this.poidsProduit = poidsProduit;
        this.categorie = categorie;
    }

    public Double getQuantiteProduit() {
        return quantiteProduit;
    }

    public void setQuantiteProduit(Double quantiteProduit) {
        this.quantiteProduit = quantiteProduit;
    }


    public String getPhotoProduit() {
        return photoProduit;
    }

    public void setPhotoProduit(String photoProduit) {
        this.photoProduit = photoProduit;
    }

    public int getNiveauProduit() {
        return niveauProduit;
    }

    public void setNiveauProduit(int niveauProduit) {
        this.niveauProduit = niveauProduit;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    /*public Collection<Vente> getVenteCollection() {
        return venteCollection;
    }

    public void setVenteCollection(Collection<Vente> venteCollection) {
        this.venteCollection = venteCollection;
    }*/

    public Long getId_Produit() {
        return id_Produit;
    }

    public void setId_Produit(Long id_Produit) {
        this.id_Produit = id_Produit;
    }

    public int getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(int codeProduit) {
        this.codeProduit = codeProduit;
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

    public Double getPoidsProduit() {
        return poidsProduit;
    }

    public void setPoidsProduit(Double poidsProduit) {
        this.poidsProduit = poidsProduit;
    }
}
