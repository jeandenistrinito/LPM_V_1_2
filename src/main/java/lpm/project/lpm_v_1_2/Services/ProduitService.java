package lpm.project.lpm_v_1_2.Services;

import lpm.project.lpm_v_1_2.entities.Categorie;
import lpm.project.lpm_v_1_2.entities.Produit;
import lpm.project.lpm_v_1_2.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ProduitService {

    @Autowired private ProduitRepository produitRepository;

    public void saveProduit(int niveau,
                            int code,
                            MultipartFile file,
                            String nom,
                            String unite,
                            double poids,
                            Categorie categorie)
    {
        Produit produit = new Produit();
        String fileName = StringUtils.capitalize(file.getOriginalFilename());
        if (fileName.contains("..")){
            System.out.println("Fichier invalide ..");
        }
        produit.setNiveauProduit(niveau);
        produit.setCodeProduit(code);
        try {
            produit.setPhotoProduit(Base64.getEncoder().encodeToString(file.getBytes()));
        }catch (IOException e){
            e.printStackTrace();
        }
        produit.setNomProduit(nom);
        produit.setUniteProduit(unite);
        produit.setPoidsProduit(poids);
        produit.setCategorie(categorie);

        produitRepository.save(produit);
    }
}
