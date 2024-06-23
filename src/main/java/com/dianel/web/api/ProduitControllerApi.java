package com.dianel.web.api;

import com.dianel.dto.ProduitDto;
import com.dianel.entity.Produit;
import com.dianel.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(Constants.APP_ROOT + Constants.PRODUCTS)
public interface ProduitControllerApi {

    @PostMapping
    ResponseEntity<Produit> createProduit(ProduitDto produit);
    @GetMapping(Constants.ID)
    ResponseEntity<Produit> getProduitById(@PathVariable Long id);
    @PutMapping(Constants.ID)
    ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody ProduitDto produit);
    @DeleteMapping(Constants.ID)
    ResponseEntity<String> deleteProduit(@PathVariable Long id);

    @GetMapping
     ResponseEntity<Page<Produit>> getAllProduits(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );
}
