package lpm.project.lpm_v_1_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Credit implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCredit;
    private String creditDesignation;
    private String clientCredit;
    private String facVenteCredit;
    private String refVenteCredit;
    private Date dateCredit;
    private double montantCredit;
    private double montantPayeCredit;

    public Credit(String creditDesignation, String clientCredit, String facVenteCredit, String refVenteCredit, Date dateCredit, double montantCredit, double montantPayeCredit) {
        this.creditDesignation = creditDesignation;
        this.clientCredit = clientCredit;
        this.facVenteCredit = facVenteCredit;
        this.refVenteCredit = refVenteCredit;
        this.dateCredit = dateCredit;
        this.montantCredit = montantCredit;
        this.montantPayeCredit = montantPayeCredit;
    }
}
