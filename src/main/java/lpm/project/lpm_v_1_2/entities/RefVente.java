package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
public class RefVente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ref_vente;
    private String ref_vente;
    private Date dateRefVente;
    //@OneToMany(mappedBy = "refVente",fetch = FetchType.LAZY)
    //private Collection<Vente> venteCollection;

    public RefVente(String refVente) {
        this.ref_vente = refVente;
    }

    public RefVente(String ref_vente, Date date_vente) {
        this.ref_vente = ref_vente;
        this.dateRefVente = date_vente;
    }

    public int getId_ref_vente() {
        return id_ref_vente;
    }

    public void setId_ref_vente(int id_ref_vente) {
        this.id_ref_vente = id_ref_vente;
    }

    public String getRef_vente() {
        return ref_vente;
    }

    public void setRef_vente(String ref_vente) {
        this.ref_vente = ref_vente;
    }

    public Date getDate_vente() {
        return dateRefVente;
    }

    public void setDate_vente(Date date_vente) {
        this.dateRefVente = date_vente;
    }

    public Date getDateRefVente() {
        return dateRefVente;
    }

    public void setDateRefVente(Date dateRefVente) {
        this.dateRefVente = dateRefVente;
    }

    /*public Collection<Vente> getVenteCollection() {
        return venteCollection;
    }

    public void setVenteCollection(Collection<Vente> venteCollection) {
        this.venteCollection = venteCollection;
    }*/
}
