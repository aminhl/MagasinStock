package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.CategorieProduit;

import java.util.List;

public interface ICategorieProduitService {

    List<CategorieProduit> retrieveAllCategorieProduits();

    CategorieProduit addCategorieProduit(CategorieProduit cp);

    CategorieProduit updateCategorieProduit(CategorieProduit cp);

    CategorieProduit retrieveCategorieProduit(Long id);

    void removeCategorieProduit(Long id);

}
