package lpm.project.lpm_v_1_2.webController.stock;


import lpm.project.lpm_v_1_2.Services.MagasinService;
import lpm.project.lpm_v_1_2.entities.*;
import lpm.project.lpm_v_1_2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class StockController {

    @Autowired private StockRepository stockRepository;
    @Autowired private ProduitPlusProduitRepository produitPlusProduitRepository;
    @Autowired private ProduitRepository produitRepository;
    @Autowired private PrixAchatRepository prixAchatRepository;
    @Autowired private PrixVenteRepository prixVenteRepository;
    @Autowired private MagasinService magasinService;

    @GetMapping("/Stock")
    public String stock(Model model){
        /*List<Stock> stockList = stockRepository.findAll();
        model.addAttribute("stockList",stockList);
        double valeurEnStock = 0;
        double marge = 0;
        for (Stock stock:stockList) {
            valeurEnStock += stock.getQuantiteProduit() * stock.getPrixVente();
            marge += stock.getQuantiteProduit() * (stock.getPrixVente() - stock.getPrixAchat());
        }
        model.addAttribute("valeurEnStock",valeurEnStock);
        model.addAttribute("marge",marge);*/

        //List<ProduitPlusProduit> produitPlusProduits = produitPlusProduitRepository.findAll();

       /* for (ProduitPlusProduit produit:produitPlusProduits){
            Produit produit1 = produitRepository.findTopByNomProduitOrderByNiveauProduitAsc(produit.getNomProduit());
            PrixAchat prixAchat = prixAchatRepository.findTopByNomProduitPAOrderByDatePADesc(produit.getNomProduit());
            PrixVente prixVente = prixVenteRepository.findTopByNomProduitPVOrderByDatePVDesc(produit.getNomProduit());
            stockRepository.save(new Stock(new Date(),
                    produit1.getCodeProduit(),
                    produit.getNomProduit(),
                    0.0,
                    produit1.getUniteProduit(),
                    produit1.getPoidsProduit(),
                    prixAchat.getPrixAchat(),
                    prixVente.getPrixVente())
            );
        }*/
        //model.addAttribute("produitPlusProduits",produitPlusProduits);
        List<Stock> stockList = stockRepository.findAll();
        model.addAttribute("stockList",stockList);
        List<Produit> produitList = produitRepository.findAll();
        model.addAttribute("produitList",produitList);
        List<ProduitPlusProduit> produitPlusProduitList = produitPlusProduitRepository.findAll();
        model.addAttribute("produitPlusProduitList",produitPlusProduitList);
        double totalMarge = 0;
        double valeurStock = 0;
        for (Stock stock:stockList){
            totalMarge += stock.getMargeStock();
            valeurStock += stock.getMontantTotalProduit();
        }
        model.addAttribute("totalMarge",totalMarge);
        model.addAttribute("valeurStock",valeurStock);
        List<Magasin> magasinList = magasinService.tousLesMagasinParDateEnscendant();
        model.addAttribute("magasinList",magasinList);
        model.addAttribute("magasin",new Magasin());


        return "Pages/produit/stock";
    }

}
