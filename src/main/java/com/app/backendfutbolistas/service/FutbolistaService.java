package com.app.backendfutbolistas.service;

import com.app.backendfutbolistas.entity.Futbolista;
import com.app.backendfutbolistas.repository.FutbolistaRepository;
import com.app.backendfutbolistas.util.ResourceNotFoundException;
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

    public Futbolista updateFutbolista(Long id, Futbolista futbolistaDetails) {
        Optional<Futbolista> optionalFutbolista = futbolistaRepository.findById(id);
        if (optionalFutbolista.isPresent()) {
            Futbolista existingFutbolista = optionalFutbolista.get();
            existingFutbolista.setNombres(futbolistaDetails.getNombres());
            existingFutbolista.setApellidos(futbolistaDetails.getApellidos());
            existingFutbolista.setFechaNacimiento(futbolistaDetails.getFechaNacimiento());
            existingFutbolista.setCaracteristicas(futbolistaDetails.getCaracteristicas());
            existingFutbolista.setPosicion(futbolistaDetails.getPosicion());
            return futbolistaRepository.save(existingFutbolista);
        } else {
            throw new ResourceNotFoundException("Futbolista not found with id " + id);
        }
    }
}
