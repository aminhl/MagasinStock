package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.Facture;
import com.nexthope.magasinstock.entities.Operateur;
import com.nexthope.magasinstock.repositories.FactureRepository;
import com.nexthope.magasinstock.repositories.OperateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateurService implements IOperateurService{

    private final OperateurRepository operateurRepo;
    private final FactureRepository factureRepo;


    public OperateurService(OperateurRepository operateurRepo, FactureRepository factureRepo) {
        this.operateurRepo = operateurRepo;
        this.factureRepo = factureRepo;
    }

    @Override
    public List<Operateur> retrieveAllOperateurs() {
        return operateurRepo.findAll();
    }

    @Override
    public Operateur addOperateur(Operateur operateur) {
        return operateurRepo.save(operateur);
    }

    @Override
    public Operateur updateOperateur(Operateur operateur) {
        return operateurRepo.save(operateur);
    }

    @Override
    public Operateur retrieveOperateur(Long id) {
        return operateurRepo.findById(id).orElse(null);
    }

    @Override
    public void removeOperateur(Long id) {
        operateurRepo.deleteById(id);

    }

    @Override
    public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
        Operateur operateur = operateurRepo.findById(idOperateur).orElse(null);
        Facture facture = factureRepo.findById(idFacture).orElse(null);
        if (operateur != null) {
            operateur.getFactures().add(facture);
            operateurRepo.save(operateur);
        }
    }
}
