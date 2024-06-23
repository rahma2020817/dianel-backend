package com.dianel.services.serviceImpl;

import com.dianel.dao.TransporteurRepository;
import com.dianel.entity.Transporteur;
import com.dianel.services.TransporteurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransporteurServiceImpl implements TransporteurService {

    private final TransporteurRepository transporteurRepository;

    @Override
    public ResponseEntity<Transporteur> createTransporteur(Transporteur transporteur) {
        try {
            Transporteur newTransporteur = transporteurRepository.save(transporteur);
            return new ResponseEntity<>(newTransporteur, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Transporteur> getTransporteurById(Long id) {
        Transporteur transporteur = transporteurRepository.findById(id).orElse(null);
        if (transporteur != null) {
            return new ResponseEntity<>(transporteur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Transporteur> updateTransporteur(Long id, Transporteur transporteur) {
        Transporteur existingTransporteur = transporteurRepository.findById(id).orElse(null);
        if (existingTransporteur != null) {
            existingTransporteur.setNom(transporteur.getNom());
            // Mettez à jour les autres attributs
            Transporteur updatedTransporteur = transporteurRepository.save(existingTransporteur);
            return new ResponseEntity<>(updatedTransporteur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteTransporteur(Long id) {
        try {
            transporteurRepository.deleteById(id);
            return new ResponseEntity<>("Transporteur supprimé avec succès", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Page<Transporteur>> getAllTransporteurs(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Transporteur> transporteurs = transporteurRepository.findAll(pageable);
            return new ResponseEntity<>(transporteurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
