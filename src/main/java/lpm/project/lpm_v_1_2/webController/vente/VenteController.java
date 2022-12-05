package lpm.project.lpm_v_1_2.webController.vente;


import lpm.project.lpm_v_1_2.Services.VenteService;
import lpm.project.lpm_v_1_2.entities.*;
import lpm.project.lpm_v_1_2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class VenteController {

    @Autowired private VenteService venteService;
    @Autowired private ProduitRepository produitRepository;
    @Autowired private AchatProduitRepository achatProduitRepository;
    @Autowired private VenteProduitRepository venteProduitRepository;
    @Autowired private PrixVenteRepository prixVenteRepository;
    @Autowired private PrixAchatRepository prixAchatRepository;
    @Autowired private PrixProduitRepository prixProduitRepository;
    @Autowired private MagasinRepository magasinRepository;
    @Autowired private ClientRepository clientRepository;
    @Autowired private VenteRepository venteRepository;
    @Autowired private RefVenteRepository refVenteRepository;
    @Autowired private FacVenteRepository facVenteRepository;
    @Autowired private ProduitPlusProduitRepository produitPlusProduitRepository;
    @Autowired private PayementRepository payementRepository;
    @Autowired private TypePayeRepository typePayeRepository;
    @Autowired private StockRepository stockRepository;
    @Autowired private PayementVenteRepository payementVenteRepository;
    @Autowired private CaisseRepository caisseRepository;
    @Autowired private FacVtempRepository facVtempRepository;
    @Autowired private CreditRepository creditRepository;
    @Autowired private PayeTempRepository payeTempRepository;

    @GetMapping("/Vente")
    public String afficheVente(Model model,
                               @RequestParam(name = "nomClient",defaultValue = "") String nomClient,
                               @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                               @RequestParam(name = "prixAchat",defaultValue = "0") double prixAchat,
                               @RequestParam(name = "prixVente",defaultValue = "0") double prixVente,
                               @RequestParam(name = "somme",defaultValue = "0") double somme2,
                               @RequestParam(name = "remise",defaultValue = "0") double remise,
                               @RequestParam(name = "netaPayer",defaultValue = "0") double netaPayer,
                               @RequestParam(name = "etat",defaultValue = "") String etat,
                               @RequestParam(name = "impression",defaultValue = "") String impression,
                               @RequestParam(name = "remiseParUnite",defaultValue = "0") double remiseParUnite,
                               @RequestParam(name = "facV",defaultValue = "0") int facV,
                               @RequestParam(name = "initiale",defaultValue = "") String initiale,
                               @RequestParam(name = "initiale0",defaultValue = "") String initiale0) throws ParseException {




        model.addAttribute("nomProduit",nomProduit);
        model.addAttribute("remiseParUnite",remiseParUnite);
        model.addAttribute("netaPayer",netaPayer);
        //double testeNombre = 10000000000.75 * 5;
        //long testeNOMBRE1 = (long) testeNombre;
        //model.addAttribute("testeNombre",testeNOMBRE1);
        //System.out.println("TesteNombre : "+testeNombre);
        //System.out.println("TesteNombre : "+testeNOMBRE1);

        if (initiale.equals("oui")){
            model.addAttribute("remise",remise);
        }
        else if (initiale.equals("accord")){
            model.addAttribute("remise",remise + remiseParUnite);
        }
        else{
            model.addAttribute("remise",remiseParUnite);
        }


        System.out.println("RemseParUnite = "+remiseParUnite);


        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("clientList",clientList);
        model.addAttribute("client",new Client());

        List<Produit> produitList = produitRepository.findAllByNomProduit(nomProduit);
        model.addAttribute("prod",new Produit());
        model.addAttribute("produitList",produitList);

        if (produitList.size()!=0) {
            Produit produit = produitList.get(0);
            PrixProduit prixProduit1 = prixProduitRepository.findTopByNomProduitPPAndUniteProduitPPOrderByDatePPDesc(produit.getNomProduit(), produit.getUniteProduit());

            model.addAttribute("prixAchat", prixProduit1.getPrixAchatPP());
            model.addAttribute("prixVente", prixProduit1.getPrixVentePP());
        }

        List<Magasin> magasinList = magasinRepository.findAll();
        model.addAttribute("magasinList",magasinList);
        model.addAttribute("magasin",new Magasin());

        List<ProduitPlusProduit> plpList = produitPlusProduitRepository.findAll();
        model.addAttribute("plpList",plpList);
        model.addAttribute("plp",new ProduitPlusProduit());

        List<PrixProduit> prixProduitList = prixProduitRepository.findAllByNomProduitPP(nomProduit);
        model.addAttribute("prixProduitList",prixProduitList);

        List<VenteProduit> venteProduitList = venteProduitRepository.findAll();
        model.addAttribute("venteProduitList",venteProduitList);
        double somme = 0;
        for (VenteProduit venteProduit:venteProduitList){
            somme += venteProduit.getMontant();
        }
        int nbrArticle = venteProduitList.size();
        model.addAttribute("somme",somme);
        model.addAttribute("nbrArticle",nbrArticle);

        double montantPaye = 0;
        List<PayeTemp> payementList = payeTempRepository.findAll();
        for (PayeTemp payement:payementList){
            montantPaye += payement.getMontantPayeTemp();
        }
        model.addAttribute("payementList",payementList);
        model.addAttribute("montantPaye",montantPaye);
        List<TypePaye> typePayeList = typePayeRepository.findAll();
        model.addAttribute("typePayeList",typePayeList);
        model.addAttribute("typePaye",new TypePaye());

        model.addAttribute("etat",etat);
        model.addAttribute("impression",impression);
        System.out.println("Impression = "+impression);

        List<FacVtemp> facVtempList = facVtempRepository.findAllByBr(facV);
        double total = 0;
        for (FacVtemp facVtemp:facVtempList){
            total += facVtemp.getMontant();
        }
        double total1 = total + remiseParUnite;
        if (initiale0.equals("oui")){
            remiseParUnite = 0;
        }
        model.addAttribute("nomClient",nomClient);
        model.addAttribute("remiseParUnite",remiseParUnite);
        model.addAttribute("total",total1);
        System.out.println("Remise = "+remise);
        System.out.println("RemiseParUnite = "+remiseParUnite);
        System.out.println("Total = "+total);
        System.out.println("Total1 = "+total1);

        List<FacVente> facVenteList = facVenteRepository.findAll(Sort.by("dateFacVente").descending());
        model.addAttribute("facVtempList",facVtempList);
        if (facVenteList.size()!=0){
            FacVente facVente = facVenteList.get(0);
            String numFacture = facVente.getFacVente()+"-"+String.valueOf(facVente.getId_FacVente());
            model.addAttribute("numFacture",numFacture);

            Date date = facVenteList.get(0).getDateFacVente();
            model.addAttribute("date",date);

        }
        model.addAttribute("initiale0",initiale0);



        return "Pages/vente/vente";
    }

    @PostMapping("/plusVente")
    public String plusVente(Model model,
                            @RequestParam(name = "nomProduit",defaultValue = "Vanille") String nomProduit)
    {

        Produit produit = produitRepository.findProduitByNomProduit(nomProduit);
        model.addAttribute("produit",produit);
        List<Produit> produitList = produitRepository.findAll();
        model.addAttribute("produitList",produitList);

        return "Pages/vente/vente";
    }

    @PostMapping("/SelectClient")
    public String selectClient(Model model,
                            @RequestParam(name = "nomClient",defaultValue = "") String nomClient,
                            @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                            @RequestParam(name = "prixAchat",defaultValue = "0") double prixAchat, @RequestParam(name = "remiseParUnite",defaultValue = "0") double remiseParUnite,
                            @RequestParam(name = "prixVente",defaultValue = "0") double prixVente){
        return "redirect:Vente?nomClient="+nomClient+"&nomProduit="+nomProduit+"&prixAchat="+prixAchat+"&prixVente="+prixVente+"&remiseParUnite="+remiseParUnite;
    }

    @PostMapping("/SelectDesignationV")
    public String selectDesignation(Model model,
                                    @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                                    @RequestParam(name = "remiseParUnite",defaultValue = "0") double remiseParUnite,
                                    @RequestParam(name = "nomClient",defaultValue = "") String nomClient){
        PrixAchat prixAchat = prixAchatRepository.findTopByNomProduitPAOrderByDatePADesc(nomProduit);
        PrixVente prixVente = prixVenteRepository.findTopByNomProduitPVOrderByDatePVDesc(nomProduit);
        double prixA = 0;
        double prixV = 0;
        if (prixAchat != null){
            prixA = prixAchat.getPrixAchat();
        }
        else {
            prixA = prixA;
        }
        if (prixVente != null){
            prixV = prixVente.getPrixVente();
        }
        else {
            prixV = prixV;
        }


        return "redirect:Vente?nomClient="+nomClient+"&nomProduit="+nomProduit+"&prixAchat="+prixA+"&prixVente="+prixV+"&remiseParUnite="+remiseParUnite;
    }

    @PostMapping("/AjouterVente")
    public String ajouterVente(Model model,
                               @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                               @RequestParam(name = "quantite",defaultValue = "0") double quantite,
                               @RequestParam(name = "uniteProduit",defaultValue = "") String unite,
                               @RequestParam(name = "prixAchat",defaultValue = "0") double prixAchat,
                               @RequestParam(name = "prixVente",defaultValue = "0") double prixVente,
                               @RequestParam(name = "nomClient",defaultValue = "") String nomClient,
                               @RequestParam(name = "prixSpecial",defaultValue = "0") double prixSpecial,
                               @RequestParam(name = "remiseParUnite",defaultValue = "0") double remiseParUnite,
                               @RequestParam(name = "prixEtat",defaultValue = "prixVente") String prixEtat)
    {
        double montant = 0;
        List<Produit> produitList0 = produitRepository.findAllByNomProduit(nomProduit);
        if(prixEtat.equals("prixVente")) {
            for (Produit p:produitList0){
                if (unite.equals(p.getUniteProduit())){
                    montant = prixVente * quantite;
                }
            }
            venteProduitRepository.save(new VenteProduit(new Date(), nomProduit, quantite, unite, prixAchat, prixVente, montant, nomClient));
        }
        else {
            for (Produit p:produitList0){
                if (unite.equals(p.getUniteProduit())){
                    if (prixEtat.equals("prixSpecialValeur")) {
                        montant = prixSpecial * quantite;
                    }
                    else {
                        montant = prixSpecial * quantite;
                    }
                }
            }
            venteProduitRepository.save(new VenteProduit(new Date(), nomProduit, quantite, unite, prixAchat, prixSpecial, montant, nomClient));
        }

        PrixProduit prixProduit = prixProduitRepository.findTopByNomProduitPPAndUniteProduitPPOrderByDatePPDesc(nomProduit,unite);
        List<PrixVente> prixVenteList = prixVenteRepository.findAllByNomProduitPV(nomProduit);
        for (PrixVente pv:prixVenteList){
            if (pv.getUnitePV().equals(unite)){
                List<PrixVente> prixVentes = prixVenteRepository.findAllByUnitePVOrderByDatePVDesc(unite);
                PrixVente prixVente0 = prixVentes.get(0);
                if (prixVente0.getPrixVente() == prixVente){
                    prixVenteRepository.save(new PrixVente(
                            prixVente0.getId_PV(),
                            prixVente0.getDatePV(),
                            prixVente0.getNomProduitPV(),
                            prixVente0.getUnitePV(),
                            prixVente0.getPrixVente()
                    ));
                    prixProduitRepository.save(new PrixProduit(
                            prixProduit.getId_PP(),
                            prixProduit.getDatePP(),
                            nomProduit,
                            prixProduit.getUniteProduitPP(),
                            prixProduit.getPrixAchatPP(),
                            prixProduit.getPrixVentePP()));
                }
                else {
                    prixVenteRepository.save(new PrixVente(
                            new Date(),
                            pv.getNomProduitPV(),
                            pv.getUnitePV(),
                            prixVente
                    ));
                    prixProduitRepository.save(new PrixProduit(
                            prixProduit.getId_PP(),
                            new Date(),
                            nomProduit,
                            prixProduit.getUniteProduitPP(),
                            prixProduit.getPrixAchatPP(),
                            prixVente));
                }

            }
        }

        List<Produit> produitList = produitRepository.findAll();
        model.addAttribute("produitList",produitList);
        model.addAttribute("produit",new Produit());
        List<VenteProduit> venteProduitList = venteProduitRepository.findAll();
        model.addAttribute("venteProduitList",venteProduitList);
        //double montant = 0;
        double somme = 0;
        for (VenteProduit venteProduit:venteProduitList) {
            //montant = (achat.getQuantiteProduit() * achat.getPrixAchatProduit());
            somme += venteProduit.getMontant();
        }
        VenteProduit venteProduit = venteProduitRepository.findTopByNomProduit(nomProduit);
        model.addAttribute("client",venteProduit.getClient());
        //model.addAttribute("achatProduitList",achatProduitList);
        model.addAttribute("nbrArticle",venteProduitList.size());
        model.addAttribute("somme",somme);
        model.addAttribute("montant",montant);

        return "redirect:Vente?nomClient="+nomClient+"&remiseParUnite="+remiseParUnite+"&nomProduit=";
    }

    @PostMapping("/OkPayement")
    public String okPayement(Model model,
                             @RequestParam(name = "montantPaye",defaultValue = "0") double montantPaye,
                             @RequestParam(name = "remise",defaultValue = "0") double remise,
                             @RequestParam(name = "netaPayer",defaultValue = "0") double netaPayer,
                             @RequestParam(name = "typePaye",defaultValue = "") String typePaye,
                             @RequestParam(name = "nomClient",defaultValue = "") String nomClient,
                             @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                             @RequestParam(name = "remiseParUnite",defaultValue = "0") double remiseParUnite,
                             @RequestParam(name = "prixAchat",defaultValue = "0") double prixAchat,
                             @RequestParam(name = "prixVente",defaultValue = "0") double prixVente)
    {
        System.out.println("OkPayement debut------------------------ tonga teto-----------------");
        List<RefVente> refVentelist = refVenteRepository.findAll(Sort.by("dateRefVente").descending());
        RefVente refVente = refVentelist.get(0);
        List<FacVente> facVentelist = facVenteRepository.findAll(Sort.by("dateFacVente").descending());
        FacVente facVente = facVentelist.get(0);
        payementVenteRepository.save(new PayementVente(new Date(),refVente.getRef_vente()+"-"+refVente.getId_ref_vente(),facVente.getFacVente()+"-"+facVente.getId_FacVente(),nomProduit,montantPaye,typePaye,nomClient));
        //payementRepository.save(new Payement(typePaye,montantPaye,refVente.getRef_vente()+"-"+refVente.getId_ref_vente()));
        payeTempRepository.save(new PayeTemp(typePaye,montantPaye,refVente.getRef_vente()+"-"+refVente.getId_ref_vente()));

        if (typePaye.equals("crédit")){
            creditRepository.save(new Credit("crédit n° ",nomClient,facVente.getFacVente()+"-"+facVente.getId_FacVente(),refVente.getRef_vente()+"-"+refVente.getId_ref_vente(),new Date(),montantPaye,0.0));
        }

        System.out.println("OkPayement fin--------------------------- tapitra teto--------------");

        return "redirect:Vente?nomClient="+nomClient+"&nomProduit="+nomProduit+"&remise="+remise+"&netaPayer="+netaPayer+"&remiseParUnite="+remiseParUnite+"&prixAchat="+prixAchat+"&prixVente="+prixVente+"&etat=active&initiale=oui";
    }

    @PostMapping("/AccorderRemise")
    public String accorderRemise(Model model,
                                 @RequestParam(name = "remiseValeur",defaultValue = "0") double remiseValeur,
                                 @RequestParam(name = "remisePourcent",defaultValue = "0") double remisePourcent,
                                 @RequestParam(name = "remiseParUnite",defaultValue = "0") double remiseParUnite,
                                 @RequestParam(name = "nomClient",defaultValue = "") String nomClient,
                                 @RequestParam(name = "etatRemise",defaultValue = "remiseEnValeur") String etatRemise,
                                 @RequestParam(name = "somme",defaultValue = "0") double somme){

        System.out.println("AcorderRemise debut-----------------------------------------");

        String reference = null;
        List<RefVente> refVentes = refVenteRepository.findAll();
        int size = refVentes.size();
        if (size != 0) {
            RefVente refVente = refVentes.get(size - 1);
            reference = "ref";
        } else {
            reference = "ref-1";
        }
        RefVente refVente = refVenteRepository.save(new RefVente(reference, new Date()));

        String facVente = null;
        List<FacVente> facVenteList = facVenteRepository.findAll();
        int size1 = facVenteList.size();
        if (size1 != 0) {
            facVente = "FAC";
        } else {
            facVente = "FAC-1";
        }

        double netaPayer = somme;
        double remise = 0;
        if (etatRemise.equals("remiseEnValeur")){
            netaPayer = somme - remiseValeur;
            remise = remiseValeur;
            facVenteRepository.save(new FacVente(facVente,new Date(),nomClient,somme,remise,netaPayer));
            System.out.println("Somme valeur : "+somme);
            System.out.println("remise valeur : "+remise);
            System.out.println("netaPayer valeur : "+netaPayer);
        }
        else {
            netaPayer = somme - ((somme * remisePourcent) / 100);
            remise = (somme * remisePourcent) / 100;
            facVenteRepository.save(new FacVente(facVente,new Date(),nomClient,somme,remise,netaPayer));
            System.out.println("Somme pourcent : "+somme);
            System.out.println("remise pourcent : "+remise);
            System.out.println("netaPayer pourcent : "+netaPayer);
        }

        System.out.println("AcorderRemise fin-----------------------------------------");

        return "redirect:Vente?nomClient="+nomClient+"&somme="+somme+"&remise="+remise+"&remiseParUnite="+remiseParUnite+"&netaPayer="+netaPayer+"&etat=active&initiale=accord";
    }

    @PostMapping("/NonRemise")
    public String nonRemise(Model model,
                                 @RequestParam(name = "remiseValeur",defaultValue = "0") double remiseValeur,
                                 @RequestParam(name = "remisePourcent",defaultValue = "0") double remisePourcent,
                                 @RequestParam(name = "nomClient",defaultValue = "") String nomClient,
                                 @RequestParam(name = "etatRemise",defaultValue = "remiseEnValeur") String etatRemise,
                                 @RequestParam(name = "somme",defaultValue = "0") double somme){


        String reference = null;
        List<RefVente> refVentes = refVenteRepository.findAll();
        int size = refVentes.size();
        if (size != 0) {
            RefVente refVente = refVentes.get(size - 1);
            reference = "ref";
        } else {
            reference = "ref-1";
        }
        RefVente refVente = refVenteRepository.save(new RefVente(reference, new Date()));

        String facVente = null;
        List<FacVente> facVenteList = facVenteRepository.findAll();
        int size1 = facVenteList.size();
        if (size1 != 0) {
            facVente = "FAC";
        } else {
            facVente = "FAC-1";
        }

        double netaPayer = somme;
        double remise = 0;
        if (etatRemise.equals("remiseEnValeur")){
            netaPayer = somme - remiseValeur;
            remise = remiseValeur;
            facVenteRepository.save(new FacVente(facVente,new Date(),nomClient,somme,remise,netaPayer));
            System.out.println("Somme valeur : "+somme);
            System.out.println("remise valeur : "+remise);
            System.out.println("netaPayer valeur : "+netaPayer);
        }
        else {
            netaPayer = somme - ((somme * remisePourcent) / 100);
            remise = (somme * remisePourcent) / 100;
            facVenteRepository.save(new FacVente(facVente,new Date(),nomClient,somme,remise,netaPayer));
            System.out.println("Somme pourcent : "+somme);
            System.out.println("remise pourcent : "+remise);
            System.out.println("netaPayer pourcent : "+netaPayer);
        }


        return "redirect:Vente?nomClient="+nomClient+"&somme="+somme+"&remise="+remise+"&netaPayer="+netaPayer+"&etat=active";
    }

    @PostMapping("/EnregistrerVente")
    public String enregistrerVente(Model model,
                                   @RequestParam(name = "nomClient",defaultValue = "") String nomClient,
                                   @RequestParam(name = "remise",defaultValue = "0") double remise,
                                   @RequestParam(name = "netaPayer",defaultValue = "0") double netaPayer,
                                   @RequestParam(name = "remiseParUnite",defaultValue = "0") double remiseParUnite,
                                   @RequestParam(name = "somme",defaultValue = "0") double somme) {

        /*String reference = null;
        List<RefVente> refVentes = refVenteRepository.findAll();
        int size = refVentes.size();
        if (size != 0) {
            RefVente refVente = refVentes.get(size - 1);
            reference = "ref";
        } else {
            reference = "ref-1";
        }
        String facVente = null;
        List<FacVente> facVenteList = facVenteRepository.findAll();
        int size1 = facVenteList.size();
        if (size1 != 0) {
            facVente = "FAC";
        } else {
            facVente = "FAC-1";
        }*/

        System.out.println("remise EnregistrerVente : "+remise);
        System.out.println("netaPayer EnregistrerVente : "+netaPayer);

        List<RefVente> refVenteList1 = refVenteRepository.findAll(Sort.by("dateRefVente").descending());
        RefVente refVente = refVenteList1.get(0);
        int facV = 0;
        List<FacVente> facVenteList1 = facVenteRepository.findAll(Sort.by("dateFacVente").descending());
        if (facVenteList1.size()!=0) {
            FacVente facVente2 = facVenteList1.get(0);
            facV = facVente2.getId_FacVente();
            facVente2.setDateFacVente(new Date());

            List<Client> clientList = clientRepository.findAll();
            Client client = clientRepository.findClientByNomPrenom(nomClient);
            List<Stock> stockList = stockRepository.findAll();
            List<VenteProduit> venteProduitList = venteProduitRepository.findAll();
            if (stockList.size() != 0) {
                for (VenteProduit venteProduit : venteProduitList) {
                    facVtempRepository.save(new FacVtemp(facV,
                            new Date(),
                            venteProduit.getNomProduit(),
                            venteProduit.getQuantiteProduit(),
                            venteProduit.getUniteProduit(),
                            venteProduit.getPrixVenteProduit(),
                            venteProduit.getPrixAchatProduit(),
                            venteProduit.getMontant(),
                            nomClient));
                    venteRepository.save(new Vente(new Date(),
                            refVente.getRef_vente()+"-"+refVente.getId_ref_vente(),
                            facVente2.getFacVente()+"-"+facVente2.getId_FacVente(),
                            venteProduit.getNomProduit(),
                            venteProduit.getQuantiteProduit(),
                            venteProduit.getUniteProduit(),
                            venteProduit.getPrixVenteProduit(),
                            venteProduit.getMontant(),
                            nomClient)
                    );

                    double quantiteV = 0;
                    double quantiteA = 0;
                    double prixAcaht = 0;
                    double prixVente = 0;
                    List<Produit> produitList = produitRepository.findAllByNomProduitOrderByNiveauProduitDesc(venteProduit.getNomProduit());
                    Produit produit01 = produitList.get(0);
                    Produit produit02 = produitList.get(produitList.size()-1);
                    PrixVente prixVente1 = prixVenteRepository.findTopByNomProduitPVAndUnitePVOrderByDatePVDesc(produit01.getNomProduit(),produit01.getUniteProduit());
                    PrixVente prixVente2 = prixVenteRepository.findTopByNomProduitPVAndUnitePVOrderByDatePVDesc(produit01.getNomProduit(),produit02.getUniteProduit());
                    if (prixVente1.getPrixVente()!=0){
                        prixVente = prixVente1.getPrixVente();
                        quantiteV = produit01.getPoidsProduit();
                    }
                    else {
                        prixVente = prixVente2.getPrixVente();
                        quantiteV = produit02.getPoidsProduit();
                    }
                    PrixAchat prixAchat1 = prixAchatRepository.findTopByNomProduitPAAndUnitePAOrderByDatePADesc(produit01.getNomProduit(),produit01.getUniteProduit());
                    PrixAchat prixAchat2 = prixAchatRepository.findTopByNomProduitPAAndUnitePAOrderByDatePADesc(produit01.getNomProduit(),produit02.getUniteProduit());
                    if (prixVente1.getPrixVente()!=0){
                        prixAcaht = prixAchat1.getPrixAchat();
                        quantiteA = produit01.getPoidsProduit();
                    }
                    else {
                        prixAcaht = prixAchat2.getPrixAchat();
                        quantiteA= produit02.getPoidsProduit();
                    }

                    Produit produit = produitRepository.findByNomProduitAndUniteProduit(venteProduit.getNomProduit(),venteProduit.getUniteProduit());
                    List<Produit> produit0 = produitRepository.findAllByNomProduit(venteProduit.getNomProduit());
                    for (Produit pro : produit0) {
                        if (pro.getUniteProduit().equals(venteProduit.getUniteProduit())) {
                            for (Stock stock : stockList) {
                                if (venteProduit.getNomProduit().equals(stock.getNomProduit()) && venteProduit.getUniteProduit().equals(stock.getUniteProduit())) {
                                /*System.out.println("Article : "+stock.getNomProduit()+" = "+achatProduit.getNomProduit());
                                double nouveauQt = stock.getQuantiteProduit() + (achatProduit.getQuantiteProduit() * pro.getPoidsProduit());
                                */
                                    long id = stock.getId_Stock();
                                    int code = stock.getCodeProduit();
                                /*stockRepository.save(new Stock(id,new Date(),
                                        stock.getNomProduit(),
                                        achatProduit.getQuantiteProduit(),
                                        stock.getUniteProduit(),
                                        achatProduit.getPrixAchatProduit(),
                                        achatProduit.getPrixVenteProduit(),
                                        code)
                                );
                                    stockRepository.save(new Stock(id, new Date(),
                                            code,
                                            stock.getImageProduit(),
                                            stock.getNomProduit(),
                                            stock.getNiveauProduit(),
                                            stock.getQuantiteProduit(),
                                            stock.getQuantiteStock() - venteProduit.getQuantiteProduit(),
                                            stock.getUniteProduit(),
                                            stock.getPoidsproduit(),
                                            venteProduit.getPrixAchatProduit(),
                                            venteProduit.getPrixVenteProduit(),
                                            0,
                                            stock.getMontantTotalProduit() + (venteProduit.getQuantiteProduit() * venteProduit.getPrixVenteProduit())));

                                 */

                                    stockRepository.save(new Stock(id,new Date(),
                                            code,
                                            stock.getImageProduit(),
                                            stock.getNomProduit(),
                                            stock.getNiveauProduit(),
                                            stock.getQuantiteProduit(),
                                            stock.getQuantiteStock() - ((produit.getPoidsProduit() * venteProduit.getQuantiteProduit())/stock.getPoidsproduit()),
                                            stock.getUniteProduit(),
                                            stock.getPoidsproduit(),
                                            prixAcaht,
                                            prixVente,
                                            ((stock.getQuantiteStock() - ((produit.getPoidsProduit() * venteProduit.getQuantiteProduit())/stock.getPoidsproduit())) / quantiteV) * (prixVente - prixAcaht),
                                            ((stock.getQuantiteStock() - ((produit.getPoidsProduit() * venteProduit.getQuantiteProduit())/stock.getPoidsproduit())) / quantiteV) * prixVente ));

                                }
                            }
                        }

                    }
                    //Produit produit = produitRepository.findProduitByUniteProduit(achatProduit.getUniteProduit());

                    venteService.enregistrerLesAttentesVente(venteProduit.getId_VenteProduit());
                }
            }


            /*List<FacVente> facVente3 = facVenteRepository.findAll(Sort.by("dateFacVente").descending());
            FacVente facVente4 = facVente3.get(0);
            facVenteRepository.save(new FacVente(facVente4.getId_FacVente(), facVente4.getFacVente(), facVente4.getDateFacVente(), nomClient, somme));
            */
        /*List<Payement> payementList = payementRepository.findAll();
        for (Payement payement:payementList){
            payementVenteRepository.save(new PayementVente(new Date(),
                    refVente.getRef_vente(),
                    facVente1.getFacVente(),
                    payement.getMontantPayement(),
                    payement.getTypePayement(),
                    nomClient)
            );
            payementRepository.deleteById(payement.getId_Payement());
        }

        List<FacVtemp> facVtempList = facVtempRepository.findAllByBr(facV);
        double montant = 0;
        for (FacVtemp facVtemp:facVtempList){

        }*/


            caisseRepository.save(new Caisse("C", new Date(), "Vente de produit", netaPayer,"Vente au "+nomClient, refVente.getRef_vente(), facVente2.getFacVente()));

            model.addAttribute("refVente", refVente);


            /*List<Payement> payementList = payementRepository.findAll();
            for (Payement payement : payementList) {
                payementRepository.deleteById(payement.getId_Payement());
            }*/
            List<PayeTemp> payeTempList = payeTempRepository.findAll();
            for (PayeTemp payement : payeTempList) {
                payementRepository.save(new Payement(payement.getTypePayeTemp(),payement.getMontantPayeTemp(),payement.getRefVentePayeTemp()));
                payeTempRepository.deleteById(payement.getIdPayeTemp());
            }
        }
        System.out.println("Remise Enregistrer Vente = "+remise);
        return "redirect:Vente?refVente=" + refVente+"&nomClient="+nomClient+"&remise="+remise+"&netaPayer="+netaPayer+"&remiseParUnite="+remiseParUnite+"&impression=imprimer&facV="+facV+"&initiale=oui&initiale0=oui";
    }

    @GetMapping("/Factures")
    public String factures(Model model){

        List<FacVente> facVenteList = facVenteRepository.findAll(Sort.by("dateFacVente").descending());
        model.addAttribute("facVenteList",facVenteList);
        List<FacVtemp> facVtempList = facVtempRepository.findAll();
        model.addAttribute("facVtempList",facVtempList);
        List<FacVtemp> listNom = new ArrayList<>();
        List<FacVtemp> listMontant = new ArrayList<>();
        for (FacVente facVente:facVenteList){
            FacVtemp facVtemp = facVtempRepository.findTopByBr(facVente.getId_FacVente());
            listNom.add(facVtemp);

        }

        model.addAttribute("date",new Date());
        System.out.println((new Date()));

        List<Vente> venteList = venteRepository.findAll();

        model.addAttribute("venteList",venteList);
        model.addAttribute("listNom",listNom);

        return "Pages/produit/facture";
    }

    @GetMapping("/DetailsVente")
    public String detailsVente(Model model){

        List<RefVente> refVenteList = refVenteRepository.findAll(Sort.by("dateRefVente").descending());
        model.addAttribute("refVenteList",refVenteList);
        List<FacVente> facVenteList = facVenteRepository.findAll(Sort.by("dateFacVente").descending());
        model.addAttribute("facVenteList",facVenteList);
        List<Vente> venteList = venteRepository.findAll(Sort.by("dateVente").descending());
        model.addAttribute("venteList",venteList);
        model.addAttribute("date",new Date());

        return "Pages/vente/venteDetails";
    }
}
