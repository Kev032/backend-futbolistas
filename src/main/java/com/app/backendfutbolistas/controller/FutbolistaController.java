package com.app.backendfutbolistas.controller;

import com.app.backendfutbolistas.entity.Futbolista;
import com.app.backendfutbolistas.service.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/futbolista")
@CrossOrigin("*")
public class FutbolistaController {
    @Autowired
    private FutbolistaService futbolistaService;

    @GetMapping
    public Page<Futbolista> getAllFutbolistas(Pageable pageable) {
        return futbolistaService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Futbolista> getFutbolistaById(@PathVariable Long id) {
        return futbolistaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
