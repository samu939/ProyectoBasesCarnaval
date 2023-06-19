package com.Pruebas.Pruebas.Modelo;
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
@Table(name = "ssa_participante")
public class Participante {
    
    

}
