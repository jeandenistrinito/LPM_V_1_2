package lpm.project.lpm_v_1_2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Payement implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Payement;
    private String typePayement;
    private double montantPayement;
    private String refVente;

    public Payement() {
    }

    public Payement(String typePayement, double montantPayement) {
        this.typePayement = typePayement;
        this.montantPayement = montantPayement;
    }

    public Payement(Long id_Payement, String typePayement, double montantPayement) {
        this.id_Payement = id_Payement;
        this.typePayement = typePayement;
        this.montantPayement = montantPayement;
    }

    public Payement(String typePayement, double montantPayement, String refVente) {
        this.typePayement = typePayement;
        this.montantPayement = montantPayement;
        this.refVente = refVente;
    }

    public Payement(Long id_Payement, String typePayement, double montantPayement, String refVente) {
        this.id_Payement = id_Payement;
        this.typePayement = typePayement;
        this.montantPayement = montantPayement;
        this.refVente = refVente;
    }

    public Long getId_Payement() {
        return id_Payement;
    }

    public void setId_Payement(Long id_Payement) {
        this.id_Payement = id_Payement;
    }

    public String getTypePayement() {
        return typePayement;
    }

    public void setTypePayement(String typePayement) {
        this.typePayement = typePayement;
    }

    public double getMontantPayement() {
        return montantPayement;
    }

    public void setMontantPayement(double montantPayement) {
        this.montantPayement = montantPayement;
    }

    public String getRefVente() {
        return refVente;
    }

    public void setRefVente(String refVente) {
        this.refVente = refVente;
    }
}
