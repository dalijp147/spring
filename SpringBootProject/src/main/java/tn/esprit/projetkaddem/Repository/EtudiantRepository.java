package tn.esprit.projetkaddem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Etudiant;

import java.util.List;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>
{

    Etudiant findByPrenom(String prenon);
    Etudiant findByNom(String nom);

    List<Etudiant> findByDepartementId(Long idDepart);




}
