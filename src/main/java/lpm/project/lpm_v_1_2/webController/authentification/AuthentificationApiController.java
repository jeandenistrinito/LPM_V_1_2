package lpm.project.lpm_v_1_2.webController.authentification;

import lpm.project.lpm_v_1_2.Services.ServiceResponse;
import lpm.project.lpm_v_1_2.Services.UtilisateurSession;
import lpm.project.lpm_v_1_2.entities.UserSession;
import lpm.project.lpm_v_1_2.entities.Utilisateur;
import lpm.project.lpm_v_1_2.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthentificationApiController {

    @Autowired UtilisateurRepository utilisateurRepository;
    @Autowired UtilisateurSession utilisateurSession;

    @GetMapping("/GetUserAuthentic")
    public ResponseEntity<Object> selectUtilisateurAuthentifier(@RequestParam(name = "nomU",defaultValue = "") String nomU){
        String existence = "";
        ServiceResponse<Object> response = null;
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByNomUtilisateur(nomU);
        if (utilisateur != null){
            existence = utilisateur.getNomUtilisateur();
            response = new ServiceResponse<>("success",utilisateur);
        }
        else {
            System.out.println("User : "+nomU+" n'existe pas");
            existence = "NonExiste";
            response = new ServiceResponse<>("success",existence);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/CreateSession")
    public ResponseEntity<Object> createSessionUser(@RequestBody UserSession userSession){
        boolean etat = utilisateurSession.setItem(userSession.getSession(),userSession.getSessionValue());
        ServiceResponse<String> response = null;
        if (etat)response = new ServiceResponse<>("success","Session is created");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
