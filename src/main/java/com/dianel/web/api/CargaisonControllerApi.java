package com.dianel.web.api;

import com.dianel.dto.CargaisonDto;
import com.dianel.entity.Cargaison;
import com.dianel.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(Constants.APP_ROOT + Constants.CARGAISONS)
public interface CargaisonControllerApi {

    @PostMapping
    ResponseEntity<Cargaison> createCargaison(CargaisonDto cargaison);

    @GetMapping(Constants.ID)
    ResponseEntity<Cargaison> getCargaisonById(@PathVariable Long id);

    @PutMapping(Constants.ID)
    ResponseEntity<Cargaison> updateCargaison(@PathVariable Long id, @RequestBody CargaisonDto cargaison);

    @DeleteMapping(Constants.ID)
    ResponseEntity<String> deleteCargaison(@PathVariable Long id);

    @GetMapping
    ResponseEntity<Page<Cargaison>> getAllCargaisons(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );
}
