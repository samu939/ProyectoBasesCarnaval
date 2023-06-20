package com.Pruebas.Pruebas.Modelo;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "SSA_lugar_evento")
public class LugarEvento {
    @Id
    private int id;
    @Column(name="nombre_lugar",length = 60,nullable = false)
    private String nombre;
    @Column(name="descripcion",length=100,nullable = false)
    private String descripcion;
    @OneToMany(mappedBy = "id_lugar_evento")
    private List<Calendario> Calendario;
}
