package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.Reglement;

import java.util.Date;
import java.util.List;

public interface IReglementService {
     List<Reglement> retrieveReglementByFacture(Long idFacture);

     Reglement addReglement(Reglement r, Long idFacture);

      float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

     float pourcentageRecouvrement(Date startDate, Date endDate);

}
