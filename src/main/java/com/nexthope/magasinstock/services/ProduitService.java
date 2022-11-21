package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.Produit;
import com.nexthope.magasinstock.repositories.ProduitRepository;
import com.nexthope.magasinstock.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements  IPoduitService{

    private final ProduitRepository produitRepo;
    private final StockRepository stockRepo;


    public ProduitService(ProduitRepository produitRepo, StockRepository stockRepo) {
        this.produitRepo = produitRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepo.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) {
        p.setIdProduit(idCategorieProduit);
        p.setStock(stockRepo.findById(idStock).orElse(null));
        return produitRepo.save(p);
    }

    @Override
    public Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock) {
        p.setIdProduit(idCategorieProduit);
        p.setStock(stockRepo.findById(idStock).orElse(null));
        return produitRepo.save(p);
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepo.findById(id).orElse(null);
    }


}
