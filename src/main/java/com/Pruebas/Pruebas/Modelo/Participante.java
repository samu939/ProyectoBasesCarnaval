package com.Pruebas.Pruebas.Modelo;
import lombok.Data;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "ssa_participante")
@SequenceGenerator(
    name="ssa_id_participante",
    sequenceName = "ssa_id_participante",
    initialValue = 1, 
    allocationSize = 1
)
public class Participante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssa_id_participante")
    private int id;
    @Column(length = 20,nullable = false)
    private String pNombre;
    @Column(length = 20,nullable = false)
    private String pApellido;
    @Column(length = 20,nullable = false)
    private String sApellido;
    @Column(columnDefinition = "char not null constraint check_genero check(genero in('M','F'))",nullable = false) 
    private char genero;   
    @Column(unique = true,nullable = false)
    private long docIdentidad;
    @Column(length = 20)
    private String sNombre;
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private EscuelaSamba id_escuela_samba;
    


}
