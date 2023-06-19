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
@Table(name = "ssa_cliente")
public class Cliente {
    @Id
    private int id;
    @Column(name="pnombre",length = 20,nullable = false)
    private String pnombre;
    @Column(name="papellido",length = 20,nullable = false)
    private String papellido;
    @Column(name="sapellido",length = 20,nullable = false)
    private String sapellido;
    @Column(name="fecha_naci",length = 20,nullable = false)
    private Date fecha_naci;
    @Column(name="docidentidad",nullable = false)
    private long docidentidad;
    @Column(name = "email",length = 40,nullable = false)
    private String email;
    @Column(name = "snombre",length = 20)
    private String snombre;
}
