package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.Facture;
import com.nexthope.magasinstock.entities.Reglement;
import com.nexthope.magasinstock.repositories.FactureRepository;
import com.nexthope.magasinstock.repositories.ReglementRepository;

import java.util.Date;
import java.util.List;

public class ReglementService implements IReglementService{
    private final ReglementRepository reglementRepo;
    private final FactureRepository factureRepo;

    public ReglementService(ReglementRepository reglementRepo, FactureRepository factureRepo) {
        this.reglementRepo = reglementRepo;
        this.factureRepo = factureRepo;
    }

    @Override
    public List<Reglement> retrieveReglementByFacture(Long idFacture) {
        Facture facture = factureRepo.findById(idFacture).orElse(null);
        if(facture != null)
            return reglementRepo.findReglementsByFacture(facture);
         return null;
    }

    @Override
    public Reglement addReglement(Reglement r, Long idFacture) {
        Facture facture = factureRepo.findById(idFacture).orElse(null);
        if (facture != null) {
            float somme = facture.getMontantFacture() - facture.getMontantRemise();
            for (Reglement re : facture.getReglements()) {
                somme = -re.getMontantPaye();
            }
            if (r.getMontantPaye() >= somme) {
             return reglementRepo.save(r);
            }
        }
        return null;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Reglement> reglements = reglementRepo.findReglementsByDateReglementAfterAndDateReglementBefore(startDate, endDate);
       float global=0 ;
        for (Reglement re : reglements){
           if(!re.getFacture().isArchivee()){
               global =+ re.getMontantPaye();
           }
        }
        return global;
    }

    @Override
    public float pourcentageRecouvrement(Date startDate, Date endDate) {
        List<Reglement> reglements = reglementRepo.findReglementsByDateReglementAfterAndDateReglementBefore(startDate, endDate);
        int c = 1 ;
        for (Reglement re : reglements){
            if(!re.getFacture().isArchivee()) c +=1;
        }
        return (reglements.size()/c);
    }
}
