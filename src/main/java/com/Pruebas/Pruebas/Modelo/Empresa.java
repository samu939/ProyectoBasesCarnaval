package com.Pruebas.Pruebas.Modelo;

import lombok.Data;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "SSA_empresa")
@SequenceGenerator(
        name = "ssa_id_empresa",
        sequenceName = "ssa_id_empresa",
        initialValue = 1,
        allocationSize = 1
)
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssa_id_empresa")
    private int id;
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;
    @Column(name = "email", length = 40, nullable = false)
    private String email;
}
