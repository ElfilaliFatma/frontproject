package com.ecommerce.service;

import com.ecommerce.model.Categorie;
import com.ecommerce.model.Fournisseur;
import com.ecommerce.model.Produit;
import com.ecommerce.repository.CategorieRepository;
import com.ecommerce.repository.FournisseurRepository;
import com.ecommerce.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;
    private final FournisseurRepository fournisseurRepository;

    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    public Produit findById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id: " + id));
    }

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit update(Long id, Produit produitDetails) {
        Produit produit = findById(id);
        produit.setNom(produitDetails.getNom());
        produit.setDescription(produitDetails.getDescription());
        produit.setPrix(produitDetails.getPrix());
        produit.setStock(produitDetails.getStock());
        produit.setImageUrl(produitDetails.getImageUrl());
        produit.setCategorie(produitDetails.getCategorie());
        produit.setFournisseur(produitDetails.getFournisseur());
        return produitRepository.save(produit);
    }

    public void delete(Long id) {
        findById(id);
        produitRepository.deleteById(id);
    }
}
