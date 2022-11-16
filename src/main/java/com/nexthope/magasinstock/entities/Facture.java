package com.nexthope.magasinstock.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private float montantRemise;
    private float montantFacture;
    @Temporal(TemporalType.DATE)
    private Date dateCreationFacture;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereFacture;
    private boolean archivee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
    Set<Reglement> reglements;
    @ManyToOne
    Fournisseur fournisseur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
    Set<DetailFacture> detailFactures;
}
