package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.Facture;
import com.nexthope.magasinstock.entities.Fournisseur;
import com.nexthope.magasinstock.repositories.FactureRepository;
import com.nexthope.magasinstock.repositories.FournisseurRepository;
import com.nexthope.magasinstock.repositories.OperateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService implements IFactureService{

    private final FactureRepository factureRepo;
    private final FournisseurRepository fournisseurRepo;



    public FactureService(FactureRepository factureRepo, OperateurRepository operateurRepo, FournisseurRepository fournisseurRepo) {
        this.factureRepo = factureRepo;

        this.fournisseurRepo = fournisseurRepo;
    }

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepo.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        Facture facture = factureRepo.findById(id).orElse(null);
        if(facture.isArchivee()){
            factureRepo.delete(facture);
        }

    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepo.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
        Fournisseur fournisseur = fournisseurRepo.findById(idFournisseur).orElse(null);
        if (fournisseur !=null){
        return factureRepo.findFacturesByFournisseur(fournisseur);}
        return null;
    }


}
