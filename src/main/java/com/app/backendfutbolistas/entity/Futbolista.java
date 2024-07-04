package com.app.backendfutbolistas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Futbolista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String caracteristicas;

    @ManyToOne
    @JoinColumn(name = "posicion_id")
    private Posicion posicion;

}
