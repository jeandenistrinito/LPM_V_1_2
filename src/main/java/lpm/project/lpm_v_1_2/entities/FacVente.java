package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class FacVente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_FacVente;
    private String facVente;
    private Date dateFacVente;
    private String nomClient;
    private double montant;
    private double remiseVente;
    private double netaPayerVente;
    //@OneToMany(mappedBy = "facVente",fetch = FetchType.LAZY)
    //private Collection<Vente> venteCollection;

    public FacVente(String facVente) {
        this.facVente = facVente;
    }

    public FacVente(String facVente, Date dateFacVente) {
        this.facVente = facVente;
        this.dateFacVente = dateFacVente;
    }

    public FacVente(String facVente, Date dateFacVente, String nomClient, double montant) {
        this.facVente = facVente;
        this.dateFacVente = dateFacVente;
        this.nomClient = nomClient;
        this.montant = montant;
    }

    public FacVente(int id_FacVente, String facVente, Date dateFacVente, String nomClient, double montant) {
        this.id_FacVente = id_FacVente;
        this.facVente = facVente;
        this.dateFacVente = dateFacVente;
        this.nomClient = nomClient;
        this.montant = montant;
    }

    public FacVente(String facVente, Date dateFacVente, String nomClient, double montant, double remiseVente, double netaPayerVente) {
        this.facVente = facVente;
        this.dateFacVente = dateFacVente;
        this.nomClient = nomClient;
        this.montant = montant;
        this.remiseVente = remiseVente;
        this.netaPayerVente = netaPayerVente;
    }

    public FacVente(int id_FacVente, String facVente, Date dateFacVente, String nomClient, double montant, double remiseVente, double netaPayerVente) {
        this.id_FacVente = id_FacVente;
        this.facVente = facVente;
        this.dateFacVente = dateFacVente;
        this.nomClient = nomClient;
        this.montant = montant;
        this.remiseVente = remiseVente;
        this.netaPayerVente = netaPayerVente;
    }
}