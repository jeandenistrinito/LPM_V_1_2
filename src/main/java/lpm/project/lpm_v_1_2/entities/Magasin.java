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
public class Magasin implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Magasin;
    private String refMagasin;
    private String nomMagasin;
    private String adresseMagasin;
    private String capaciteMagasin;
    private Date dateCreationMagasin;
    @OneToMany(mappedBy = "magasin",fetch = FetchType.LAZY)
    private Collection<Caisse> caisseCollection;

    public Magasin(String refMagasin, String nomMagasin, String adresseMagasin, String capaciteMagasin, Date dateCreationMagasin) {
        this.refMagasin = refMagasin;
        this.nomMagasin = nomMagasin;
        this.adresseMagasin = adresseMagasin;
        this.capaciteMagasin = capaciteMagasin;
        this.dateCreationMagasin = dateCreationMagasin;
    }

    public Magasin(Long id_Magasin, String refMagasin, String nomMagasin, String adresseMagasin, String capaciteMagasin, Date dateCreationMagasin) {
        this.id_Magasin = id_Magasin;
        this.refMagasin = refMagasin;
        this.nomMagasin = nomMagasin;
        this.adresseMagasin = adresseMagasin;
        this.capaciteMagasin = capaciteMagasin;
        this.dateCreationMagasin = dateCreationMagasin;
    }

}
