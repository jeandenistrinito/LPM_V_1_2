package lpm.project.lpm_v_1_2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Fournisseur implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Fournisseur;
    private String nomFournisseur;
    private String adresseFournisseur;
    private String cinFournisseur;
    private String telFournisseur;
    private String nifFournisseur;
    private String cifFournisseur;
    private String statistiqueFournisseur;
    @OneToMany(mappedBy = "fournisseur",fetch = FetchType.LAZY)
    private Collection<Achat> achatCollection;

    public Fournisseur() {
    }

    public Fournisseur(String nomFournisseur, String adresseFournisseur, String cinFournisseur, String telFournisseur, String nifFournisseur, String cifFournisseur, String statistiqueFournisseur) {
        this.nomFournisseur = nomFournisseur;
        this.adresseFournisseur = adresseFournisseur;
        this.cinFournisseur = cinFournisseur;
        this.telFournisseur = telFournisseur;
        this.nifFournisseur = nifFournisseur;
        this.cifFournisseur = cifFournisseur;
        this.statistiqueFournisseur = statistiqueFournisseur;
    }

    public Fournisseur(Long id_Fournisseur, String nomFournisseur, String adresseFournisseur, String cinFournisseur, String telFournisseur, String nifFournisseur, String cifFournisseur, String statistiqueFournisseur) {
        this.id_Fournisseur = id_Fournisseur;
        this.nomFournisseur = nomFournisseur;
        this.adresseFournisseur = adresseFournisseur;
        this.cinFournisseur = cinFournisseur;
        this.telFournisseur = telFournisseur;
        this.nifFournisseur = nifFournisseur;
        this.cifFournisseur = cifFournisseur;
        this.statistiqueFournisseur = statistiqueFournisseur;
    }


    public Collection<Achat> getAchatCollection() {
        return achatCollection;
    }

    public void setAchatCollection(Collection<Achat> achatCollection) {
        this.achatCollection = achatCollection;
    }

    public Long getId_Fournisseur() {
        return id_Fournisseur;
    }

    public void setId_Fournisseur(Long id_Fournisseur) {
        this.id_Fournisseur = id_Fournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur = adresseFournisseur;
    }

    public String getCinFournisseur() {
        return cinFournisseur;
    }

    public void setCinFournisseur(String cinFournisseur) {
        this.cinFournisseur = cinFournisseur;
    }

    public String getTelFournisseur() {
        return telFournisseur;
    }

    public void setTelFournisseur(String telFournisseur) {
        this.telFournisseur = telFournisseur;
    }

    public String getNifFournisseur() {
        return nifFournisseur;
    }

    public void setNifFournisseur(String nifFournisseur) {
        this.nifFournisseur = nifFournisseur;
    }

    public String getCifFournisseur() {
        return cifFournisseur;
    }

    public void setCifFournisseur(String cifFournisseur) {
        this.cifFournisseur = cifFournisseur;
    }

    public String getStatistiqueFournisseur() {
        return statistiqueFournisseur;
    }

    public void setStatistiqueFournisseur(String statistiqueFournisseur) {
        this.statistiqueFournisseur = statistiqueFournisseur;
    }
}
