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
public class Achat implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Achat;
    private Date dateAchat;
    @ManyToOne @JoinColumn(name = "Id_refAchat")
    private RefAchat refAchat;
    @ManyToOne @JoinColumn(name = "Id_Bentree")
    private BeAchat beAchat;
    private String nomArticle;
    private double quantiteProduit;
    private String uniteProduit;
    private double prixAchatProduit;
    private double montant;
    @ManyToOne @JoinColumn(name = "Id_Fournisseur")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "achat",fetch = FetchType.LAZY)
    private Collection<BonDeReception> bonDeReceptionCollection;

    public Achat(Long id_Achat, Date dateAchat, RefAchat refAchat, Fournisseur fournisseur) {
        this.id_Achat = id_Achat;
        this.dateAchat = dateAchat;
        this.refAchat = refAchat;
        this.fournisseur = fournisseur;
    }

    public Achat(Date dateAchat, RefAchat refAchat, Fournisseur fournisseur) {
        this.dateAchat = dateAchat;
        this.refAchat = refAchat;
        this.fournisseur = fournisseur;
    }

    public Achat(Date dateAchat, RefAchat refAchat, String nomArticle, double quantiteProduit, String uniteProduit, double prixAchatProduit, double montant, Fournisseur fournisseur) {
        this.dateAchat = dateAchat;
        this.refAchat = refAchat;
        this.nomArticle = nomArticle;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.montant = montant;
        this.fournisseur = fournisseur;
    }

    public Achat(Date dateAchat, RefAchat refAchat, BeAchat beAchat, String nomArticle, double quantiteProduit, String uniteProduit, double prixAchatProduit, double montant, Fournisseur fournisseur) {
        this.dateAchat = dateAchat;
        this.refAchat = refAchat;
        this.beAchat = beAchat;
        this.nomArticle = nomArticle;
        this.quantiteProduit = quantiteProduit;
        this.uniteProduit = uniteProduit;
        this.prixAchatProduit = prixAchatProduit;
        this.montant = montant;
        this.fournisseur = fournisseur;
    }
}
