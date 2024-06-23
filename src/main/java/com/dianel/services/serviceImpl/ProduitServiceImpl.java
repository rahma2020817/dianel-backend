package com.dianel.services.serviceImpl;

import com.dianel.dao.ProduitRepository;
import com.dianel.dto.ProduitDto;
import com.dianel.entity.Produit;
import com.dianel.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.dianel.dto.ProduitDto.mapToEntity;
import static com.dianel.utils.Messages.PRODUIT_NON_TROUVE;
import static com.dianel.utils.Messages.PRODUIT_SUPPRIME_AVEC_SUCCÈS;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProductService {

    private final ProduitRepository produitRepository;

    @Override
    public ResponseEntity<Produit> createProduit(ProduitDto produitDto) {
        try {
            Produit produit = mapToEntity(produitDto);
            Produit newProduit = produitRepository.save(produit);
            return new ResponseEntity<>(newProduit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Produit> getProduitById(Long id) {
        return produitRepository.findById(id)
                .map(produit -> new ResponseEntity<>(produit, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Produit> updateProduit(Long id, ProduitDto produitDto) {
        return produitRepository.findById(id)
                .map(existingProduit -> {
                    updateEntity(existingProduit, produitDto);
                    Produit updatedProduit = produitRepository.save(existingProduit);
                    return new ResponseEntity<>(updatedProduit, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<String> deleteProduit(Long id) {
        try {
            if (produitRepository.existsById(id)) {
                produitRepository.deleteById(id);
                return new ResponseEntity<>(PRODUIT_SUPPRIME_AVEC_SUCCÈS, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(PRODUIT_NON_TROUVE, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Page<Produit>> getAllProduits(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Produit> produits = produitRepository.findAll(pageable);
            return new ResponseEntity<>(produits, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void updateEntity(Produit existingProduit, ProduitDto produitDto) {
        existingProduit.setCodeProduit(produitDto.getCodeProduit());
        existingProduit.setNom(produitDto.getNom());
        existingProduit.setDescription(produitDto.getDescription());
        existingProduit.setAmateur(produitDto.getAmateur());
        existingProduit.setTaille(produitDto.getTaille());
        existingProduit.setTypeEmballage(produitDto.getTypeEmballage());
        existingProduit.setCodeChariot(produitDto.getCodeChariot());
    }
}
