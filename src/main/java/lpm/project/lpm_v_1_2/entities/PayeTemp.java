package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class PayeTemp implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPayeTemp;
    private String typePayeTemp;
    private double montantPayeTemp;
    private String refVentePayeTemp;

    public PayeTemp(String typePayeTemp, double montantPayeTemp, String refVentePayeTemp) {
        this.typePayeTemp = typePayeTemp;
        this.montantPayeTemp = montantPayeTemp;
        this.refVentePayeTemp = refVentePayeTemp;
    }
}
