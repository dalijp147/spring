package tn.esprit.projetkaddem.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.*;
import tn.esprit.projetkaddem.Service.*;

import java.util.*;
import java.util.stream.*;

@AllArgsConstructor
@RestController
@CrossOrigin
public class DepartementController {

    IDepartementService departementService;

    @GetMapping("/getDepartements")
    public List<Departement> getDepartements(){
        return departementService.getDepartements();
    }

    @GetMapping("/getDepartmentById/{idDep}")
    public Departement getDepartementByID(@PathVariable("idDep") Long idDep){
        return departementService.getDepartementByID(idDep);
    }

    @PostMapping("/addDepart")
    public Departement saveDepartement(@RequestBody Departement departement){
        return departementService.saveDepartement(departement);
    }

    @PostMapping("/addDeparts")
    public List<Departement> saveDepartements (@RequestBody List<Departement> departements){
        return departementService.saveDepartements(departements);
    }

    @PutMapping("/updateDepart/{idDepart}")
    public Departement updateDepartement (@PathVariable("idDepart") Long idDepart, @RequestBody Departement departement){
        return departementService.upadateDepartement(idDepart, departement);
    }

    @DeleteMapping("/deleteDepart/{idDepart}")
    public String deleteDepartement (@PathVariable Long idDepart){
        return departementService.deleteDepartement(idDepart);
    }

    /*

    @GetMapping("/getDeptByOption/{option}")
    public Set<Set<Etudiant>> getEtudiantbyoption(@PathVariable("option") String option) {
        return departementService.getDepartements().stream().
                map(departement -> departement.getEtudiants().
                        stream().
                        filter(etudiant ->  Objects.equals(etudiant.getOption().toString(), option)).
                        collect(Collectors.toSet())).
                collect(Collectors.toSet());

    }

     */

    @GetMapping("/retrieveDepartByUniv/{idUniversite}")
    public Set<Departement> GetDepByIdUni(@PathVariable("idUniversite") Long idUniversite){

        return  departementService.retrieveDepartementsByUniversite(idUniversite);
    }

    @PostMapping("/addDepartToUniv/{idUniversite}")
    @ResponseBody
    public void addEtudtoEqpandContrat(@RequestBody Departement D,
                                        @PathVariable("idUniversite") Long idU){
        departementService.addDepartementToUniversity(D,idU);
    }



    @GetMapping("/getDepartBynomprenom/{nom}/{prenom}")
    public List<Departement> getDepartBynomprenom(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom){

        return  departementService.getDepartByNomPrenom(nom, prenom);
    }


    @GetMapping("/nbrDeparts")
    public String NbrDeparts(){
        return departementService.nbrDepart();
    }

    @GetMapping("/nbrEtuByDeprt")
    public Long NbrEtud(){
        return departementService.nbrEtudByDepart();
    }

    @GetMapping("/nbrEtudOneDeprt/{nomDepart}")
    public long NbrEtudOneDeprt(@PathVariable("nomDepart") String nomDepart){
        return departementService.nbrEtudByOneDepart(nomDepart);
    }

    @GetMapping("/afficherOptionForDepartement/{nomDepart}")
    public Set<Option> afficherOptionForDepartement(@PathVariable("nomDepart") String nomDepart){
        return departementService.afficherOptionForDepartement(nomDepart);
    }

}
