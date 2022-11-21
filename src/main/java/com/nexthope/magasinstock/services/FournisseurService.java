package com.nexthope.magasinstock.services;


import com.nexthope.magasinstock.entities.Fournisseur;
import com.nexthope.magasinstock.entities.SecteurActivite;
import com.nexthope.magasinstock.repositories.FournisseurRepository;
import com.nexthope.magasinstock.repositories.SecteurActiviteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService implements IFournisseurService{
  private final FournisseurRepository fournisseurRepo;
  private final SecteurActiviteRepository secteurActivieRepo;

    public FournisseurService(FournisseurRepository fournisseurRepo, SecteurActiviteRepository secteurActivieRepo) {
        this.fournisseurRepo = fournisseurRepo;
        this.secteurActivieRepo = secteurActivieRepo;
    }


    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        return fournisseurRepo.findAll();
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepo.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        Optional<Fournisseur> byId = fournisseurRepo.findById(f.getIdFournisseur());
        if (byId.isPresent()){
        return fournisseurRepo.save(f);}
        return null;

    }

    @Override
    public Fournisseur retrieveFournisseur(Long id) {
        return fournisseurRepo.findById(id).orElse(null);
    }

    @Override
    public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId) {
        Fournisseur fournisseur = fournisseurRepo.findById(fournisseurId).orElse(null);
        SecteurActivite secteurActivite = secteurActivieRepo.findById(secteurActiviteId).orElse(null);
        if (fournisseur != null) {
            fournisseur.getSecteurActivites().add(secteurActivite);
            fournisseurRepo.save(fournisseur);
        }
    }
}
