package com.dianel.services;

import com.dianel.entity.Transporteur;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface TransporteurService {
    ResponseEntity<Transporteur> createTransporteur(Transporteur transporteur);
    ResponseEntity<Transporteur> getTransporteurById(Long id);
    ResponseEntity<Transporteur> updateTransporteur(Long id, Transporteur transporteur);
    ResponseEntity<String> deleteTransporteur(Long id);
    ResponseEntity<Page<Transporteur>> getAllTransporteurs(int page, int size);
}
