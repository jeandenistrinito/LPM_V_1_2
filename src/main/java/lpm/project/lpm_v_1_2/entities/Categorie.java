package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Categorie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Categorie;
    private int codeCategorie;
    private String nomCategorie;
    private String photoCategorie;
    @OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY)
    private Collection<Produit> produitCollection;

    public Categorie(Long id_Categorie, int codeCategorie, String nomCategorie, String photoCategorie) {
        this.id_Categorie = id_Categorie;
        this.codeCategorie = codeCategorie;
        this.nomCategorie = nomCategorie;
        this.photoCategorie = photoCategorie;
    }

    public Categorie(int codeCategorie, String nomCategorie, String photoCategorie) {
        this.codeCategorie = codeCategorie;
        this.nomCategorie = nomCategorie;
        this.photoCategorie = photoCategorie;
    }
}
