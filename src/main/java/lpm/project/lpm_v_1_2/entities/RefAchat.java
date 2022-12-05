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
public class RefAchat implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ref_achat;
    private String ref_achat;
    private Date date_Achat;
    @OneToMany(mappedBy = "refAchat",fetch = FetchType.LAZY)
    private Collection<Achat> achatCollection;

    public RefAchat(String refAcaht) {
        this.ref_achat = refAcaht;
    }

    public RefAchat(String ref_achat, Date date_Achat) {
        this.ref_achat = ref_achat;
        this.date_Achat = date_Achat;
    }
}
