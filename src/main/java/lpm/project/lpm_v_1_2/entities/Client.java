package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    private String nomPrenom;
    private String adresseClient;
    private String cinClient;
    private String telClient;
    private String nifClient;
    private String cifClient;
    private String statistique;
    //@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    //private Collection<Vente> venteCollection;

    /*public Client() {
    }*/

    public Client(String nomPrenom, String adresseClient, String cinClient, String telClient, String nifClient, String cifClient, String statistique) {
        this.nomPrenom = nomPrenom;
        this.adresseClient = adresseClient;
        this.cinClient = cinClient;
        this.telClient = telClient;
        this.nifClient = nifClient;
        this.cifClient = cifClient;
        this.statistique = statistique;
    }



    /*public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getCinClient() {
        return cinClient;
    }

    public void setCinClient(String cinClient) {
        this.cinClient = cinClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public String getNifClient() {
        return nifClient;
    }

    public void setNifClient(String nifClient) {
        this.nifClient = nifClient;
    }

    public String getCifClient() {
        return cifClient;
    }

    public void setCifClient(String cifClient) {
        this.cifClient = cifClient;
    }

    public String getStatistique() {
        return statistique;
    }

    public void setStatistique(String statistique) {
        this.statistique = statistique;
    }*/
}
