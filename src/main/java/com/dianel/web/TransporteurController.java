package com.dianel.web;

import com.dianel.entity.Transporteur;
import com.dianel.services.TransporteurService;
import com.dianel.web.api.TransporteurControllerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class TransporteurController implements TransporteurControllerApi {

    private final TransporteurService transporteurService;

    @Override
    public ResponseEntity<Transporteur> createTransporteur(Transporteur transporteur) {
        return transporteurService.createTransporteur(transporteur);
    }

    @Override
    public ResponseEntity<Transporteur> getTransporteurById(Long id) {
        return transporteurService.getTransporteurById(id);
    }

    @Override
    public ResponseEntity<Transporteur> updateTransporteur(Long id, Transporteur transporteur) {
        return transporteurService.updateTransporteur(id, transporteur);
    }

    @Override
    public ResponseEntity<String> deleteTransporteur(Long id) {
        return transporteurService.deleteTransporteur(id);
    }

    @Override
    public ResponseEntity<Page<Transporteur>> getAllTransporteurs(int page, int size) {
        return transporteurService.getAllTransporteurs(page, size);
    }
}
