package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Repository.ContratRepository;
import tn.esprit.projetkaddem.Repository.DepartmentRepository;
import tn.esprit.projetkaddem.Repository.EquipeRepository;
import tn.esprit.projetkaddem.Repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;


@AllArgsConstructor
@Service
public class EtudiantService implements IEtudiantService {


    EtudiantRepository etudiantRepository;
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;

    DepartmentRepository departmentRepository;

    @Override
    public List<Etudiant> getEtudiants(){
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(long id)
    {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public Etudiant findEtudiantByPnemom(String prenom){return etudiantRepository.findByPrenom(prenom);}

    @Override
    public Etudiant findEtudiantByNom(String nom){return etudiantRepository.findByNom(nom);}


    @Override
    public Etudiant saveEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> saveEtudiants(List<Etudiant> etudiants){
        return etudiantRepository.saveAll(etudiants);
    }



    @Override
    public String deleteEtudiant(Long idEtudiant){
        etudiantRepository.deleteById(idEtudiant);
        return "Etudiant supprimé !" +idEtudiant;
    }


    @Override
    public Etudiant upadateEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void assignEtudiantToDepartement(Long idEtudiant, Long idDepart) {
        Etudiant etudiant = this.etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement = this.departmentRepository.findById(idDepart).orElse(null);

        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }



    // on va toucher plusieur tables (table --> entity managed) (.add(e) si exist add to equipe
    // sinon add to etudiant then equipe
    @Transactional
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe) {

        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

            contrat.setEtudiant(e);
        equipe.getEtudiants().add(e);

        return e;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Long idDepart) {
        return etudiantRepository.findByDepartementId(idDepart);
    }


    /*
    @Scheduled(fixedRate=60000)
    public void fixedRate(){
        System.out.println("Hello Schedule");
    }

     */

}




