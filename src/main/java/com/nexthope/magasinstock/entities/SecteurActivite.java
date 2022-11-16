package com.nexthope.magasinstock.entities;

import lombok.*;
import org.hibernate.annotations.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SecteurActivite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long secteurActivite;
    String codeSecteurActivite;
    String libelleSecteurActivite;
}
