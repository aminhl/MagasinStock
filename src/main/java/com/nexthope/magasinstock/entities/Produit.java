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
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private String prix;
    private Date dateCreation;
    private Date dateDerniereModification;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Set<DetailFacture> detailFacture;
    @ManyToOne(cascade = CascadeType.ALL)
    private CategorieProduit categorieProduit;
    @ManyToOne(cascade = CascadeType.ALL)
    private Stock stock;
}
