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
@Table(name = "SSA_tipo_entrada")
@SequenceGenerator(
    name="ssa_id_tipo_entrada",
    sequenceName = "ssa_id_tipo_entrada",
    initialValue = 1, 
    allocationSize = 1
)
public class TipoEntrada {
    @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssa_id_tipo_entrada")
    private int id;
    @Column(name="tipo",length = 2,columnDefinition = "varchar(2) not null constraint check_tipo check(tipo in ('GP','GF','AN','SL'))",nullable = false)
    private String tipo;
    @Column(name="sector",columnDefinition = "numeric(2) not null constraint check_sector check(sector in (2,3,4,5,6,7,9,11))",nullable = false)
    private int sector;
    @Column(name = "calidad",columnDefinition = "numeric(1) not null constraint check_calidad check(calidad>0 and calidad<9)",nullable = false)
    private int calidad;
    @Column(name = "tipo_desfile",length = 8,columnDefinition = "varchar(8) not null constraint check_tipo_desfile check(tipo_desfile in ('acceso','especial','campeon'))",nullable = false)
    private String tipo_desfile;
    @Column(name = "ubicacion",length = 3,columnDefinition = "varchar(3) constraint check_ubicacion check(ubicacion in ('A','B','C','A/B','C/D'))")
    private String ubicacion;
}
