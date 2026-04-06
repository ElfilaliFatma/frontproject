package com.ecommerce;

import com.ecommerce.model.Categorie;
import com.ecommerce.model.Fournisseur;
import com.ecommerce.model.Produit;
import com.ecommerce.repository.CategorieRepository;
import com.ecommerce.repository.FournisseurRepository;
import com.ecommerce.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategorieRepository categorieRepository;
    private final FournisseurRepository fournisseurRepository;
    private final ProduitRepository produitRepository;

    @Override
    public void run(String... args) {
        // Categories
        Categorie cat1 = categorieRepository.save(new Categorie(null, "Électronique", "Appareils électroniques et gadgets"));
        Categorie cat2 = categorieRepository.save(new Categorie(null, "Vêtements", "Mode et accessoires"));
        Categorie cat3 = categorieRepository.save(new Categorie(null, "Alimentation", "Produits alimentaires et boissons"));

        // Fournisseurs
        Fournisseur f1 = fournisseurRepository.save(new Fournisseur(null, "TechPro SARL", "contact@techpro.tn", "+216 71 000 001", "Avenue Habib Bourguiba", "Tunis"));
        Fournisseur f2 = fournisseurRepository.save(new Fournisseur(null, "Mode Express", "info@modeexpress.tn", "+216 71 000 002", "Rue de Marseille", "Sfax"));
        Fournisseur f3 = fournisseurRepository.save(new Fournisseur(null, "FoodMed", "contact@foodmed.tn", "+216 71 000 003", "Zone Industrielle", "Sousse"));

        // Produits
        produitRepository.save(new Produit(null, "Laptop HP 15", "Ordinateur portable 15 pouces, 8GB RAM, 256GB SSD", 1299.99, 25, "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=400", cat1, f1));
        produitRepository.save(new Produit(null, "Smartphone Samsung A54", "Téléphone 6.4 pouces, 128GB, 5G", 799.00, 50, "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=400", cat1, f1));
        produitRepository.save(new Produit(null, "Écouteurs Sony WH-1000XM5", "Casque sans fil avec réduction de bruit", 349.99, 30, "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400", cat1, f1));
        produitRepository.save(new Produit(null, "T-shirt Premium Blanc", "T-shirt 100% coton, coupe slim", 39.99, 100, "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=400", cat2, f2));
        produitRepository.save(new Produit(null, "Jean Bleu Classic", "Jean stretch taille moyenne", 89.99, 60, "https://images.unsplash.com/photo-1542272604-787c3835535d?w=400", cat2, f2));
        produitRepository.save(new Produit(null, "Huile d'olive Bio 1L", "Huile d'olive extra vierge, première pression", 15.50, 200, "https://images.unsplash.com/photo-1474979266404-7eaacbcd87c5?w=400", cat3, f3));
    }
}
