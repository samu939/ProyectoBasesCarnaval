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
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "SSA_tipo_entrada")
public class TipoEntrada {
    @Id
    private int id;
    @Column(name="tipo",length = 2,nullable = false)
    private String tipo;
    @Column(name="sector",nullable = false)
    private int sector;
    @Column(name = "calidad",nullable = false)
    private int calidad;
    @Column(name = "tipo_desfile",length = 8,nullable = false)
    private String tipo_desfile;
    @Column(name = "ubicacion",length = 3)
    private String ubicacion;
}
