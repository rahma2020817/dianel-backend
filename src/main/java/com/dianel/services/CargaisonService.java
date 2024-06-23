package com.dianel.services;

import com.dianel.dto.CargaisonDto;
import com.dianel.entity.Cargaison;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface CargaisonService {
    ResponseEntity<Cargaison> createCargaison(CargaisonDto cargaison);
    ResponseEntity<Cargaison> getCargaisonById(Long id);
    ResponseEntity<Cargaison> updateCargaison(Long id, CargaisonDto cargaison);
    ResponseEntity<String> deleteCargaison(Long id);
    ResponseEntity<Page<Cargaison>> getAllCargaisons(int page, int size);
}
