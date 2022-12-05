package lpm.project.lpm_v_1_2.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class UserSession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSession;
    private String session;
    private String sessionValue;
    public UserSession(String session) {this.session = session;}
    public UserSession(String session, String sessionValue) {
        this.session = session;
        this.sessionValue = sessionValue;
    }
}
