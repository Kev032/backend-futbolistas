package com.app.backendfutbolistas.repository;

import com.app.backendfutbolistas.entity.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FutbolistaRepository extends JpaRepository<Futbolista, Long>, PagingAndSortingRepository<Futbolista, Long> {
}
