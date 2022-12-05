package lpm.project.lpm_v_1_2.webController.article;

import lpm.project.lpm_v_1_2.Services.ArticleService;
import lpm.project.lpm_v_1_2.Services.MagasinService;
import lpm.project.lpm_v_1_2.Services.ProduitService;
import lpm.project.lpm_v_1_2.entities.*;
import lpm.project.lpm_v_1_2.repositories.*;
import lpm.project.lpm_v_1_2.Services.ArticleService;
import lpm.project.lpm_v_1_2.Services.MagasinService;
import lpm.project.lpm_v_1_2.Services.ProduitService;
import lpm.project.lpm_v_1_2.entities.Categorie;
import lpm.project.lpm_v_1_2.entities.Produit;
import lpm.project.lpm_v_1_2.entities.ProduitPlusProduit;
import lpm.project.lpm_v_1_2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Controller
public class articleController {

    @Autowired private ProduitRepository produitRepository;
    @Autowired private CategorieRepository categorieRepository;
    @Autowired private CategoNomRepository categoNomRepository;
    @Autowired private PrixAchatRepository prixAchatRepository;
    @Autowired private PrixVenteRepository prixVenteRepository;
    @Autowired private PrixProduitRepository prixProduitRepository;
    @Autowired private AchatProduitRepository achatProduitRepository;
    @Autowired private RefAchatRepository refAchatRepository;
    @Autowired private BeAchatRepository beAchatRepository;
    @Autowired private AchatRepository achatRepository;
    @Autowired private VenteRepository venteRepository;
    @Autowired private FournisseurRepository fournisseurRepository;
    @Autowired private PlusProduitRepository plusProduitRepository;
    @Autowired private StockRepository stockRepository;
    @Autowired private ProduitPlusProduitRepository produitPlusProduitRepository;
    @Autowired private CaisseRepository caisseRepository;
    @Autowired private BRtempRepository bRtempRepository;

    @Autowired private ArticleService articleService;
    @Autowired private ProduitService produitService;
    @Autowired private MagasinService magasinService;


    @GetMapping("/ProduitListe")
    public String produitListe(Model model){
        List<Categorie> categorieList = categorieRepository.findAll();
        model.addAttribute("produit",new Produit());
        model.addAttribute("categorie",new Categorie());
        model.addAttribute("categorieList",categorieList);
        List<ProduitPlusProduit> produitPlusProduits;
        produitPlusProduits = produitPlusProduitRepository.findAll();
        model.addAttribute("produitPlusProduits",produitPlusProduits);
        List<Produit> produitList = produitRepository.findAll();
        model.addAttribute("produitList0",produitList);
        Page<Categorie> categoriePage = categorieRepository.findCategorieByCodeCategorie(103,PageRequest.of(0,6));
        model.addAttribute("page",categoriePage);
        for (Categorie cat:categoriePage) {
            System.out.println("code : "+cat.getCodeCategorie());
        }

        return "Pages/produit/produitListe";
    }

    @GetMapping("/Article")
    public String article(Model model,@RequestParam(name = "page",defaultValue = "") String page){
        List<Categorie> categorieList = categorieRepository.findAll();
        model.addAttribute("produit",new Produit());
        model.addAttribute("categorie",new Categorie());
        model.addAttribute("categorieList",categorieList);
        List<ProduitPlusProduit> produitPlusProduits = produitPlusProduitRepository.findAll();
        model.addAttribute("produitPlusProduits",produitPlusProduits);
        List<Produit> produitList = produitRepository.findAll();
        model.addAttribute("produitList0",produitList);
        Page<Categorie> categoriePage = categorieRepository.findCategorieByCodeCategorie(103,PageRequest.of(0,6));
        model.addAttribute("page",categoriePage);
        for (Categorie cat:categoriePage) {
            System.out.println("code : "+cat.getCodeCategorie());
        }
        if (page.equals("plusProduit")){
            model.addAttribute("status",page);
        }

        return "Pages/produit/article";
    }

