package com.dianel.web;

import com.dianel.dto.ProduitDto;
import com.dianel.entity.Produit;
import com.dianel.services.ProductService;
import com.dianel.web.api.ProduitControllerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class ProduitController implements ProduitControllerApi {
    private final ProductService productService;
    @Override
    public ResponseEntity<Produit> createProduit(ProduitDto produit) {
        return productService.createProduit(produit);
    }

    @Override
    public ResponseEntity<Produit> getProduitById(Long id) {
        return productService.getProduitById(id);
    }

    @Override
    public ResponseEntity<Produit> updateProduit(Long id, ProduitDto produit) {
        return productService.updateProduit(id, produit);
    }

    @Override
    public ResponseEntity<String> deleteProduit(Long id) {
        return productService.deleteProduit(id);
    }

    @Override
    public ResponseEntity<Page<Produit>> getAllProduits(int page, int size) {
        return productService.getAllProduits(page, size);
    }
}
