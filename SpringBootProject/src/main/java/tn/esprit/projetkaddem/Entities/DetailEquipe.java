package tn.esprit.projetkaddem.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int salle;
    public String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    @JsonIgnore
    private Equipe equipe;

    public DetailEquipe() {
    }

}
