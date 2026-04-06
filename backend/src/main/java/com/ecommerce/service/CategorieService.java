package com.ecommerce.service;

import com.ecommerce.model.Categorie;
import com.ecommerce.repository.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    public Categorie findById(Long id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'id: " + id));
    }

    public Categorie save(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie update(Long id, Categorie categorieDetails) {
        Categorie categorie = findById(id);
        categorie.setNom(categorieDetails.getNom());
        categorie.setDescription(categorieDetails.getDescription());
        return categorieRepository.save(categorie);
    }

    public void delete(Long id) {
        findById(id);
        categorieRepository.deleteById(id);
    }
}
