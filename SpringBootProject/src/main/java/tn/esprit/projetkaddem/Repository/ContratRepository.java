package tn.esprit.projetkaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

}
