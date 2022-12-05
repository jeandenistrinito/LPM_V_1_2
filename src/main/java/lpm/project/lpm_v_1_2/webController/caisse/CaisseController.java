package lpm.project.lpm_v_1_2.webController.caisse;

import lpm.project.lpm_v_1_2.Services.CaisseService;
import lpm.project.lpm_v_1_2.Services.MagasinService;
import lpm.project.lpm_v_1_2.entities.*;
import lpm.project.lpm_v_1_2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class CaisseController {

    @Autowired private CaisseService caisseService;
    @Autowired private CaisseRepository caisseRepository;
    @Autowired private FacVenteRepository facVenteRepository;
    @Autowired private RefVenteRepository refVenteRepository;
    @Autowired private BeAchatRepository beAchatRepository;
    @Autowired private RefAchatRepository refAchatRepository;
    @Autowired private VenteRepository venteRepository;
    @Autowired private AchatRepository achatRepository;
    @Autowired private PayementVenteRepository payementVenteRepository;
    @Autowired private MagasinService magasinService;
    @Autowired private PayementRepository payementRepository;


    @GetMapping("/Caisse")
    public String caissePage(Model model){

        List<Caisse> caisseList = caisseRepository.findAll(Sort.by("dateCaisse").descending());
        model.addAttribute("caisseList",caisseList);
        List<PayementVente> payementVenteList = payementVenteRepository.findAll();
        model.addAttribute("payementVenteList",payementVenteList);
        List<Achat> achatList = achatRepository.findAll();
        model.addAttribute("achatList",achatList);

        double espece = 0;
        double cheque = 0;
        double credit = 0;
        double virement = 0;
        double autre = 0;

        double especeP = 0;
        double chequeP = 0;
        double creditP = 0;
        double virementP = 0;
        double autreP = 0;

        List<PayementVente> payementVenteList1 = payementVenteRepository.findAllByTypePayement("espèce");
        for (PayementVente payementVente:payementVenteList1){
            espece += payementVente.getMontantPayement();
        }
        List<PayementVente> payementVenteList2 = payementVenteRepository.findAllByTypePayement("chèque");
        for (PayementVente payementVente:payementVenteList2){
            cheque += payementVente.getMontantPayement();
        }
        List<PayementVente> payementVenteList3 = payementVenteRepository.findAllByTypePayement("crédit");
        for (PayementVente payementVente:payementVenteList3){
            credit += payementVente.getMontantPayement();
        }
        List<PayementVente> payementVenteList4 = payementVenteRepository.findAllByTypePayement("téléphone");
        for (PayementVente payementVente:payementVenteList4){
            autre += payementVente.getMontantPayement();
        }
        List<PayementVente> payementVenteList5 = payementVenteRepository.findAllByTypePayement("virement");
        for (PayementVente payementVente:payementVenteList5){
            virement += payementVente.getMontantPayement();
        }


        List<Payement> payementList1 = payementRepository.findAllByTypePayement("espèce");
        if (payementList1.size() != 0) {
            for (Payement payementVente : payementList1) {
                especeP += payementVente.getMontantPayement();
            }
        }
        List<Payement> payementList2 = payementRepository.findAllByTypePayement("chèque");
        if (payementList2.size() != 0) {
            for (Payement payementVente : payementList2) {
                chequeP += payementVente.getMontantPayement();
            }
        }
        List<Payement> payementList3 = payementRepository.findAllByTypePayement("crédit");
        if (payementList3.size() != 0) {
            for (Payement payementVente : payementList3) {
                creditP += payementVente.getMontantPayement();
            }
        }
        List<Payement> payementList4 = payementRepository.findAllByTypePayement("téléphone");
        if (payementList4.size() != 0) {
            for (Payement payementVente : payementList4) {
                autreP += payementVente.getMontantPayement();
            }
        }
        List<Payement> payementList5 = payementRepository.findAllByTypePayement("virement");
        if (payementList5.size() != 0) {
            for (Payement payementVente : payementList5) {
                virementP += payementVente.getMontantPayement();
            }
        }


        model.addAttribute("espece",(espece) + (especeP));
        model.addAttribute("cheque",(cheque) + (chequeP));
        model.addAttribute("credit",(credit) + (creditP));
        model.addAttribute("virement",(virement) + (virementP));
        model.addAttribute("autre",(autre) + (autreP));

        List<Magasin> magasinList = magasinService.tousLesMagasinParDateEnscendant();
        model.addAttribute("magasinList",magasinList);
        model.addAttribute("magasin",new Magasin());
        model.addAttribute("date",new Date());

        return "Pages/caisse/caisse";
    }

    @PostMapping("/Encaissement")
    public String encaissement(Model model,
                               @RequestParam(name = "descriptionEncaisse",defaultValue = "") String descriptionEncaisse,
                               @RequestParam(name = "montantEncaisse",defaultValue = "0") double montantEncaisse){

        caisseRepository.save(new Caisse("C",new Date(),"Encaissement",montantEncaisse,montantEncaisse,0.0,descriptionEncaisse));

        return "redirect:Caisse";
    }

    @PostMapping("/Decaissement")
    public String decaissement(Model model,
                               @RequestParam(name = "descriptionDecaisse",defaultValue = "") String descriptionDecaisse,
                               @RequestParam(name = "montantDecaisse",defaultValue = "0") double montantDecaisse){

        caisseRepository.save(new Caisse("C",new Date(),"Décaissement",montantDecaisse,0.0,montantDecaisse,descriptionDecaisse));

        return "redirect:Caisse";
    }
}
