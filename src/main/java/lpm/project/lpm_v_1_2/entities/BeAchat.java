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
public class BeAchat implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_BeAchat;
    private String beAchat;
    private Date dateBeAchat;
    @OneToMany(mappedBy = "beAchat",fetch = FetchType.LAZY)
    private Collection<Achat> achatCollection;

    public BeAchat(String beAchat) {
        this.beAchat = beAchat;
    }

    public BeAchat(String beAchat, Date dateBeAchat) {
        this.beAchat = beAchat;
        this.dateBeAchat = dateBeAchat;
    }
}