    @GetMapping("/nouveauProduit")
    public String nouveauProduit(Model model,@RequestParam(name = "plus",defaultValue = "") String plus){
        List<Produit> produitList = produitRepository.findAll();
        List<Categorie> categorieList = categorieRepository.findAll();
        model.addAttribute("produit",new Produit());
        model.addAttribute("categorie",new Categorie());
        model.addAttribute("produitList",produitList);
        model.addAttribute("categorieList",categorieList);
        model.addAttribute("plus",plus);
        Page<Categorie> categoriePage = categorieRepository.findCategorieByCodeCategorie(103,PageRequest.of(0,6));
        model.addAttribute("page",categoriePage);
        for (Categorie cat:categoriePage) {
            System.out.println("code : "+cat.getCodeCategorie());
        }

        List<PlusProduit> plusProduitList = plusProduitRepository.findAll();
        model.addAttribute("plusProduitList",plusProduitList);
        model.addAttribute("plusProduit",new PlusProduit());

        String nomP = "";
        String categorieNom = "";
        String photoP = "";
        if (plusProduitList.size() == 0){
            nomP = nomP;
            categorieNom = categorieNom;
            photoP = photoP;
        }
        else {
            nomP = plusProduitList.get(0).getDesignation();
            categorieNom = plusProduitList.get(0).getCategorie();
            photoP = plusProduitList.get(0).getImage();
            System.out.println("nomP : "+nomP);
        }

        int niveau = plusProduitList.size()+1;
        model.addAttribute("niveau",niveau);
        model.addAttribute("nomP",nomP);
        model.addAttribute("size",plusProduitList.size());

        return "Pages/produit/nouveauProduit0";
    }
    @PostMapping("/plusProduit")
    public String plusProduit(Model model,
                              @RequestParam(name = "designation",defaultValue = "") String nomProduit,
                              @RequestParam(name = "unite",defaultValue = "") String uniteProduit,
                              @RequestParam(name = "quantite",defaultValue = "0") double quantiteProduit,
                              @RequestParam(name = "poids",defaultValue = "0") double poidsProduit,
                              @RequestParam(name = "photoProduit",defaultValue = "") MultipartFile photoProduit,
                              @RequestParam(name = "nomCategorie",defaultValue = "") String nomCategorie){

        System.out.println("Image Produit : "+photoProduit);
        List<Categorie> categorieList = categorieRepository.findAll();
        model.addAttribute("categorie",new Categorie());
        model.addAttribute("categorieList",categorieList);
        List<PlusProduit> plusProduitList0 = plusProduitRepository.findAll();
        int niveau = plusProduitList0.size() + 1;

        String photo = null;
        try {
            photo = Base64.getEncoder().encodeToString(photoProduit.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        PlusProduit plusProduit = new PlusProduit(new Date(),nomProduit,niveau,uniteProduit,quantiteProduit,poidsProduit,nomCategorie,photo);
        plusProduitRepository.save(plusProduit);
        List<PlusProduit> plusProduitList = plusProduitRepository.findAll();
        model.addAttribute("plusProduitList",plusProduitList);

        return "redirect:nouveauProduit?plus=plus";
    }

    @PostMapping("/EnregistrerProduit")
    public String enregistrerProduit(Model model, @RequestParam(name = "photoProduit",defaultValue = "") MultipartFile photoProduit){
        List<PlusProduit> plusProduitList = plusProduitRepository.findAll(Sort.by("image").descending());
        PlusProduit produit = plusProduitList.get(0);
        String categorieP = produit.getCategorie();
        String image = "";
        try {
            image = Base64.getEncoder().encodeToString(photoProduit.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //String image1 = produit.getImage();

        produitPlusProduitRepository.save(new ProduitPlusProduit(produit.getDesignation()));
        List<ProduitPlusProduit> produitPlusProduitList1 = produitPlusProduitRepository.findAll();
        int code = 300 + (produitPlusProduitList1.size() - 1);
        List<PlusProduit> plusProduit = plusProduitRepository.findAll(Sort.by("datePlusProduit").descending());
        PlusProduit plusProduit1 = plusProduit.get(0);
        PlusProduit plusProduit2 = plusProduitRepository.findTopByDesignationOrderByNiveauPAsc(plusProduit1.getDesignation());
        List<PlusProduit> plusProduitList1 = plusProduitRepository.findAll();
        for (PlusProduit produit1:plusProduitList1){
            Categorie categorie = categorieRepository.findCategorieByNomCategorie(categorieP);
            produitRepository.save(new Produit(produit1.getNiveauP(),code,image,produit1.getDesignation(),produit1.getUnite(),produit1.getQuantite(),produit1.getPoids(),categorie));

            prixProduitRepository.save(new PrixProduit(new Date(),produit1.getDesignation(),produit1.getUnite(),0.0,0.0));
            prixAchatRepository.save(new PrixAchat(new Date(),produit1.getDesignation(),produit1.getUnite(),0.0));
            prixVenteRepository.save(new PrixVente(new Date(),produit1.getDesignation(),produit1.getUnite(),0.0));

            plusProduitRepository.deleteById(produit1.getId_PlusProduit());
        }
        Produit produit1 = produitRepository.findByNomProduitAndNiveauProduit(plusProduit1.getDesignation(),1);
        stockRepository.save(new Stock(new Date(),
                code,
                image,
                produit1.getNomProduit(),
                produit1.getNiveauProduit(),
                produit1.getQuantiteProduit(),
                0.0,
                produit1.getUniteProduit(),
                produit1.getPoidsProduit(),
                0.0,
                0.0,
                0.0,
                0.0));


        return "redirect:nouveauProduit?plus=non";
    }

    @GetMapping("/saveProduit")
    public String saveProduit(Model model){
        return "";
    }

    @PostMapping("/saveCategorie")
    public String saveCategorie(Model model,
                                @RequestParam(name = "nomCategorie",defaultValue = "Produit non inventaire") String nomCategorie){

        List<Categorie> categorieList = categorieRepository.findAll();
        int code = 100;
        int size = categorieList.size();
        if (size == 0){
            code = code;
        }
        else{

            Categorie categorie = categorieList.get(size - 1);
            System.out.println("size :"+size);
            System.out.println("categorie :"+categorie.getCodeCategorie());
            code = categorie.getCodeCategorie()+1;
        }
        categorieRepository.save(new Categorie(code,nomCategorie,null));
        categoNomRepository.save(new CategoNom(code,nomCategorie));

        return "redirect:Article";
    }

    @GetMapping("/Approvisionement")
    public String Approvisionement(Model model){



        return "Pages/produit/approvisionement";
    }

    /* ------------------------------------- prix d'article ----------------------------- */
    @GetMapping("/Prix")
    public String prix(Model model){

        List<ProduitPlusProduit> produitPlusProduitList = produitPlusProduitRepository.findAll();
        model.addAttribute("produitPlusProduitList",produitPlusProduitList);
        List<PrixProduit> prixProduitList = new ArrayList<>();
        for (ProduitPlusProduit plp : produitPlusProduitList){
            PrixProduit pp = prixProduitRepository.findTopByNomProduitPPOrderByDatePPDesc(plp.getNomProduit());
            prixProduitList.add(pp);
        }
        model.addAttribute("prixProduitList",prixProduitList);
        List<Produit> produitList = produitRepository.findAll();
        model.addAttribute("produitList",produitList);
        List<PrixProduit> prixProduitList1 = prixProduitRepository.findAll();
        model.addAttribute("prixProduitList1",prixProduitList1);

        List<Magasin> magasinList = magasinService.tousLesMagasinParDateEnscendant();
        model.addAttribute("magasinList",magasinList);
        model.addAttribute("magasin",new Magasin());

        return "Pages/produit/prix";
    }

    @GetMapping("/ModifierPrix")
    public String modifierPrix(Model model,
                               @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                               @RequestParam(name = "unite",defaultValue = "") String unite,
                               @RequestParam(name = "dateDebut",defaultValue = "2022-09-20") String dateDebut,
                               @RequestParam(name = "dateFin",defaultValue = "2022-09-27") String dateFin,
                               @RequestParam(name = "filtre",defaultValue = "") String filtre) throws ParseException {
        List<PrixProduit> prixProduitList = prixProduitRepository.findAllByNomProduitPP(nomProduit);
        model.addAttribute("prixProduitList",prixProduitList);
        model.addAttribute("nomProduit",nomProduit);
        model.addAttribute("unite",unite);
        model.addAttribute("nomProduit",nomProduit);
        List<PrixVente> prixVenteList = prixVenteRepository.findAllByNomProduitPVOrderByDatePVAsc(nomProduit);
        model.addAttribute("prixVenteList",prixVenteList);
        for (PrixVente pv:prixVenteList){
            if (pv.getUnitePV().equals(unite)){
                if (filtre.equals("ok")){
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebut);
                    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);
                    List<PrixVente> prixVenteList2 = prixVenteRepository.findAllByDatePVBetweenAndNomProduitPVAndUnitePVOrderByDatePVAsc(date1,date2,pv.getNomProduitPV(),pv.getUnitePV());
                    model.addAttribute("prixVenteList2",prixVenteList2);
                    model.addAttribute("dateDebut",dateDebut);
                    model.addAttribute("dateFin",dateFin);
                    System.out.println("dateDebut = "+date1);
                    System.out.println("dateFin = "+date2);
                }
                else {
                    List<PrixVente> prixVenteList2 = prixVenteRepository.findAllByNomProduitPVAndUnitePV(pv.getNomProduitPV(), pv.getUnitePV());
                    model.addAttribute("prixVenteList2", prixVenteList2);
                }
                PrixVente prixVente = prixVenteRepository.findTopByNomProduitPVAndUnitePVOrderByDatePVDesc(pv.getNomProduitPV(),pv.getUnitePV());
                model.addAttribute("prixActuel",prixVente.getPrixVente());
            }
        }


        return "Pages/produit/modifierPrix";
    }

    @PostMapping("/Filtrer")
    public String filtrer(Model model,
                          @RequestParam(name = "dateDebut",defaultValue = "2022-09-20") String dateDebut,
                          @RequestParam(name = "dateFin",defaultValue = "2022-09-27") String dateFin,
                          @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                          @RequestParam(name = "unite",defaultValue = "") String unite){

        return "redirect:ModifierPrix?dateDebut="+dateDebut+"&dateFin="+dateFin+"&filtre=ok&nomProduit="+nomProduit+"&unite="+unite;
    }

    @PostMapping("/ValiderModifierPrix")
    public String validerModifierPrix(Model model,
                          @RequestParam(name = "prixNouveau",defaultValue = "0") double prixNouveau,
                          @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                          @RequestParam(name = "unite",defaultValue = "") String unite)
    {

        PrixProduit prixProduit = prixProduitRepository.findTopByNomProduitPPAndUniteProduitPPOrderByDatePPDesc(nomProduit,unite);
        System.out.println("Nom produit : "+nomProduit);
        System.out.println("Produit Top : "+prixProduit.getNomProduitPP());
        prixProduitRepository.save(new PrixProduit( prixProduit.getId_PP(), new Date(),nomProduit,prixProduit.getUniteProduitPP(),prixProduit.getPrixAchatPP(),prixNouveau));
        prixVenteRepository.save(new PrixVente(new Date(), nomProduit, unite, prixNouveau));

        return "redirect:ModifierPrix?&nomProduit="+nomProduit+"&unite="+unite;
    }

    @GetMapping("/Prix1")
    public String Prix1(Model model){

        List<Produit> produitList = produitRepository.findAll();
        List<Categorie> categorieList = categorieRepository.findAll();
        model.addAttribute("produit",new Produit());
        model.addAttribute("categorie",new Categorie());
        model.addAttribute("produitList",produitList);
        model.addAttribute("categorieList",categorieList);
        model.addAttribute("prixAchat",new PrixAchat());
        model.addAttribute("prixVente",new PrixVente());
        List<PrixAchat> prixAchatList = prixAchatRepository.findAll();
        model.addAttribute("prixAchatList",prixAchatList);
        List<PrixVente> prixVentes = prixVenteRepository.findAll();
        model.addAttribute("prixVentes",prixVentes);


        return "modifierPrix";
    }

    @PostMapping("/savePA")
    public String savePA(Model model,
                         @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                         @RequestParam(name = "prixUnitairePA",defaultValue = "0") double prixUnitairePA){

        //Produit produit = produitRepository.findProduitByNomProduit(nomProduit);
        //prixAchatRepository.save(new PrixAchat( new Date(),prixUnitairePA,produit));
        return "redirect:Prix1";
    }

    @PostMapping("/savePV")
    public String savePV(Model model,
                         @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                         @RequestParam(name = "prixUnitairePV",defaultValue = "0") double prixUnitairePV){

        //Produit produit = produitRepository.findProduitByNomProduit(nomProduit);
        //prixVenteRepository.save(new PrixVente(new Date(),prixUnitairePV,produit));

        return "redirect:Prix1";
    }


    @GetMapping("/AjoutArticle")
    public String ajoutArticle(Model model,
                               @RequestParam(name = "nomFrs",defaultValue = "") String nomFrs,
                               @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                               @RequestParam(name = "prixAchat",defaultValue = "0") double prixAchat,
                               @RequestParam(name = "prixVente",defaultValue = "0") double prixVente,
                               @RequestParam(name = "impression",defaultValue = "") String impression,
                               @RequestParam(name = "refAchat",defaultValue = "") String refAchat,
                               @RequestParam(name = "br",defaultValue = "0") int br){

                               /*@RequestParam(name = "nbrArticle",defaultValue = "") int nbrArticle) {*/

        model.addAttribute("nomFrs",nomFrs);
        model.addAttribute("nomProduit",nomProduit);
        model.addAttribute("prixProduit",new PrixProduit());
        List<Produit> produitList = produitRepository.findAllByNomProduitOrderByNiveauProduitDesc(nomProduit);
        model.addAttribute("prod",new Produit());
        model.addAttribute("produitList",produitList);
        if (produitList.size()!=0) {
            Produit produit = produitList.get(0);
            PrixProduit prixProduit1 = prixProduitRepository.findTopByNomProduitPPAndUniteProduitPPOrderByDatePPDesc(produit.getNomProduit(), produit.getUniteProduit());

            model.addAttribute("prixAchat", prixProduit1.getPrixAchatPP());
            model.addAttribute("prixVente", prixProduit1.getPrixVentePP());
        }
        List<PrixProduit> prixProduitList = prixProduitRepository.findAllByNomProduitPP(nomProduit);
        model.addAttribute("prixProduitList",prixProduitList);
        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();
        model.addAttribute("fournisseurList",fournisseurList);
        model.addAttribute("frs",new Fournisseur());
        List<ProduitPlusProduit> plpList = produitPlusProduitRepository.findAll();
        model.addAttribute("plpList",plpList);
        model.addAttribute("plp",new ProduitPlusProduit());
        List<AchatProduit> achatProduitList = achatProduitRepository.findAll();
        model.addAttribute("achatProduitList",achatProduitList);
        double somme = 0;
        for (AchatProduit achatProduit:achatProduitList){
            somme += achatProduit.getMontant();
        }
        int nbrArticle = achatProduitList.size();
        model.addAttribute("somme",somme);
        model.addAttribute("nbrArticle",nbrArticle);
        model.addAttribute("dateAchat",new Date());
        model.addAttribute("impression",impression);

        List<BRtemp> bRtempList = bRtempRepository.findAllByBr(br);
        double total = 0;
        for (BRtemp bRtemp:bRtempList){
            total += bRtemp.getMontant();
            model.addAttribute("total",total);
        }
        model.addAttribute("bRtempList",bRtempList);
        model.addAttribute("date",new Date());

        return "Pages/produit/ajoutArticle";
    }
    @PostMapping("/SelectFrs")
    public String selectFrs(Model model,
                            @RequestParam(name = "nomFournisseur",defaultValue = "") String nomFournisseur,
                            @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                            @RequestParam(name = "prixAchat",defaultValue = "0") double prixAchat,
                            @RequestParam(name = "prixVente",defaultValue = "0") double prixVente){
        return "redirect:AjoutArticle?nomFrs="+nomFournisseur+"&nomProduit="+nomProduit+"&prixAchat="+prixAchat+"&prixVente="+prixVente;
    }
    @PostMapping("/SelectDesignation")
    public String selectDesignation(Model model,
                                    @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                                    @RequestParam(name = "nomFrs",defaultValue = "") String nomFournisseur)
    {
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

        return "redirect:AjoutArticle?nomFrs="+nomFournisseur+"&nomProduit="+nomProduit+"&prixAchat="+prixA+"&prixVente="+prixV;
    }

    @PostMapping("/plusArticle")
    public String plusArticle(Model model,
                            @RequestParam(name = "nomProduit",defaultValue = "Vanille") String nomProduit)
    {
        Produit produit = produitRepository.findProduitByNomProduit(nomProduit);
        model.addAttribute("produit",produit);
        List<Produit> produitList = produitRepository.findAll();
        model.addAttribute("produitList",produitList);
        List<AchatProduit> achatProduitList = achatProduitRepository.findAll();
        double somme = 0;
        for (AchatProduit achat:achatProduitList) {
            somme += achat.getMontant();
        }
        model.addAttribute("achatProduitList",achatProduitList);
        model.addAttribute("nbrArticle",achatProduitList.size());
        model.addAttribute("somme",somme);
        return "Pages/produit/ajoutArticle";
    }


    @PostMapping("/SaveArticle")
    public String saveArticle(Model model,
                              @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit,
                              @RequestParam(name = "quantite",defaultValue = "0") double quantite,
                              @RequestParam(name = "uniteProduit",defaultValue = "") String unite,
                              @RequestParam(name = "prixAchat",defaultValue = "0") double prixA,
                              @RequestParam(name = "prixVente",defaultValue = "0") double prixV,
                              @RequestParam(name = "nomFrs",defaultValue = "") String nomFrs)
    {
        double montant = 0;
        List<Produit> produitList0 = produitRepository.findAllByNomProduit(nomProduit);
        for (Produit p:produitList0){
            if (unite.equals(p.getUniteProduit())){
                montant = prixA * quantite;
            }
        }

        //PrixProduit prixProduit = prixProduitRepository.findPrixProduitByNomProduitPP(nomProduit);
        List<PrixProduit> prixProduitList = prixProduitRepository.findAllByNomProduitPP(nomProduit);
        for (PrixProduit pp:prixProduitList){
            if (pp.getUniteProduitPP().equals(unite)){
                prixProduitRepository.save(new PrixProduit( pp.getId_PP(),new Date(),pp.getNomProduitPP(),pp.getUniteProduitPP(),prixA,prixV));
            }
        }
        PrixProduit prixProduit = prixProduitRepository.findTopByNomProduitPPAndUniteProduitPPOrderByDatePPDesc(nomProduit,unite);
        List<PrixAchat> prixAchatList = prixAchatRepository.findAllByNomProduitPA(nomProduit);
        for (PrixAchat pa:prixAchatList){
            if (pa.getUnitePA().equals(unite)){
                List<PrixAchat> prixAchats = prixAchatRepository.findAllByUnitePAOrderByDatePADesc(unite);
                PrixAchat prixAchat = prixAchats.get(0);
                if (prixAchat.getPrixAchat() == prixA){
                    prixAchatRepository.save(new PrixAchat(
                            prixAchat.getId_PA(),
                            prixAchat.getDatePA(),
                            prixAchat.getNomProduitPA(),
                            prixAchat.getUnitePA(),
                            prixAchat.getPrixAchat()
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
                    prixAchatRepository.save(new PrixAchat(
                            new Date(),
                            pa.getNomProduitPA(),
                            pa.getUnitePA(),
                            prixA
                    ));
                    prixProduitRepository.save(new PrixProduit(
                            prixProduit.getId_PP(),
                            new Date(),
                            nomProduit,
                            prixProduit.getUniteProduitPP(),
                            prixA,
                            prixProduit.getPrixVentePP()));
                }
            }
        }
        List<PrixVente> prixVenteList = prixVenteRepository.findAllByNomProduitPV(nomProduit);
        for (PrixVente pv:prixVenteList){
            if (pv.getUnitePV().equals(unite)){
                List<PrixVente> prixVentes = prixVenteRepository.findAllByUnitePVOrderByDatePVDesc(unite);
                PrixVente prixVente = prixVentes.get(0);
                if (prixVente.getPrixVente() == prixV){
                    prixVenteRepository.save(new PrixVente(
                            prixVente.getId_PV(),
                            prixVente.getDatePV(),
                            prixVente.getNomProduitPV(),
                            prixVente.getUnitePV(),
                            prixVente.getPrixVente()
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
                            prixV
                    ));
                    prixProduitRepository.save(new PrixProduit(
                            prixProduit.getId_PP(),
                            new Date(),
                            nomProduit,
                            prixProduit.getUniteProduitPP(),
                            prixProduit.getPrixAchatPP(),
                            prixV));
                }

            }
        }

        achatProduitRepository.save(new AchatProduit(new Date(),nomProduit,quantite,unite,prixV,prixA,montant,nomFrs));
        List<Produit> produitList = produitRepository.findAll();
        model.addAttribute("produitList",produitList);
        model.addAttribute("produit",new Produit());
        List<AchatProduit> achatProduitList = achatProduitRepository.findAll();
        model.addAttribute("achatProduitList",achatProduitList);
        //double montant = 0;
        double somme = 0;
        for (AchatProduit achat:achatProduitList) {
            //montant = (achat.getQuantiteProduit() * achat.getPrixAchatProduit());
            somme += achat.getMontant();
        }
        AchatProduit achatProduit = achatProduitRepository.findTopByNomProduit(nomProduit);
        model.addAttribute("fournisseur",achatProduit.getFournisseur());
        //model.addAttribute("achatProduitList",achatProduitList);
        model.addAttribute("nbrArticle",achatProduitList.size());
        model.addAttribute("somme",somme);
        model.addAttribute("montant",montant);
        return "redirect:AjoutArticle?nomFrs="+nomFrs+"&nomProduit=";
    }

    @PostMapping("/EnregistrerArticle")
    public String enregistrerArticle(Model model,@RequestParam(name = "nomFrs",defaultValue = "") String nomFrs)
    {
        String reference = null;
        List<RefAchat> refAchats = refAchatRepository.findAll();
        int size = refAchats.size();
        if (size != 0) {
            RefAchat refAchat = refAchats.get(size-1);
            reference = "ref";
        }
        else {
            reference = "ref";
        }
        RefAchat refAchat = refAchatRepository.save(new RefAchat(reference,new Date()));
        String bonEntre = null;
        List<BeAchat> beAchatList = beAchatRepository.findAll();
        int size1 = beAchatList.size();
        if (size1 != 0){
            bonEntre = "BR";
        }
        else {
            bonEntre = "BR";
        }
        BeAchat beAchat = beAchatRepository.save(new BeAchat(bonEntre,new Date()));
        List<BeAchat> beAchats = beAchatRepository.findAll(Sort.by("dateBeAchat").descending());
        BeAchat beAchat1 = beAchats.get(0);
        int br = beAchat1.getId_BeAchat();
        List<Fournisseur> fournisseur = fournisseurRepository.findAll();
        Fournisseur fournisseur1 = fournisseurRepository.findFournisseurByNomFournisseur(nomFrs);
        List<Stock> stockList = stockRepository.findAll();
        List<AchatProduit> achatProduitList = achatProduitRepository.findAll();
        if (stockList.size() != 0){
            for (AchatProduit achatProduit:achatProduitList) {
                bRtempRepository.save(new BRtemp(br,
                        new Date(),
                        achatProduit.getNomProduit(),
                        achatProduit.getQuantiteProduit(),
                        achatProduit.getUniteProduit(),
                        achatProduit.getPrixVenteProduit(),
                        achatProduit.getPrixAchatProduit(),
                        achatProduit.getMontant(),
                        nomFrs));
                achatRepository.save(new Achat(new Date(),
                        refAchat,
                        beAchat,
                        achatProduit.getNomProduit(),
                        achatProduit.getQuantiteProduit(),
                        achatProduit.getUniteProduit(),
                        achatProduit.getPrixAchatProduit(),
                        achatProduit.getMontant(),
                        fournisseur1)
                );

                double quantiteV = 0;
                double quantiteA = 0;
                double prixAcaht = 0;
                double prixVente = 0;
                List<Produit> produitList = produitRepository.findAllByNomProduitOrderByNiveauProduitDesc(achatProduit.getNomProduit());
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

                Produit produit = produitRepository.findByNomProduitAndUniteProduit(achatProduit.getNomProduit(),achatProduit.getUniteProduit());
                List<Produit> produit0 = produitRepository.findAllByNomProduit(achatProduit.getNomProduit());
                for (Produit pro:produit0){
                    if (pro.getUniteProduit().equals(achatProduit.getUniteProduit())){
                        for (Stock stock:stockList){
                            if (achatProduit.getNomProduit().equals(stock.getNomProduit())){
                                /*System.out.println("Article : "+stock.getNomProduit()+" = "+achatProduit.getNomProduit());
                                double nouveauQt = stock.getQuantiteProduit() + (achatProduit.getQuantiteProduit() * pro.getPoidsProduit());
                                */
                                long id = stock.getId_Stock();
                                int code = stock.getCodeProduit();
                                double marge = ((achatProduit.getPrixVenteProduit()*achatProduit.getQuantiteProduit())-(achatProduit.getPrixAchatProduit()*achatProduit.getQuantiteProduit()));
                                stockRepository.save(new Stock(id,new Date(),
                                        code,
                                        stock.getImageProduit(),
                                        stock.getNomProduit(),
                                        stock.getNiveauProduit(),
                                        stock.getQuantiteProduit(),
                                        stock.getQuantiteStock() + ((produit.getPoidsProduit() * achatProduit.getQuantiteProduit())/stock.getPoidsproduit()),
                                        stock.getUniteProduit(),
                                        stock.getPoidsproduit(),
                                        prixAcaht,
                                        prixVente,
                                        ((stock.getQuantiteStock() + ((produit.getPoidsProduit() * achatProduit.getQuantiteProduit())/stock.getPoidsproduit())) / quantiteV) * (prixVente - prixAcaht),
                                        ((stock.getQuantiteStock() + ((produit.getPoidsProduit() * achatProduit.getQuantiteProduit())/stock.getPoidsproduit())) / quantiteV) * prixVente ));
                            }
                        }
                    }
                }
                articleService.enregistrerLesAttentes(achatProduit.getId_AchatProduit());
            }
        }
        double montantCaisse = 0.0;
        for (AchatProduit achatProduit:achatProduitList){
            montantCaisse += achatProduit.getMontant();
        }
        caisseRepository.save(new Caisse("C",new Date(),"Achat de produit",montantCaisse,"Achat par "+nomFrs,refAchat.getRef_achat(),beAchat.getBeAchat()));
        model.addAttribute("refAchat",refAchat);
        return "redirect:AjoutArticle?refAchat="+refAchat+"&br="+br+"&impression=imprimer";

    }

    @GetMapping("/BRExtrait")
    public String brextrait(Model model,
                            @RequestParam(name = "impression",defaultValue = "") String impression,
                            @RequestParam(name = "refAchat",defaultValue = "") String refAchat)
    {
        List<BRtemp> bRtempList = bRtempRepository.findAll();
        model.addAttribute("bRtempList",bRtempList);
        model.addAttribute("impression",impression);
        model.addAttribute("refAchat",refAchat);
        model.addAttribute("date",new Date());

        return "Pages/others/bonDeReception";
    }

    @GetMapping("/BRFermer")
    public String brfermer(Model model){
        List<BRtemp> bRtempList = bRtempRepository.findAll();
        for (BRtemp bRtemp:bRtempList){
            bRtempRepository.deleteById(bRtemp.getId_AchatProduit());
        }
        return "redirect:AjoutArticle";
    }

    @GetMapping("/TesteAffiche")
    public String testeAffiche(Model model,@RequestParam(name = "refAchat",defaultValue = "ref-6") String refAchat){
        model.addAttribute("refAchat",refAchat);
        //model.addAttribute("date",refAchat);
        List<Achat> achatList = achatRepository.findAll();
        model.addAttribute("achatList",achatList);
        return "Pages/others/testeAffichage";
    }

    @GetMapping("/Print")
    public String print(){
        return "Pages/others/print";
    }


    @GetMapping("/ProduitDetails")
    public String produitDetails(Model model,
                                 @RequestParam(name = "nomProduit",defaultValue = "") String nomProduit)
    {
        PrixProduit prixProduit = prixProduitRepository.findTopByNomProduitPPOrderByDatePPDesc(nomProduit);
        List<Produit> produitList = produitRepository.findAllByNomProduit(nomProduit);
        model.addAttribute("prixVente",prixProduit.getPrixVentePP());
        model.addAttribute("produitList",produitList);
        List<PrixProduit> prixProduitList = prixProduitRepository.findAllByNomProduitPP(nomProduit);
        model.addAttribute("prixProduitList",prixProduitList);
        ProduitPlusProduit plp = produitPlusProduitRepository.findByNomProduit(nomProduit);
        List<Stock> stockList = stockRepository.findAll();
        model.addAttribute("stockList",stockList);
        model.addAttribute("plp",plp);
        float valeurStock = 0;
        Stock stock = stockRepository.findStockByNomProduit(nomProduit);
        double val = stock.getMontantTotalProduit();
        valeurStock = Float.valueOf((float) val);
        System.out.println("val 2 : "+valeurStock);
        model.addAttribute("valeurStock",valeurStock);
        Produit produit = produitRepository.findTopByNomProduit(nomProduit);
        model.addAttribute("image",produit.getPhotoProduit());
        model.addAttribute("nomProduit",nomProduit);
        List<Achat> achatList = achatRepository.findAllByNomArticleOrderByDateAchatAsc(nomProduit);
        model.addAttribute("achatList",achatList);
        float valeurAchat = 0;
        for (Achat achat:achatList){
            valeurAchat += Float.valueOf((float) achat.getMontant());
        }
        model.addAttribute("valeurAchat",valeurAchat);
        List<Vente> venteList = venteRepository.findAllByNomArticleOrderByDateVenteAsc(nomProduit);
        model.addAttribute("venteList",venteList);
        float valeurVente = 0;
        for (Vente vente:venteList){
            valeurVente += Float.valueOf((float) vente.getMontant());
        }
        model.addAttribute("valeurVente",valeurVente);

        return "Pages/produit/produitDetails";
    }

    @GetMapping("/Br")
    public String bonDeReception(Model model){
        List<BeAchat> beAchatList = beAchatRepository.findAll(Sort.by("dateBeAchat").descending());
        model.addAttribute("beAchatList",beAchatList);
        List<BRtemp> bRtempList = bRtempRepository.findAll();
        model.addAttribute("bRtempList",bRtempList);
        return"Pages/produit/bonDeReception";
    }

    @GetMapping("/DeleteProduit")
    public String deleteProduit(@RequestParam(name = "nomP") String nomP){
        produitPlusProduitRepository.delete(produitPlusProduitRepository.findByNomProduit(nomP));
        produitRepository.delete(produitRepository.findTopByNomProduit(nomP));
        prixProduitRepository.delete(prixProduitRepository.findTopByNomProduitPPOrderByDatePPDesc(nomP));
        prixAchatRepository.delete(prixAchatRepository.findTopByNomProduitPAOrderByDatePADesc(nomP));
        prixVenteRepository.delete(prixVenteRepository.findTopByNomProduitPVOrderByDatePVDesc(nomP));
        stockRepository.delete(stockRepository.findStockByNomProduit(nomP));
        return "redirect:Article";
    }

    @GetMapping("/Dette")
    public String tousLesDettes(Model model){
        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();
        List<ProduitPlusProduit> produitPlusProduitList = produitPlusProduitRepository.findAll();
        model.addAttribute("fournisseurList",fournisseurList);
        model.addAttribute("produitPlusProduitList",produitPlusProduitList);
        model.addAttribute("fournisseur",new Fournisseur());
        model.addAttribute("plp",new ProduitPlusProduit());
        return "Pages/produit/dette";
    }

    @GetMapping("/Credit")
    public String tousLesCredits(){
        return "Pages/produit/credit";
    }
}
