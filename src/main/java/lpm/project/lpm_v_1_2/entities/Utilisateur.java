package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Utilisateur implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Utilisateur;
    private String nomPrenomUtilisateur;
    private String adresseUtilisateur;
    private String contactUtilisateur;
    private String photoUtilisateur;
    private String nomUtilisateur;
    private String motpassUtilisateur;
    private String droitAccess;
    private String fonction;
    private String magasin;
    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY)
    private Collection<Caisse> caisseCollection;


    public Utilisateur(String nomPrenomUtilisateur, String adresseUtilisateur, String contactUtilisateur, String photoUtilisateur, String nomUtilisateur, String motpassUtilisateur, String access) {
        this.nomPrenomUtilisateur = nomPrenomUtilisateur;
        this.adresseUtilisateur = adresseUtilisateur;
        this.contactUtilisateur = contactUtilisateur;
        this.photoUtilisateur = photoUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.motpassUtilisateur = motpassUtilisateur;
        this.droitAccess = access;
    }

    public Utilisateur(Long id_Utilisateur, String nomPrenomUtilisateur, String adresseUtilisateur, String contactUtilisateur, String photoUtilisateur, String nomUtilisateur, String motpassUtilisateur, String access) {
        this.id_Utilisateur = id_Utilisateur;
        this.nomPrenomUtilisateur = nomPrenomUtilisateur;
        this.adresseUtilisateur = adresseUtilisateur;
        this.contactUtilisateur = contactUtilisateur;
        this.photoUtilisateur = photoUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.motpassUtilisateur = motpassUtilisateur;
        this.droitAccess = access;
    }

    public Utilisateur(String nomPrenomUtilisateur, String adresseUtilisateur, String contactUtilisateur, String photoUtilisateur, String nomUtilisateur, String motpassUtilisateur, String access, String fonction, String magasin) {
        this.nomPrenomUtilisateur = nomPrenomUtilisateur;
        this.adresseUtilisateur = adresseUtilisateur;
        this.contactUtilisateur = contactUtilisateur;
        this.photoUtilisateur = photoUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.motpassUtilisateur = motpassUtilisateur;
        this.droitAccess = access;
        this.fonction = fonction;
        this.magasin = magasin;
    }
}
