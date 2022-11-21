package com.nexthope.magasinstock.services;

import com.nexthope.magasinstock.entities.CategorieProduit;
import com.nexthope.magasinstock.repositories.CategorieProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategorieProduitService implements  ICategorieProduitService{

    private final CategorieProduitRepository categorieProduitRepo;

    public CategorieProduitService(CategorieProduitRepository categorieProduitRepo) {
        this.categorieProduitRepo = categorieProduitRepo;
    }

    @Override
    public List<CategorieProduit> retrieveAllCategorieProduits() {
        return  categorieProduitRepo.findAll();
    }

    @Override
    public CategorieProduit addCategorieProduit(CategorieProduit cp) {
        return categorieProduitRepo.save(cp);
    }

    @Override
    public CategorieProduit updateCategorieProduit(CategorieProduit cp) {
            return categorieProduitRepo.save(cp);
    }

    @Override
    public CategorieProduit retrieveCategorieProduit(Long id) {
        return categorieProduitRepo
                .findById(id).
                orElseThrow(() -> new IllegalStateException("no such Categorie with id " +id));
    }

    @Override
    public void removeCategorieProduit(Long id) {
        Optional<CategorieProduit> byId = categorieProduitRepo.findById(id);

        if(byId.isPresent()){
            categorieProduitRepo.deleteById(id);
        }
    }
}
