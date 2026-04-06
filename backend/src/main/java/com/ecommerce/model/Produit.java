package com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Column(nullable = false)
    private String nom;

    private String description;

    @NotNull(message = "Le prix est obligatoire")
    @Min(value = 0, message = "Le prix doit être positif")
    private Double prix;

    @Min(value = 0, message = "Le stock doit être positif")
    private Integer stock = 0;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
}
