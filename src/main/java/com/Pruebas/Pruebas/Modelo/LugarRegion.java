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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "SSA_lugar_region")
@SequenceGenerator(
    name="ssa_id_lugar_region",
    sequenceName = "ssa_id_lugar_region",
    initialValue = 1, 
    allocationSize = 1
)
public class LugarRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssa_id_lugar_region")
    private int id;
    @Column(name="nombre",length=20,nullable = false)
    private String nombre;
    @Column(name="descripcion", length=100,nullable = false)
    private String descripcion;
    @OneToMany(mappedBy = "id_lugar_region")
    private List<EscuelaSamba> EscuelaSamba; 

}
