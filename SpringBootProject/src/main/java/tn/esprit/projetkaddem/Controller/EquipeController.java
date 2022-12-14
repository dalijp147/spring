package tn.esprit.projetkaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.DetailEquipe;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Niveau;
import tn.esprit.projetkaddem.Service.EquipeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
public class EquipeController {

    @Autowired
    EquipeService equipeService;


    @GetMapping("/getEquipes")
    private List<Equipe> getAllEquipes() {
        return equipeService.getEquipes();
    }

    @GetMapping("/search")
    private List<Equipe> searchProducts(@RequestParam("query") String query) {
        return equipeService.searchProducts(query);
    }


    @PostMapping("/saveEquipe")
    public Equipe saveEquipe (@RequestBody Equipe equipe){
        return equipeService.saveEquipe(equipe);
    }


    @PostMapping("/addEquipes")
    public List<Equipe> addEquipes (@RequestBody List<Equipe> equipes){
        return equipeService.saveEquipes(equipes);
    }

    @DeleteMapping("/deleteEquipe/{id}")
    public void deleteEquipe (@PathVariable("id") Long id){
         equipeService.deleteEquipe(id);
    }


    @GetMapping("/findequipeDetailequipe/{tg}")
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(@PathVariable("tg") String thematique){
        return equipeService.findEquipeByDetailEquipeThematique(thematique);
    }


    @GetMapping("/faireEvoluerEquipes")
    public void faireEvoluerEquipes(){
        equipeService.faireEvoluerEquipes();
    }

    @GetMapping("/page")
    public List<Equipe> getUserWithPaging(@RequestParam(defaultValue = "0") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize){

        return equipeService.getUsersByPagination(pageNo,pageSize);

    }
    @GetMapping("/sortDesc")
    List<Equipe> sortDescEquipe() {
        return equipeService.findEquipeByOrderByNomEquipeDesc();
    }
    @GetMapping("/sortAsc")
    List<Equipe> sortAscEquipe() {
        return equipeService.findEquipeByOrderByNomEquipeAsc();
    }
    @GetMapping("/nbrNiveau/{niveau}")
    long nbrNiveau( @PathVariable ("niveau") Niveau niveau){
        return equipeService.calculNiveau(niveau);
    }
    @PutMapping("/upadateEquipe/{idEquipe}")
    public Equipe updateEquipe (@RequestBody Equipe e, @PathVariable("idEquipe") Long idEquipe){
        Equipe equipe = new Equipe();
        equipe.setNomEquipe(e.getNomEquipe());
        equipe.setNiveau(e.getNiveau());


        return    this.equipeService.upadateEquipe(e, idEquipe);
    }
}
