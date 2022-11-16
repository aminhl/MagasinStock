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
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;
    private String codeFournisseur;
    private String libelleFournisseur;
    @Enumerated(EnumType.STRING)
    private CategorieFournisseur categorieFournisseur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fournisseur")
    Set<Facture> factures;
    @ManyToMany(cascade = CascadeType.ALL)
    Set<SecteurActivite> secteurActivites;
    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "detailFournisseur" )
    DetailFournisseur detailFournisseur;
}
