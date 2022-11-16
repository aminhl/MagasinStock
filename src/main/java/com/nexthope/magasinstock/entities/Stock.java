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
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    private Integer qte;
    private Integer qteMin;
    private String libelleStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private Set<Produit> produits;
}
