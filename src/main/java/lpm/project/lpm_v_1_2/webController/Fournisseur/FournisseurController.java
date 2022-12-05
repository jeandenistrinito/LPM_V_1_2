package lpm.project.lpm_v_1_2.webController.Fournisseur;


import lpm.project.lpm_v_1_2.entities.Fournisseur;
import lpm.project.lpm_v_1_2.entities.ProduitPlusProduit;
import lpm.project.lpm_v_1_2.repositories.FournisseurRepository;
import lpm.project.lpm_v_1_2.repositories.ProduitPlusProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FournisseurController {

    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    ProduitPlusProduitRepository produitPlusProduitRepository;

    @GetMapping("/Fournisseur")
    public String listeFournisseur(Model model){
        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();
        model.addAttribute("fournisseurList",fournisseurList);
        model.addAttribute("fournisseur",new Fournisseur());
        List<ProduitPlusProduit> plp = produitPlusProduitRepository.findAll();
        model.addAttribute("plp",plp);
        model.addAttribute("plproduit",new ProduitPlusProduit());
        return "Pages/Fournisseur/fournisseur";
    }

    @PostMapping("/saveFournisseur")
    public String saveFournisseur(Model model, Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
        return "redirect:Fournisseur";
    }

    @GetMapping("/DeleteFournisseur")
    public String deleteFrs(@RequestParam(name = "idFrs") long idFrs){
        fournisseurRepository.deleteById(idFrs);
        return "redirect:Fournisseur";
    }

}
