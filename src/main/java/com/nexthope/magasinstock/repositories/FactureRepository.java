package com.nexthope.magasinstock.repositories;

import com.nexthope.magasinstock.entities.Facture;
import com.nexthope.magasinstock.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    List<Facture> findFacturesByFournisseur(Fournisseur fournisseur);
}
