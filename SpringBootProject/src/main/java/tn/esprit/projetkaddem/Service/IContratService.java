package tn.esprit.projetkaddem.Service;

import tn.esprit.projetkaddem.Entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {


    public List<Contrat> getAllcontrats();

    public Contrat getContratByID(Long idContrat);

    public Contrat saveContrat(Contrat Contrat);
    public List<Contrat> saveAllContrats(List<Contrat> contrats);

    public String deleteContrat(Long idContrat);

    public Contrat upadateContrat(Contrat contrat);

    public Contrat affectContratToEtudiant(Contrat ce, String nom,String prenom);

    public Integer nbContratsValides(Date startDate, Date endDate);

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
}
