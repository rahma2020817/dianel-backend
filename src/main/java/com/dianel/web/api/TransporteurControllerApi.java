package com.dianel.web.api;

import com.dianel.entity.Transporteur;
import com.dianel.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(Constants.APP_ROOT + Constants.TRANSPORTEURS)
public interface TransporteurControllerApi {

    @PostMapping
    ResponseEntity<Transporteur> createTransporteur(Transporteur transporteur);

    @GetMapping(Constants.ID)
    ResponseEntity<Transporteur> getTransporteurById(@PathVariable Long id);

    @PutMapping(Constants.ID)
    ResponseEntity<Transporteur> updateTransporteur(@PathVariable Long id, @RequestBody Transporteur transporteur);

    @DeleteMapping(Constants.ID)
    ResponseEntity<String> deleteTransporteur(@PathVariable Long id);

    @GetMapping
    ResponseEntity<Page<Transporteur>> getAllTransporteurs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );
}

