package tn.esprit.projetkaddem.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esprit.projetkaddem.Entities.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Option option;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private Set<Contrat> contrats;

    @ManyToOne
    @JsonIgnore
    private Departement departement;

    @ManyToMany()
    @JsonIgnore
    private Set<Equipe> equipes;


}
