package tn.esprit.projetkaddem.Repository;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.*;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Long> {

    Departement findByNomDepart(String nomDepart);

    /*Departement findDepartementByEtudiantsOption(String option);*/

    @Query("SELECT  departement FROM Departement  departement  , Etudiant e where departement.id=e.departement.id and e.option = :op")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("op") Option op);


    @Query("SELECT  departement FROM Departement  departement  , Etudiant e where departement.id=e.departement.id and e.nom = :nom and e.prenom = :prenom")
    List<Departement> getDepartementByNomAndPrenomEtudiant(@Param("nom") String nom, @Param("prenom") String prenom);






}
