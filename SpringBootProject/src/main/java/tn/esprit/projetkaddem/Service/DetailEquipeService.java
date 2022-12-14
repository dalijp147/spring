package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.DetailEquipe;
import tn.esprit.projetkaddem.Entities.Equipe;
import tn.esprit.projetkaddem.Repository.DetailEquipeRepository;

import java.util.List;


@AllArgsConstructor
@Service
public class DetailEquipeService implements IDetailEquipeService {

    DetailEquipeRepository DetailEquipeRepository;


    @Override
    public List<DetailEquipe> getDetailEquipes(){
        return DetailEquipeRepository.findAll();
    }


    @Override
    public DetailEquipe saveDetailEquipe(DetailEquipe DetailEquipe){
        return DetailEquipeRepository.save(DetailEquipe);
    }


    @Override
    public List<DetailEquipe> saveDetailEquipes(List<DetailEquipe> DetailEquipe){
        return DetailEquipeRepository.saveAll(DetailEquipe);
    }

    @Override
    public void deleteDetailEquipe(Long idDetailEquipe){
        DetailEquipeRepository.deleteById(idDetailEquipe);
    }

    @Override
    public DetailEquipe upadateDetailEquipe(DetailEquipe detailEquipe, Long idDetailEquipe) {
        DetailEquipe equip = this.getEquipeById(idDetailEquipe);
        equip.setSalle(detailEquipe.getSalle());
        equip.setThematique(detailEquipe.getThematique());


        return DetailEquipeRepository.save(equip);
    }

    @Override
    public DetailEquipe getEquipeById(Long id) {
        return DetailEquipeRepository.findById(id).orElse(null);
    }


}
