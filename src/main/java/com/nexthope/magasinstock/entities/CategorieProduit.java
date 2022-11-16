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
public class CategorieProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategorieProduit;
    String codeProduit;
    String libelleCategorieProduit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieProduit")
    Set<Produit> produits;
}
