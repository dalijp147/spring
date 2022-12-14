package tn.esprit.projetkaddem.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Niveau;

import java.util.List;


public interface EquipeRepository extends JpaRepository<Equipe,Long>, PagingAndSortingRepository<Equipe,Long> {


    //List<Equipe> findEquipeByDetailEquipeThematiqueLike(String thematique);

    List<Equipe> findEquipeByDetailEquipeThematique(String tg);
    @Query("SELECT p FROM Equipe  p WHERE " +  "p.nomEquipe LIKE CONCAT('%', :query, '%')")
    List<Equipe> searchProducts(String query);


    @Query("SELECT COUNT(c) FROM Equipe c WHERE c.niveau=:niveau")
    long calculNiveau(@Param("niveau") Niveau niveau);
    List<Equipe> findByNiveau(Niveau niveau);
    Page<Equipe> findByNiveau(Niveau niveau, Pageable pageable);

    Page<Equipe> findByNomEquipeContaining(String nomEquipe, Pageable pageable);

    List<Equipe> findByNomEquipeContaining(String nomEquipe, Sort sort);

    List<Equipe> findEquipeByOrderByNomEquipeDesc();
    List<Equipe> findEquipeByOrderByNomEquipeAsc();
}

