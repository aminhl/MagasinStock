package com.nexthope.magasinstock.repositories;

import com.nexthope.magasinstock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
