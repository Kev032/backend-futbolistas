package com.app.backendfutbolistas.service;

import com.app.backendfutbolistas.entity.Futbolista;
import com.app.backendfutbolistas.repository.FutbolistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FutbolistaService {
    @Autowired
    private FutbolistaRepository futbolistaRepository;

    public Page<Futbolista> findAll(Pageable pageable) {
        return futbolistaRepository.findAll(pageable);
    }

    public Optional<Futbolista> findById(Long id) {
        return futbolistaRepository.findById(id);
    }
}
