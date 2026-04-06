package com.ecommerce.service;

import com.ecommerce.model.Fournisseur;
import com.ecommerce.repository.FournisseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    public List<Fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur findById(Long id) {
        return fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé avec l'id: " + id));
    }

    public Fournisseur save(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public Fournisseur update(Long id, Fournisseur fournisseurDetails) {
        Fournisseur fournisseur = findById(id);
        fournisseur.setNom(fournisseurDetails.getNom());
        fournisseur.setEmail(fournisseurDetails.getEmail());
        fournisseur.setTelephone(fournisseurDetails.getTelephone());
        fournisseur.setAdresse(fournisseurDetails.getAdresse());
        fournisseur.setVille(fournisseurDetails.getVille());
        return fournisseurRepository.save(fournisseur);
    }

    public void delete(Long id) {
        findById(id);
        fournisseurRepository.deleteById(id);
    }
}
