package com.ecommerce.controller;

import com.ecommerce.model.Produit;
import com.ecommerce.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @GetMapping
    public ResponseEntity<List<Produit>> getAll() {
        return ResponseEntity.ok(produitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getById(@PathVariable Long id) {
        return ResponseEntity.ok(produitService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produit> create(@Valid @RequestBody Produit produit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produitService.save(produit));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> update(@PathVariable Long id, @Valid @RequestBody Produit produit) {
        return ResponseEntity.ok(produitService.update(id, produit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
