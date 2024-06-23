package com.dianel.web;

import com.dianel.dto.CargaisonDto;
import com.dianel.entity.Cargaison;
import com.dianel.services.CargaisonService;
import com.dianel.web.api.CargaisonControllerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class CargaisonController implements CargaisonControllerApi {

    private final CargaisonService cargaisonService;

    @Override
    public ResponseEntity<Cargaison> createCargaison(CargaisonDto cargaison) {
        return cargaisonService.createCargaison(cargaison);
    }

    @Override
    public ResponseEntity<Cargaison> getCargaisonById(Long id) {
        return cargaisonService.getCargaisonById(id);
    }

    @Override
    public ResponseEntity<Cargaison> updateCargaison(Long id, CargaisonDto cargaison) {
        return cargaisonService.updateCargaison(id, cargaison);
    }

    @Override
    public ResponseEntity<String> deleteCargaison(Long id) {
        return cargaisonService.deleteCargaison(id);
    }

    @Override
    public ResponseEntity<Page<Cargaison>> getAllCargaisons(int page, int size) {
        return cargaisonService.getAllCargaisons(page, size);
    }
}
