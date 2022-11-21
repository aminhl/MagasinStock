package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.Produit;
import com.nexthope.magasinstock.entities.Stock;
import com.nexthope.magasinstock.repositories.ProduitRepository;
import com.nexthope.magasinstock.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService implements IStockService{
    private final StockRepository stockRepo;
    private final ProduitRepository produitRepo;

    public StockService(StockRepository stockRepo, ProduitRepository produitRepo) {
        this.stockRepo = stockRepo;
        this.produitRepo = produitRepo;
    }

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepo.findAll();
    }

    @Override
    public Stock addStock(Stock stock) {
        return stockRepo.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock) {
        return stockRepo.save(stock);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepo.findById(id).orElse(null);
    }

    @Override
    public void removeStock(Long id) {
        if (stockRepo.findById(id).isPresent()) stockRepo.deleteById(id);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit = produitRepo.findById(idProduit).orElse(null);
        Stock stock = stockRepo.findById(idStock).orElse(null);
        if (stock != null) {
            stock.getProduits().add(produit);
            stockRepo.save(stock);
        }
    }
}
