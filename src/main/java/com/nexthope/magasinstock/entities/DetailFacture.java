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
public class DetailFacture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailFacture;
    private Integer qteCommande;
    private float prixTotalDetail;
    private Integer pourcentageRemise;
    private float montantRemise;
    @ManyToOne
    Facture facture;
    @ManyToOne(cascade = CascadeType.ALL)
    Produit produit;
}
