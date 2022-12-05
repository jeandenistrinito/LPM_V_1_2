package lpm.project.lpm_v_1_2.Services;

import lpm.project.lpm_v_1_2.entities.Magasin;
import lpm.project.lpm_v_1_2.repositories.MagasinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagasinService {
    @Autowired MagasinRepository magasinRepository;

    public List<Magasin> tousLesMagasin(){
        List<Magasin> magasinList = magasinRepository.findAll();
        return magasinList;
    }

    public List<Magasin> tousLesMagasinParDateEnscendant(){
        List<Magasin> magasinList = magasinRepository.findAll(Sort.by("dateCreationMagasin").ascending());
        return magasinList;
    }

    public List<Magasin> tousLesMagasinParDateDescendant(){
        List<Magasin> magasinList = magasinRepository.findAll(Sort.by("dateCreationMagasin").descending());
        return magasinList;
    }
}
