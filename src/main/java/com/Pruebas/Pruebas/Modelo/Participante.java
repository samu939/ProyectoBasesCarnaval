package com.Pruebas.Pruebas.Modelo;

import lombok.Data;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "ssa_participante")
@SequenceGenerator(
        name = "ssa_id_participante",
        sequenceName = "ssa_id_participante",
        initialValue = 1,
        allocationSize = 1
)
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssa_id_participante")
    private int id;
    @Column(length = 20, nullable = false)
    private String pnombre;
    @Column(length = 20, nullable = false)
    private String papellido;
    @Column(length = 20, nullable = false)
    private String sapellido;
    @Column(columnDefinition = "char not null constraint check_genero check(genero in('M','F'))", nullable = false)
    private char genero;
    @Column(unique = true, nullable = false)
    private long docidentidad;
    @Column(length = 20)
    private String snombre;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_escuela_samba", nullable = false)
    private EscuelaSamba id_escuela_samba;

    @OneToMany(mappedBy = "id_rey")
    private List<CarnavalAnual> carnavalRey;
    @OneToMany(mappedBy = "id_reina")
    private List<CarnavalAnual> carnavalReina;

}
