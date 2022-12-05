package lpm.project.lpm_v_1_2.webController.client;


import lpm.project.lpm_v_1_2.entities.Client;
import lpm.project.lpm_v_1_2.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {

    @Autowired private ClientRepository clientRepository;


    @GetMapping("/Clients")
    public String clients(Model model){
        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("clientList",clientList);
        model.addAttribute("client",new Client());
        return "Pages/client/client";
    }

    @PostMapping("/SaveClient")
    public String saveClient(Model model, Client client){
        clientRepository.save(client);
        return "redirect:Clients";
    }

    @GetMapping("/DeleteClient")
    public String deleteClients(@RequestParam(name = "idClient") long idClient){
        clientRepository.deleteById(idClient);
        return "redirect:Clients";
    }

}
