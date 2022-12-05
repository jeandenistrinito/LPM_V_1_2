package lpm.project.lpm_v_1_2.webController;


import lpm.project.lpm_v_1_2.Services.UtilisateurSession;
import lpm.project.lpm_v_1_2.entities.*;
import lpm.project.lpm_v_1_2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class PageController {

    @Autowired UtilisateurSession utilisateurSession;
    @Autowired private UtilisateurRepository utilisateurRepository;
    @Autowired private FonctionRepository fonctionRepository;
    @Autowired private MagasinRepository magasinRepository;
    @Autowired private ProduitRepository produitRepository;
    @Autowired private ProduitPlusProduitRepository produitPlusProduitRepository;

    @GetMapping("/page1")
    public String page1(){
        return "Pages/others/page1";
    }
    @GetMapping("/page2")
    public String page2(){
        return "Pages/others/page2";
    }
    @GetMapping("/page3")
    public String page3(){
        return "Pages/others/page3";
    }

    @GetMapping("/LPM-v-1")
    public String dashBoard(Model model){
        String url = "";
        String session = utilisateurSession.getItem("nomUtilisateur");
        if (Objects.equals(session, "")){
            url = "redirect:Identifier";
        }
        else {
            List<Fonction> fonctionList = fonctionRepository.findAll();
            model.addAttribute("fonctionList",fonctionList);
            url = "principale";
        }
        return url;
    }
    @GetMapping("/TableBord")
    public String tableBord(Model model){
        //List<Produit> produitList = produitRepository.findAll();
        //model.addAttribute("produitList",produitList);

        List<ProduitPlusProduit> produitPlusProduits = produitPlusProduitRepository.findAll();
        List<Produit> produitList1 = new ArrayList<>();
        for (ProduitPlusProduit produit:produitPlusProduits){
            List<Produit> produit100 = produitRepository.findAllByNomProduit(produit.getNomProduit());
            if (produit100.size() != 0){
                produitList1.add(produit100.get(0));
            }

        }
        for (Produit produit:produitList1){
            System.out.println("Produit : "+produit.getNomProduit());
        }
        model.addAttribute("produitList",produitList1);

        return "dashBoard";
    }

    @GetMapping("/Theme001")
    public String theme(Model model){
        return "Pages/others/theme";
    }

    @GetMapping("/TableBord2")
    public String tableBord2(Model model){
        return "Pages/others/dashboard2";
    }


    @GetMapping("/Utilisateur")
    public String utilisateur(Model model){
        return "Pages/utilisateur4";
    }

    @GetMapping("/Utilisateur2")
    public String utilisateur2(Model model){
        return "Pages/utilisateur2";
    }

    @GetMapping("/Utilisateur3")
    public String utilisateur3(Model model){
        return "Pages/others/utilisateur3";
    }

    @GetMapping("/Utilisateur4")
    public String utilisateur4(Model model){
        List<Fonction> fonctionList = fonctionRepository.findAll();
        model.addAttribute("fonctionList",fonctionList);
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        model.addAttribute("utilisateurList",utilisateurList);
        List<Magasin> magasinList = magasinRepository.findAll();
        for (Magasin mag:magasinList) {
            System.out.println("Magsin nom : "+mag.getNomMagasin());
        }
        model.addAttribute("magasinList",magasinList);
        model.addAttribute("fonction",new Fonction());
        model.addAttribute("magasin",new Magasin());
        model.addAttribute("utilisateur",new Utilisateur());
        for (Utilisateur mag:utilisateurList) {
            System.out.println("Utilisateur nom : "+mag.getNomUtilisateur());
        }
        for (Fonction mag:fonctionList) {
            System.out.println("Fonction nom : "+mag.getNomFonction());
        }
        return "Pages/utilisateur/utilisateur4";
    }

    @GetMapping("/Caisse1")
    public String caisse1(Model model){
        return "Pages/caisse/caisse";
    }
    @GetMapping("/teste")
    public String teste(Model model){
        return "Pages/others/testeAffichage";
    }
}
