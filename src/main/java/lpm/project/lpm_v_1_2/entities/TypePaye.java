package lpm.project.lpm_v_1_2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TypePaye implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_TypePaye;
    private String typePaye;

    public TypePaye() {
    }

    public TypePaye(String typePaye) {
        this.typePaye = typePaye;
    }

    public TypePaye(Long id_TypePaye, String typePaye) {
        this.id_TypePaye = id_TypePaye;
        this.typePaye = typePaye;
    }


    public Long getId_TypePaye() {
        return id_TypePaye;
    }

    public void setId_TypePaye(Long id_TypePaye) {
        this.id_TypePaye = id_TypePaye;
    }

    public String getTypePaye() {
        return typePaye;
    }

    public void setTypePaye(String typePaye) {
        this.typePaye = typePaye;
    }
}
