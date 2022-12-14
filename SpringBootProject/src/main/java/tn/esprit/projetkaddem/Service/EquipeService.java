package tn.esprit.projetkaddem.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Entities.Niveau;
import tn.esprit.projetkaddem.Repository.ContratRepository;
import tn.esprit.projetkaddem.Repository.EquipeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
@Slf4j
public class EquipeService implements IEquipeService {


    EquipeRepository equipeRepository;
    ContratRepository contratRepository;


    @Override
    public List<Equipe> getEquipes(){
        return equipeRepository.findAll();
    }

    @Override
    public Equipe saveEquipe(Equipe equipe){
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> saveEquipes(List<Equipe> equipes){
        return equipeRepository.saveAll(equipes);
    }


    @Override
    public void deleteEquipe(Long id){
        equipeRepository.deleteById(id);
    }

        @Override
        public List<Equipe> searchProducts(String query) {
            List<Equipe> equipes = equipeRepository.searchProducts(query);
            return equipes;
        }


    @Override
    public Equipe upadateEquipe(Equipe e , Long idEquipe){
        Equipe equip = this.getEquipeById(idEquipe);
        equip.setNomEquipe(e.getNomEquipe());
        equip.setNiveau(e.getNiveau());


        return equipeRepository.save(equip);

    }

    @Override
    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> findEquipeByDetailEquipeThematique(String tg) {
        return equipeRepository.findEquipeByDetailEquipeThematique(tg);
    }


    @Override
    public void faireEvoluerEquipes() {

        int dureEnMois=0;

        List<Equipe> equipes = equipeRepository.findAll();
        List<Contrat> contrats = contratRepository.findAll();

        for (int i=0; i<=equipes.size(); i++){
            for (int j=0; j<=contrats.size(); j++){
                Contrat c=contrats.get(j);
                int dd=Integer.parseInt(c.getDateDebutContrat().toString());
                int df=Integer.parseInt(c.getDateFinContrat().toString());
                dureEnMois = df - dd;
            }
            Equipe equi=equipes.get(i);
            if (dureEnMois==12 | equi.getNiveau().toString()=="JUNIOR"){
                equi.setNiveau(Niveau.SENIOR);
            }else if (dureEnMois==12 | equi.getNiveau().toString()=="SENIOR"){
                equi.setNiveau(Niveau.EXPERT);
            }else{
                System.out.println("Conditions non respectés");
            }
        }
    }

    @Override
    public List<Equipe> findEquipeByOrderByNomEquipeDesc() {
        return equipeRepository.findEquipeByOrderByNomEquipeDesc();
    }

    @Override
    public   List<Equipe> findEquipeByOrderByNomEquipeAsc(){
        return equipeRepository.findEquipeByOrderByNomEquipeAsc();
    }



    @Override
    public List<Equipe> getUsersByPagination(int pageNo, int pageSize) {
        //create pagerequest object
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        //pass it to repos
        Page<Equipe> pagingUser = equipeRepository.findAll(pageRequest);
        //pagingUser.hasContent(); -- to check pages are there or not
        return pagingUser.getContent();
    }
    @Override
    public long calculNiveau(Niveau niveau) {
        return equipeRepository.calculNiveau(niveau);
    }

}
