package tn.esprit.projetkaddem.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Service.EtudiantService;
import tn.esprit.projetkaddem.Service.IContratService;
import tn.esprit.projetkaddem.Service.IEtudiantService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
public class EtudiantController {

    IEtudiantService etudiantService;

    @GetMapping("/etudiants")
    private List<Etudiant> getAlletudiants() {
        return etudiantService.getEtudiants();
    }

    @GetMapping("/etudiant/{idEtudiant}")
    private Etudiant getEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
        return etudiantService.getEtudiantById(idEtudiant);
    }

    @GetMapping("/etudiantByPrenom/{prenom}")
    public Etudiant findEtudiantByPrenom(@PathVariable("prenom") String prenom){
        return etudiantService.findEtudiantByPnemom(prenom);
    }

    @GetMapping("/etudiantByNom/{nom}")
    public Etudiant findEtudiantByNom(@PathVariable("nom") String nom){
        return etudiantService.findEtudiantByNom(nom);
    }



    @PostMapping("/AddEtudiant")
    public Etudiant saveEtudiant (@RequestBody Etudiant etudiant){
        return etudiantService.saveEtudiant(etudiant);
    }

    @PostMapping("/AddEtudiants")
    public List<Etudiant> saveEtudiants(@RequestBody List<Etudiant> Etudiant){
        return etudiantService.saveEtudiants(Etudiant);
    }


    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant (@RequestBody Etudiant etudiant){
        return etudiantService.upadateEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{idEtudiant}")
    public String deleteEtudiant (@PathVariable("idEtudiant") Long idEtudiant){
        return etudiantService.deleteEtudiant(idEtudiant);
    }


    @PutMapping("/assignEtudiantToDepartement/{idEtudiant}/{idDept}")
    public void assignEtudiantToDepartement(@PathVariable("idEtudiant") Long idEtudiant,
                                            @PathVariable("idDept") Long idDept){

        etudiantService.assignEtudiantToDepartement(idEtudiant, idDept);
    }

    @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idEquipe}/{idContrat}")
    @ResponseBody
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,
                                                            @PathVariable("idEquipe") Long idEquipe,
                                                            @PathVariable("idContrat") Long idContrat){
        Etudiant etudiant =this.etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idEquipe,idContrat);
        return etudiant;
    }



    @GetMapping("/getEtudiantsByDepartement/{idDepart}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepart") Long idDepart){

        return etudiantService.getEtudiantsByDepartement(idDepart);
    }




}
