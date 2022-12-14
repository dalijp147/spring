package tn.esprit.projetkaddem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Universite;
import tn.esprit.projetkaddem.Service.UniversiteService;

import java.util.List;


@AllArgsConstructor
@RestController
@CrossOrigin
public class UniversiteController {


    UniversiteService universiteService;

    //creating a get mapping that retrieves all the Universites detail from the database
    @GetMapping("/universites")
    private List<Universite> getAlluniversites() {
        return universiteService.getUniversites();
    }



    @PostMapping("/addUniv")
    public Universite addUniversite (@RequestBody Universite universite){
        return universiteService.saveUniversite(universite);
    }
    @PostMapping("/addUniversites")
    public List<Universite> addUniversites (@RequestBody List<Universite> universites){
        return universiteService.saveUniversites(universites);
    }
    @PutMapping("/updateUniversite")
    public Universite updateUniversite (@RequestBody Universite universite){
        return universiteService.upadateUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite/{idUniv}")
    public String deleteUniversite (@PathVariable Long idUniv){
        return universiteService.deleteUniversite(idUniv);
    }


    @PutMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable("idUniversite") Long idUniversite,@PathVariable("idDepartement") Long idDepartement) {
        universiteService.assignUniversiteToDepartement(idUniversite, idDepartement);

    }

}
