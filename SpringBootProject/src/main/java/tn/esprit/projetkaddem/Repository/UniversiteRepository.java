package tn.esprit.projetkaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Departement;
import tn.esprit.projetkaddem.Entities.Universite;

import java.util.List;


@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long>
{


}
