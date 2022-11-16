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
public class Operateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperateur;
    private String nom;
    private String prenom;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    Set<Facture> factures;
}
