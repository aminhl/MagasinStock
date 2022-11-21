package com.nexthope.magasinstock.repositories;

import com.nexthope.magasinstock.entities.Facture;
import com.nexthope.magasinstock.entities.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReglementRepository extends JpaRepository<Reglement, Long> {
    List<Reglement> findReglementsByFacture(Facture facture);
    List<Reglement> findReglementsByDateReglementAfterAndDateReglementBefore(Date after , Date before);
}
