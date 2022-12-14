package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Universite;
import tn.esprit.projetkaddem.Repository.DepartmentRepository;
import tn.esprit.projetkaddem.Repository.UniversiteRepository;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class UniversiteService implements IUniversite {



    UniversiteRepository universiteRepository;
    DepartmentRepository departmentRepository;

    public List<Universite> getUniversites(){
        return universiteRepository.findAll();
    }

    public Universite saveUniversite(Universite universite){
        return universiteRepository.save(universite);
    }
    public List<Universite> saveUniversites(List<Universite> universites){
        return universiteRepository.saveAll(universites);
    }

    public String deleteUniversite(Long idUniversite){
        universiteRepository.deleteById(idUniversite);
        return "Universite supprimé !" +idUniversite;
    }
    public Universite upadateUniversite(Universite universite){
        Universite existingUniversite = universiteRepository.findById(universite.getId()).orElse(null);
        existingUniversite.setNomUniv(universite.getNomUniv());
        existingUniversite.setDepartements(universite.getDepartements());
        return universiteRepository.save(existingUniversite);
    }

    @Override
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement) {

        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departmentRepository.findById(idDepartement).orElse(null);

        universite.getDepartements().add(departement);
        universiteRepository.save(universite);


    }


}
