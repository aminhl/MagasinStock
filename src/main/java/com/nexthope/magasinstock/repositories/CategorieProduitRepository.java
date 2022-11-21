package com.nexthope.magasinstock.repositories;

import com.nexthope.magasinstock.entities.CategorieProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieProduitRepository extends JpaRepository<CategorieProduit, Long> {
}
