package lpm.project.lpm_v_1_2.webController;

import lpm.project.lpm_v_1_2.Services.*;
import lpm.project.lpm_v_1_2.entities.*;
import lpm.project.lpm_v_1_2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RestControlller {

    @Autowired ProduitPlusProduitRepository produitPlusProduitRepository;
    @Autowired ProduitRepository produitRepository;
    @Autowired PrixProduitRepository prixProduitRepository;
    @Autowired PrixAchatRepository prixAchatRepository;
    @Autowired PrixVenteRepository prixVenteRepository;
    @Autowired StockRepository stockRepository;
    @Autowired PlusProduitRepository plusProduitRepository;
    @Autowired CategorieRepository categorieRepository;
    @Autowired CategoNomRepository categoNomRepository;
    @Autowired MagasinRepository magasinRepository;
    @Autowired MagasinService magasinService;
    @Autowired UtilisateurRepository utilisateurRepository;
    @Autowired VenteProduitRepository venteProduitRepository;
    @Autowired FacVenteRepository facVenteRepository;
    @Autowired VenteRepository venteRepository;
    @Autowired FactureAvoirRepository factureAvoirRepository;
    @Autowired PayementVenteRepository payementVenteRepository;
    @Autowired CreditRepository creditRepository;
    @Autowired PayementRepository payementRepository;
    @Autowired DetteRepository detteRepository;
    @Autowired LivraisonRepository livraisonRepository;

    List<PlusProduit> plusProduitList = new ArrayList<>();

    @DeleteMapping("/deleteProduit")
    public ResponseEntity<Object> deleteProduit(){
        return new ResponseEntity<Object>("succes", HttpStatus.OK);
    }

    @PostMapping("/PlusProduit")
    public ResponseEntity<Object> plusProduitRest(@RequestBody PlusProduit plusProduit) {
        plusProduitRepository.save(plusProduit);
        List<PlusProduit> plusProduitList1 = plusProduitRepository.findAll();
        plusProduitList.addAll(plusProduitList1);
        ServiceResponse<List<PlusProduit>> response = new ServiceResponse<>("success",plusProduitList1);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/selectCategorie")
    public ResponseEntity<Object> selectCategoriesNom(){
        List<CategoNom> categoNomList = categoNomRepository.findAll();
        CategorieService<List<CategoNom>> listCategorieService = new CategorieService<>("success",categoNomList);
        return new ResponseEntity<Object>(listCategorieService,HttpStatus.OK);
    }

    @GetMapping("/GetAllMagasin")
    public ResponseEntity<Object> selctionerMagasin(){
        List<Magasin> magasinList = magasinService.tousLesMagasinParDateEnscendant();
        ServiceResponse<List<Magasin>> serviceResponse = new ServiceResponse<>("success",magasinList);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/SaveMagasin")
    public ResponseEntity<Object> enregistrerMagasin(@RequestBody Magasin magasin){
        String refMagasin = "";
        List<Magasin> magasinList = magasinService.tousLesMagasinParDateEnscendant();
        if (magasinList.size() == 0){
            refMagasin = "Mag-"+100;
            magasin.setRefMagasin(refMagasin);
        }
        else {
            Magasin magasin1 = magasinList.get(magasinList.size() - 1);
            String ref0 = magasin1.getRefMagasin();
            String ref1 = ref0.substring(ref0.lastIndexOf("-") + 1);
            int ref2 = Integer.valueOf(ref1);
            refMagasin = "Mag-"+(ref2+1);
            magasin.setRefMagasin(refMagasin);
        }
        magasinRepository.save(magasin);
        List<Magasin> magasinList1 = magasinService.tousLesMagasinParDateEnscendant();
        ServiceResponse<List<Magasin>> serviceResponse = new ServiceResponse<>("success",magasinList1);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/SelectAllUsers")
    public ResponseEntity<Object> selectTousUtilisateurs(){
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        System.out.println("Liste size : "+utilisateurList.size());
        for (Utilisateur u:utilisateurList) {
            System.out.println("Utilisateur : "+u.getNomUtilisateur());
            System.out.println("Utilisateur Fonction : "+u.getFonction());
        }
        //ServiceResponse<List<Utilisateur>> serviceResponse = new ServiceResponse<>("success",utilisateurList);
        UtilisateurServiceResponse<List<Utilisateur>> utilisateurServiceResponse = new UtilisateurServiceResponse<>("success",utilisateurList);
        return new ResponseEntity<Object>(utilisateurServiceResponse,HttpStatus.OK);
    }

    @PostMapping("/SaveEditAccess")
    public ResponseEntity<Object> enregistrerAcces(@RequestBody Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
        ServiceResponse<String> response = new ServiceResponse<>("success","Modification reussi");
        return new ResponseEntity<Object>(response,HttpStatus.OK);
    }

    @GetMapping("/SelectDesignation")
    public ResponseEntity<Object> selectDesignationVente(@RequestParam(name = "nomProduit",defaultValue = "") String nomProduit){
        List<PrixProduit> prixProduitList = prixProduitRepository.findAllByNomProduitPPOrderByDatePPDesc(nomProduit);
        for (PrixProduit p:prixProduitList) {
            System.out.println("pr : "+p.getUniteProduitPP());
        }
        ServiceResponse<List<PrixProduit>> response = new ServiceResponse<>("success",prixProduitList);
        return new ResponseEntity<Object>(response,HttpStatus.OK);
    }


    @GetMapping("/DeleteProduitVente")
    public ResponseEntity<Object> supprimerProduitVente(@RequestParam(name = "nomProduit",defaultValue = "") String nomProduit){
        VenteProduit venteProduit = venteProduitRepository.findTopByNomProduit(nomProduit);
        venteProduitRepository.deleteById(venteProduit.getId_VenteProduit());
        ServiceResponse<String> response = new ServiceResponse<>("success","vita");
        return new ResponseEntity<Object>(response,HttpStatus.OK);
    }

    @PostMapping("/ModifierProduitVente")
    public ResponseEntity<Object> modifierProduitVente(@RequestBody ModelMap modelMap){
        VenteProduit venteProduit = venteProduitRepository.findTopByNomProduit(modelMap.getAttribute("nomProduitVente").toString());
        double qua = Double.valueOf(modelMap.getAttribute("quantiteProduitVente").toString());
        venteProduit.setQuantiteProduit(qua);
        double npv = venteProduit.getPrixVenteProduit() * qua;
        venteProduit.setPrixVenteProduit(venteProduit.getPrixVenteProduit() * qua);
        venteProduit.setPrixAchatProduit(venteProduit.getPrixAchatProduit() * qua);
        List<VenteProduit> list = venteProduitRepository.findAll();
        double somme = 0.0;
        for (VenteProduit ve:list){
            somme += ve.getMontant();
        }
        ModelMap modelMap1 = new ModelMap();
        modelMap1.addAttribute("niova","niova");
        modelMap1.addAttribute("npv",npv);
        modelMap1.addAttribute("somme",somme);
        venteProduitRepository.save(venteProduit);
        ServiceResponse<ModelMap> response = new ServiceResponse<>("success",modelMap1);
        return new ResponseEntity<Object>(response,HttpStatus.OK);
    }

    @PostMapping("/FiltrerDateFacture")
    public ResponseEntity<Object> filtrerFactureParDate(@RequestBody ModelMap modelMap) throws ParseException {
        System.out.println("date debut : "+modelMap.getAttribute("dateDebut"));
        System.out.println("date fin : "+modelMap.getAttribute("dateFin"));
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(modelMap.getAttribute("dateDebut").toString());
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(modelMap.getAttribute("dateFin").toString());
        List<FacVente> facVenteList = facVenteRepository.findAllByDateFacVenteBetweenOrderByDateFacVenteDesc(date1,date2);
        for (FacVente fac:facVenteList){
            System.out.println("Fac : "+fac.getFacVente()+"-"+fac.getId_FacVente()+" , date : "+fac.getDateFacVente());
        }
        FactureServiceResponse<List<FacVente>> response = new FactureServiceResponse<>("success",facVenteList);
        //ServiceResponse<List<FacVente>> response = new ServiceResponse<>("success",facVenteList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/FiltrerDateVenteDetails")
    public ResponseEntity<Object> filtrerDetailsVenteParDate(@RequestBody ModelMap modelMap) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(modelMap.getAttribute("dateDebut").toString());
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(modelMap.getAttribute("dateFin").toString());
        List<Vente> venteList = venteRepository.findAllByDateVenteBetweenOrderByDateVenteDesc(date1,date2);
        for (Vente vente:venteList){
            System.out.println("Vente : "+vente.getRefVente()+" , date : "+vente.getDateVente());
        }
        ServiceResponse<List<Vente>> response = new ServiceResponse<>("success",venteList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/SaveFacAvoir")
    public ResponseEntity<Object> enregistrerFactureAvoir(@RequestBody FactureAvoir factureAvoir){
        factureAvoirRepository.save(factureAvoir);
        ServiceResponse<String> response = new ServiceResponse<>("success","Un avoir a été crée");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetAllAvoir")
    public ResponseEntity<Object> listeAvoir(){
        List<FactureAvoir> avoirList = factureAvoirRepository.findAll(Sort.by("dateFacAvoire").descending());
        ServiceResponse<List<FactureAvoir>> response = new ServiceResponse<>("success",avoirList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetAllVenteCredit")
    public ResponseEntity<Object> tousLesVentesCredit(){
        /*List<PayementVente> payementVenteList = payementVenteRepository.findAllByTypePayementOrderByDatePayementVenteDesc("crédit");
        ServiceResponse<List<PayementVente>> response = new ServiceResponse<>("success",payementVenteList);*/
        List<Credit> creditList = creditRepository.findAll(Sort.by("dateCredit").descending());
        ServiceResponse<List<Credit>> response = new ServiceResponse<>("success",creditList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetCreditClient")
    public ResponseEntity<Object> tousCreditClient(@RequestParam(name = "nomClient",defaultValue = "") String nomClient){
        /*List<PayementVente> payementVenteList = payementVenteRepository.findAllByTypePayementAndNomClient("crédit",nomClient);
        ServiceResponse<List<PayementVente>> response = new ServiceResponse<>("success",payementVenteList);*/
        List<Credit> creditList = creditRepository.findAllByClientCredit(nomClient);
        ServiceResponse<List<Credit>> response = new ServiceResponse<>("success",creditList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/SavePayeCredit")
    public ResponseEntity<Object> enregistrerPayeCredit(@RequestBody ModelMap credit){
        long idCreditPayer =  Long.valueOf(credit.getAttribute("idCredit").toString());
        double montantPayer =  Double.valueOf(credit.getAttribute("montantCredit").toString());
        double payePayer =  Double.valueOf(credit.getAttribute("montantPayeCredit").toString());
        String typePayer =  credit.getAttribute("typePayeCredit").toString();

        Credit credit1 = creditRepository.getById(idCreditPayer);
        credit1.setMontantPayeCredit(credit1.getMontantPayeCredit() + payePayer);

        creditRepository.save(credit1);
        payementRepository.save(new Payement(typePayer,payePayer));

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("idCreditC",idCreditPayer);
        modelMap.addAttribute("montant",montantPayer);
        modelMap.addAttribute("payerPaye",payePayer);
        modelMap.addAttribute("typePaye",typePayer);
        ServiceResponse<ModelMap> response = new ServiceResponse<>("success",modelMap);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/SaveDetteFrs")
    public ResponseEntity<Object> enregistrerUneAvance(@RequestBody Dette dette){
        detteRepository.save(dette);
        List<Dette> detteList = detteRepository.findAllByDetteFournisseur(dette.getDetteFournisseur());
        ServiceResponse<List<Dette>> response = new ServiceResponse<>("success",detteList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetDetteFrs")
    public ResponseEntity<Object> getAllDetteFrs(@RequestParam(name = "nomFrs",defaultValue = "") String nomFrs){
        List<Dette> detteList = detteRepository.findAllByDetteFournisseur(nomFrs);
        ServiceResponse<List<Dette>> response = new ServiceResponse<>("success",detteList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/SavePayeDette")
    public ResponseEntity<Object> enregistrerPayeDette(@RequestBody ModelMap detteModel){
        long idDettePayer =  Long.valueOf(detteModel.getAttribute("idDette").toString());
        double montantDette =  Double.valueOf(detteModel.getAttribute("montantDette").toString());
        double payeDettePayer =  Double.valueOf(detteModel.getAttribute("montantPayeDette").toString());

        Dette dette = detteRepository.getById(idDettePayer);
        dette.setMontantPayDette((dette.getMontantPayDette()) + ((payeDettePayer)));

        detteRepository.save(dette);
        livraisonRepository.save(new Livraison(montantDette,payeDettePayer,dette.getDetteDesignation()+""+dette.getIdDette(),new Date()));
        ServiceResponse<String> response = new ServiceResponse<>("success",dette.getDetteFournisseur());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetAllDette")
    public ResponseEntity<Object> getTousLesDettes(){
        List<Dette> detteList = detteRepository.findAll(Sort.by("detteDate").descending());
        ServiceResponse<List<Dette>> response = new ServiceResponse<>("success",detteList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetResteDette")
    public ResponseEntity<Object> selecteDetteReste(@RequestParam(name = "numDette",defaultValue = "") String numDette ){
        List<Dette> detteList = detteRepository.findAll();
        double reste = 0.0;
        for (Dette dette:detteList){
            if (numDette.equals(dette.getDetteDesignation()+""+dette.getIdDette())){
                reste = dette.getMontantDette() - dette.getMontantPayDette();
            }
        }
        ServiceResponse<Double> response = new ServiceResponse<>("success",reste);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetResteCredit")
    public ResponseEntity<Object> selecteCreditReste(@RequestParam(name = "numDette",defaultValue = "") String numDette ){
        List<Credit> creditList = creditRepository.findAll();
        double reste = 0.0;
        for (Credit credit:creditList){
            if (numDette.equals(credit.getCreditDesignation()+""+credit.getIdCredit())){
                reste = credit.getMontantCredit() - credit.getMontantPayeCredit();
            }
        }
        ServiceResponse<Double> response = new ServiceResponse<>("success",reste);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/SavePayeDetteP")
    public ResponseEntity<Object> enregistrerPayeDettePage(@RequestBody ModelMap detteModel){
        String idDettePayer =  detteModel.getAttribute("idDette").toString();
        double montantDette =  Double.valueOf(detteModel.getAttribute("montantDette").toString());
        double payeDettePayer =  Double.valueOf(detteModel.getAttribute("montantPayeDette").toString());

        List<Dette> detteList = detteRepository.findAll();
        for (Dette dette:detteList){
            if (idDettePayer.equals(dette.getDetteDesignation()+""+dette.getIdDette())){
                dette.setMontantPayDette(payeDettePayer);
                detteRepository.save(dette);
            }
        }

        ServiceResponse<String> response = new ServiceResponse<>("success","ok");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/SavePayeCreditC")
    public ResponseEntity<Object> enregistrerPayeCreditC(@RequestBody ModelMap credit){
        String idCreditPayer =  credit.getAttribute("idCredit").toString();
        double payePayer =  Double.valueOf(credit.getAttribute("montantPayeCredit").toString());
        String typePayer =  credit.getAttribute("typePayeCredit").toString();


        List<Credit> creditList = creditRepository.findAll();
        for (Credit credit1:creditList){
            if (idCreditPayer.equals(credit1.getCreditDesignation()+""+credit1.getIdCredit())){
                credit1.setMontantPayeCredit(payePayer);
                creditRepository.save(credit1);
                payementRepository.save(new Payement(typePayer,payePayer));
            }
        }

        ServiceResponse<String> response = new ServiceResponse<>("success","Ok");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetImageTeste")
    public ResponseEntity<Object> testeImage(ModelMap modelMap){
        List<Produit> produitList = produitRepository.findAll();
        Produit produit = produitList.get(1);
        System.out.println("produit logo nom : "+produit.getNomProduit());
        System.out.println("produit logo image : "+produit.getPhotoProduit());
        modelMap.addAttribute("produit",produit.getPhotoProduit());
        ServiceResponse<ModelMap> response = new ServiceResponse<>("success",modelMap);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
