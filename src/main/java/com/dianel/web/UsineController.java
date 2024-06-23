package com.dianel.web;

import com.dianel.entity.Usine;
import com.dianel.services.UsineService;
import com.dianel.web.api.UsineControllerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class UsineController implements UsineControllerApi {

    private final UsineService usineService;

    @Override
    public ResponseEntity<Usine> createUsine(Usine usine) {
        return usineService.createUsine(usine);
    }

    @Override
    public ResponseEntity<Usine> getUsineById(Long id) {
        return usineService.getUsineById(id);
    }

    @Override
    public ResponseEntity<Usine> updateUsine(Long id, Usine usine) {
        return usineService.updateUsine(id, usine);
    }

    @Override
    public ResponseEntity<String> deleteUsine(Long id) {
        return usineService.deleteUsine(id);
    }

    @Override
    public ResponseEntity<Page<Usine>> getAllUsines(int page, int size) {
        return usineService.getAllUsines(page, size);
    }
}
