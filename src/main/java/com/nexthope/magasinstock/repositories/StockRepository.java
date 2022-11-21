package com.nexthope.magasinstock.repositories;

import com.nexthope.magasinstock.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
