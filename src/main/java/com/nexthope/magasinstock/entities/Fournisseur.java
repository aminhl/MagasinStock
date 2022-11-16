package com.nexthope.magasinstock.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFournisseur;
    String codeFournisseur;
    String libelleFournisseur;
    @Enumerated(EnumType.STRING)
    CategorieFournisseur categorieFournisseur;
}
