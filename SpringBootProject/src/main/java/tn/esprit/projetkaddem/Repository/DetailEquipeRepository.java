package tn.esprit.projetkaddem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.DetailEquipe;

@Repository
public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Long> {





}
