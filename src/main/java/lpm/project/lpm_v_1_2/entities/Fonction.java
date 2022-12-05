package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Fonction implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Fonction;
    private String nomFonction;

    public Fonction(Long id_Fonction, String nomFonction) {
        this.id_Fonction = id_Fonction;
        this.nomFonction = nomFonction;
    }
}
