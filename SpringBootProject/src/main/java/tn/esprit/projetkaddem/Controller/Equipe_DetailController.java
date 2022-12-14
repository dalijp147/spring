package tn.esprit.projetkaddem.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.DetailEquipe;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Service.DetailEquipeService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
public class Equipe_DetailController {


    DetailEquipeService Equipe_DetailService;



    @GetMapping("/detailEquipes")
    private List<DetailEquipe> getAlldetailEquipes() {
        return Equipe_DetailService.getDetailEquipes();
    }


    @PostMapping("/AddDetailEquipe")
    public DetailEquipe addDetailEquipe (@RequestBody DetailEquipe DetailEquipe){
        return Equipe_DetailService.saveDetailEquipe(DetailEquipe);
    }
    @PostMapping("/AddDetailEquipes")
    public List<DetailEquipe> addDetailEquipes (@RequestBody List<DetailEquipe> DetailEquipe){
        return Equipe_DetailService.saveDetailEquipes(DetailEquipe);
    }
    @PutMapping("/upadateDetailEquipe/{idDetailEquipe}")
    public DetailEquipe updateEquipe (@RequestBody DetailEquipe e, @PathVariable("idDetailEquipe") Long idDetailEquipe){
        DetailEquipe equipe = new DetailEquipe();
        equipe.setSalle(e.getSalle());
        equipe.setThematique(e.getThematique());


        return    this.Equipe_DetailService.upadateDetailEquipe(e, idDetailEquipe);
    }

    @DeleteMapping("/deleteDetailEquipe/{idDetailEquipe}")
    public void deleteDetailEquipe (@PathVariable("idDetailEquipe") Long idDetailEquipe){
         Equipe_DetailService.deleteDetailEquipe(idDetailEquipe);
    }





}
