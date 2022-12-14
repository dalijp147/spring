package tn.esprit.projetkaddem.Service;

import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Entities.Option;

import java.util.List;
import java.util.Set;

public interface IDepartementService {


    public List<Departement> getDepartements();

    public Departement getDepartementByID(Long idDep);

    public Departement saveDepartement(Departement departement);


    public List<Departement> saveDepartements(List<Departement> departements);

    public String deleteDepartement(Long idDepartement);


    public Departement upadateDepartement(Long idDepartement, Departement departement);

    /*public Departement findDepartementByEtudiants(String option);*/

    public List<Departement> retrieveDepartementByOptionEtudiant(Option op);

    public Set<Departement> retrieveDepartementsByUniversite(Long idUniversite);

    public Departement addDepartementToUniversity(Departement deprt, Long idUniversite);

    public List<Departement> getDepartByNomPrenom(String nom, String prenom);

    public String nbrDepart();

    public Long nbrEtudByDepart();

    public long nbrEtudByOneDepart(String nomDepart);

    public Set<Option> afficherOptionForDepartement(String nomDepart);



}
