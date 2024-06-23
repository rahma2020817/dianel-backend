package com.dianel.services;

import com.dianel.entity.Usine;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface UsineService {
    ResponseEntity<Usine> createUsine(Usine usine);
    ResponseEntity<Usine> getUsineById(Long id);
    ResponseEntity<Usine> updateUsine(Long id, Usine usine);
    ResponseEntity<String> deleteUsine(Long id);
    ResponseEntity<Page<Usine>> getAllUsines(int page, int size);
}
