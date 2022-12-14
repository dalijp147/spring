package tn.esprit.projetkaddem.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.projetkaddem.Entities.Specialite;

@Entity
@AllArgsConstructor
@Data
public class Contrat  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal (TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal (TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite Specialite;
    private Boolean archive;

    @ManyToOne
    private Etudiant etudiant;

    public Contrat() {
    }
}
