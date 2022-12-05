package lpm.project.lpm_v_1_2.repositories;
import lpm.project.lpm_v_1_2.entities.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserSessionRepository extends JpaRepository<UserSession,Long> {
    UserSession findUserSessionBySession(String session);
}
