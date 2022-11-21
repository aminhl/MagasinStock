package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.Operateur;

import java.util.List;

public interface IOperateurService {

    List<Operateur> retrieveAllOperateurs();

    Operateur addOperateur (Operateur o);

    Operateur updateOperateur (Operateur o);

    Operateur retrieveOperateur (Long id);

    void removeOperateur (Long id);
     void assignOperateurToFacture(Long idOperateur, Long idFacture);
}
