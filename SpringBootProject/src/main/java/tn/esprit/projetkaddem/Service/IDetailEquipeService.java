package tn.esprit.projetkaddem.Service;

import tn.esprit.projetkaddem.Entities.DetailEquipe;
import tn.esprit.projetkaddem.Entities.Equipe;

import java.util.List;

public interface IDetailEquipeService {


    public List<DetailEquipe> getDetailEquipes();

    public DetailEquipe saveDetailEquipe(DetailEquipe DetailEquipe);
    public List<DetailEquipe> saveDetailEquipes(List<DetailEquipe> DetailEquipe);

    public void deleteDetailEquipe(Long idDetailEquipe);
    public DetailEquipe upadateDetailEquipe(DetailEquipe detailEquipe , Long idDetailEquipe );
    DetailEquipe getEquipeById(Long id);


}
