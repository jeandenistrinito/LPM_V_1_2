package lpm.project.lpm_v_1_2.webController.utilisateur;


import lpm.project.lpm_v_1_2.entities.Fonction;
import lpm.project.lpm_v_1_2.entities.Magasin;
import lpm.project.lpm_v_1_2.entities.Utilisateur;
import lpm.project.lpm_v_1_2.repositories.FonctionRepository;
import lpm.project.lpm_v_1_2.repositories.MagasinRepository;
import lpm.project.lpm_v_1_2.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private FonctionRepository fonctionRepository;
    @Autowired
    private MagasinRepository magasinRepository;




    @PostMapping("/saveUser")
    public String enregistrerUtilisateur(Model model, Utilisateur utilisateur,
                                         @RequestParam(name = "nomFonction",defaultValue = "") String nomFonction,
                                         @RequestParam(name = "nomMagasin",defaultValue = "") String nomMagasin){
        String nomPrenom = utilisateur.getNomPrenomUtilisateur();
        String adresse = utilisateur.getAdresseUtilisateur();
        String contact = utilisateur.getContactUtilisateur();
        String photo = "null";
        String userName = utilisateur.getNomUtilisateur();
        String pass = utilisateur.getMotpassUtilisateur();
        Fonction fonction1 = fonctionRepository.findByNomFonction(nomFonction);
        Magasin magasin1 = magasinRepository.findByNomMagasin(nomMagasin);
        String access = "";
        if (nomFonction.equals("Administrateur")){
            access = "Accès à tous";
        }
        else {
            access = "Simple utilisateur";
        }

        Utilisateur utilisateur1 = new Utilisateur(nomPrenom,adresse,contact,photo,userName,pass,access,nomFonction,nomMagasin);
        utilisateurRepository.save(utilisateur1);
        return "redirect:Utilisateur4";
    }

    @PostMapping("/saveFunction")
    public String enregistrerFonction(Model model, Fonction fonction){
        fonctionRepository.save(fonction);
        return "redirect:Utilisateur4";
    }
}
