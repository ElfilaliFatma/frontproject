package com.ecommerce.controller;

import com.ecommerce.model.Categorie;
import com.ecommerce.service.CategorieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CategorieController {

    private final CategorieService categorieService;

    @GetMapping
    public ResponseEntity<List<Categorie>> getAll() {
        return ResponseEntity.ok(categorieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categorieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Categorie> create(@Valid @RequestBody Categorie categorie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categorieService.save(categorie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorie> update(@PathVariable Long id, @Valid @RequestBody Categorie categorie) {
        return ResponseEntity.ok(categorieService.update(id, categorie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categorieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
