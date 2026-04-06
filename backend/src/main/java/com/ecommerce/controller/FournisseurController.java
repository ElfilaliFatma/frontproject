package com.ecommerce.controller;

import com.ecommerce.model.Fournisseur;
import com.ecommerce.service.FournisseurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class FournisseurController {

    private final FournisseurService fournisseurService;

    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAll() {
        return ResponseEntity.ok(fournisseurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id) {
        return ResponseEntity.ok(fournisseurService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Fournisseur> create(@Valid @RequestBody Fournisseur fournisseur) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fournisseurService.save(fournisseur));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> update(@PathVariable Long id, @Valid @RequestBody Fournisseur fournisseur) {
        return ResponseEntity.ok(fournisseurService.update(id, fournisseur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fournisseurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
