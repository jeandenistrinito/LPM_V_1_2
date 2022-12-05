package lpm.project.lpm_v_1_2.webController.authentification;


import lpm.project.lpm_v_1_2.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthentificationController {

    @Autowired UtilisateurRepository utilisateurRepository;


    @GetMapping("/")
    public String authentification0(){
        return "redirect:Identifier";
    }
    @GetMapping("/Identifier")
    public String authentification(){
        return "Pages/authentification/identifier";
    }
}
