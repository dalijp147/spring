package tn.esprit.projetkaddem.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.DetailEquipe;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Niveau;
import tn.esprit.projetkaddem.Repository.EquipeRepository;

import java.util.List;

public interface IEquipeService {

    public List<Equipe> getEquipes();

    public Equipe saveEquipe(Equipe equipe);
    public List<Equipe> saveEquipes(List<Equipe> equipes);

    public void deleteEquipe(Long id);
    List<Equipe> searchProducts(String query);

    public List<Equipe> getUsersByPagination(int pageNo, int pageSize);
    public Equipe upadateEquipe(Equipe e ,  Long idEquipe);
    Equipe getEquipeById(Long id);
   // List<Equipe> findEquipeByDetailEquipeThematiqueLike(String thematique);

    List<Equipe> findEquipeByDetailEquipeThematique(String tg);

    void faireEvoluerEquipes();
    public List<Equipe> findEquipeByOrderByNomEquipeDesc();
    List<Equipe> findEquipeByOrderByNomEquipeAsc();
    public long calculNiveau(Niveau niveau);

}
