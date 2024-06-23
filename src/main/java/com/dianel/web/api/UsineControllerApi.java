package com.dianel.web.api;

import com.dianel.entity.Usine;
import com.dianel.utils.Constants;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(Constants.APP_ROOT + Constants.USINES)
public interface UsineControllerApi {

    @PostMapping
    ResponseEntity<Usine> createUsine(Usine usine);

    @GetMapping(Constants.ID)
    ResponseEntity<Usine> getUsineById(@PathVariable Long id);

    @PutMapping(Constants.ID)
    ResponseEntity<Usine> updateUsine(@PathVariable Long id, @RequestBody Usine usine);

    @DeleteMapping(Constants.ID)
    ResponseEntity<String> deleteUsine(@PathVariable Long id);

    @GetMapping
    ResponseEntity<Page<Usine>> getAllUsines(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );
}

