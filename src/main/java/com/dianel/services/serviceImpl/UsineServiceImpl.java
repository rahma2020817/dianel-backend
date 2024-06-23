package com.dianel.services.serviceImpl;

import com.dianel.dao.UsineRepository;
import com.dianel.entity.Usine;
import com.dianel.services.UsineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsineServiceImpl implements UsineService {

    private final UsineRepository usineRepository;

    @Override
    public ResponseEntity<Usine> createUsine(Usine usine) {
        try {
            Usine newUsine = usineRepository.save(usine);
            return new ResponseEntity<>(newUsine, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Usine> getUsineById(Long id) {
        Usine usine = usineRepository.findById(id).orElse(null);
        if (usine != null) {
            return new ResponseEntity<>(usine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Usine> updateUsine(Long id, Usine usine) {
        Usine existingUsine = usineRepository.findById(id).orElse(null);
        if (existingUsine != null) {
            existingUsine.setNom(usine.getNom());
            // Mettez à jour les autres attributs
            Usine updatedUsine = usineRepository.save(existingUsine);
            return new ResponseEntity<>(updatedUsine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteUsine(Long id) {
        try {
            usineRepository.deleteById(id);
            return new ResponseEntity<>("Usine supprimée avec succès", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Page<Usine>> getAllUsines(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Usine> usines = usineRepository.findAll(pageable);
            return new ResponseEntity<>(usines, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
