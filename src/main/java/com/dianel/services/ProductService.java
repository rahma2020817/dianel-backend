package com.dianel.services;

import com.dianel.dto.ProduitDto;
import com.dianel.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<Produit> createProduit(ProduitDto produit);
    ResponseEntity<Produit> getProduitById(Long id);
    ResponseEntity<Produit> updateProduit(Long id, ProduitDto produit);
    ResponseEntity<String>  deleteProduit(Long id);
    ResponseEntity<Page<Produit>> getAllProduits(int page, int size);
}
