package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class CategoNom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private int codeCategorie;
    private String nomCategorie;

    public CategoNom(int codeCategorie, String nomCategorie) {
        this.codeCategorie = codeCategorie;
        this.nomCategorie = nomCategorie;
    }
}
