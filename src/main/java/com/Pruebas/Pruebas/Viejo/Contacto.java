package com.Pruebas.Pruebas.Viejo;


import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


@Data
@Entity
@Table(name = "Contacto")
public class Contacto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre", unique=true, length=150)
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;
    
    

    @PrePersist
    private void asignarFechaRegistro(){
        fechaRegistro= LocalDate.now();
    }

}
