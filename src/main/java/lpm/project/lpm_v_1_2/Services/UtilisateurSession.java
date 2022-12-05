package lpm.project.lpm_v_1_2.Services;

import lpm.project.lpm_v_1_2.entities.UserSession;
import lpm.project.lpm_v_1_2.repositories.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurSession {
    @Autowired UserSessionRepository userSessionRepository;

    public boolean setItem(String nameSession, String item){
        UserSession userSession = userSessionRepository.findUserSessionBySession(nameSession);
        if (userSession == null){
            userSessionRepository.save(new UserSession(nameSession,item));
        }
        else {
            userSession.setSessionValue(item);
            userSessionRepository.save(userSession);
        }
        return true;
    }

    public String getItem(String nameSession){
        UserSession userSession = userSessionRepository.findUserSessionBySession(nameSession);
        return userSession.getSessionValue();
    }

    public void removeItem(String nameSession){
        UserSession userSession = userSessionRepository.findUserSessionBySession(nameSession);
        userSession.setSessionValue("");
        userSessionRepository.save(userSession);
    }
}
