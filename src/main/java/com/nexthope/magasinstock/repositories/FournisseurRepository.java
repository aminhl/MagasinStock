package com.nexthope.magasinstock.repositories;

import com.nexthope.magasinstock.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
