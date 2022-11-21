package com.nexthope.magasinstock.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DetailFournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDetailFournisseur;
    Date dateDebutCollaboration;
    String adresse;
    String matricule;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "detailFournisseur" )
    Fournisseur fournisseur;
}
