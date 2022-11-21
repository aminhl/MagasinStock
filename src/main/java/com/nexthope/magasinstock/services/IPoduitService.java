package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.Produit;

import java.util.List;

public interface IPoduitService {

    List<Produit> retrieveAllProduits();

    Produit addProduit (Produit p, Long idCategorieProduit, Long idStock);

    Produit updateProduit (Produit p, Long idCategorieProduit, Long idStock);

    Produit retrieveProduit(Long id);


}
