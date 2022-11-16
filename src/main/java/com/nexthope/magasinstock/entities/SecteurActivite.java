package com.nexthope.magasinstock.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SecteurActivite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long secteurActivite;
    private String codeSecteurActivite;
    private String libelleSecteurActivite;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "secteurActivites")
    Set<Fournisseur> fournisseurs;
}
