package lpm.project.lpm_v_1_2.webController.magasin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MagasinController {

    @GetMapping("/Magasin")
    public String magsinPage(){
        return "Pages/magasin/magasin";
    }
}
