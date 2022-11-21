package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.Facture;

import java.util.List;

public interface IFactureService {

    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);

    List<Facture> getFacturesByFournisseur(Long idFournisseur);

}
