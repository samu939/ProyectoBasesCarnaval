package com.Pruebas.Pruebas.Modelo;

import lombok.Data;
import lombok.Getter;
import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "SSA_lugar_region")
public class LugarRegion {
    @Id
    private int id;
    @Column(name="nombre",length=20,nullable = false)
    private String nombre;
    @Column(name="descripcion", length=100,nullable = false)
    private String descripcion;


}
