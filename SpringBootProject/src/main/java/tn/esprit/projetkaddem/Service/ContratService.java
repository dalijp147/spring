package tn.esprit.projetkaddem.Service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.projetkaddem.Entities.Contrat;
import tn.esprit.projetkaddem.Entities.Etudiant;
import tn.esprit.projetkaddem.Repository.ContratRepository;
import tn.esprit.projetkaddem.Repository.EtudiantRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@Service
public class ContratService implements IContratService{


    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getAllcontrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratByID(Long idContrat) {
        return contratRepository.findById(idContrat).get();
    }

    @Override
    public Contrat saveContrat(Contrat Contrat){
        return contratRepository.save(Contrat);
    }


    @Override
    public List<Contrat> saveAllContrats(List<Contrat> contrats){
        return contratRepository.saveAll(contrats);
    }

    @Override
    public String deleteContrat(Long idContrat){
        contratRepository.deleteById(idContrat);
        return "Contrat supprimé !";
    }

    @Override
    public Contrat upadateContrat(Contrat contrat){
        Contrat existingContrat = contratRepository.findById(contrat.getId()).orElse(null);
        assert existingContrat != null;
        existingContrat.setDateDebutContrat(contrat.getDateDebutContrat());
        existingContrat.setDateFinContrat(contrat.getDateFinContrat());
        existingContrat.setArchive(contrat.getArchive());
        existingContrat.setSpecialite(contrat.getSpecialite());

        return contratRepository.save(existingContrat);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nom, String prenom) {
        Etudiant etudiant=etudiantRepository.findByPrenom(prenom);
        if (etudiant.getContrats().size()<5) {
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);
        }
        else{
            System.out.println("Cannot Affect anymore");
        }

        return ce;
    }


    @Override
    public Integer nbContratsValides(Date DD, Date DF) {
        int j=0 ;
        List< Contrat> listContrats= contratRepository.findAll();

        for(int i=0;i<listContrats.size();i++){
            Contrat c=listContrats.get(i);

            if(c.getArchive()==false){
                j++;
                System.out.println("Les contrats dispo sont :" + j);
            }

        }


        return j;
    }


    @Override
    public float getChiffreAffaireEntreDeuxDate(Date DD, Date DF) {

        float ciffreAff=0;
        int nbrMois=1;

        List<Contrat> contrat= contratRepository.findAll();

        for(int i=0;i<contrat.size();i++){
            Contrat c=contrat.get(i);
            int dd=Integer.parseInt(c.getDateDebutContrat().toString().substring(5,7));
            int df=Integer.parseInt(c.getDateFinContrat().toString().substring(5,7));

                nbrMois=(df-dd);

            if(c.getArchive()==false){

                System.out.println("*******"+nbrMois);

                if(c.getSpecialite().toString()=="IA"){
                    ciffreAff+=nbrMois*300;

                }
                else if(c.getSpecialite().toString()=="RESEAUX"){
                    ciffreAff+=nbrMois*350;
                }
                else if(c.getSpecialite().toString()=="CLOUD"){
                    ciffreAff+=nbrMois*400;
                }
                else if(c.getSpecialite().toString()=="SECURITE"){
                    ciffreAff+=nbrMois*450;
                }

            }

        }
        return ciffreAff;
    }



    /*
    String retrieveAndUpdateStatusContrat(){

        List<Contrat> listContarts = contratRepository.findAll();


        for(int i=0;i<listContarts.size();i++) {
            Contrat c=listContarts.get(i);
            if(c.getArchive()==false){


            }

        }



        return null;
    }

     */


}
