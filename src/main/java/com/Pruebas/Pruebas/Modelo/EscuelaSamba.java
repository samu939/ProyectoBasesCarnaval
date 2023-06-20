package com.Pruebas.Pruebas.Modelo;
import lombok.Data;
import lombok.Getter;

import java.math.BigInteger;
import java.sql.Date;
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
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "ssa_escuela_samba")
public class EscuelaSamba {
    @Id
    private int id;
    @Column(name="fecha_funda",nullable = false)
    private Date fecha_funda;
    @Column(name="nombre",length = 50,nullable = false)
    private String nombre;
    @Column(name = "direccion",length = 100,nullable = false)
    private String direccion;
    @Column(name = "resumen",length = 500,nullable = false)
    private String resumen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lugar_region", nullable = false)
    private LugarRegion id_lugar_region;

    @OneToMany(mappedBy = "id_escuela_samba")
    private List<Participante> participante; 

    @OneToMany(mappedBy = "id_escuela_samba")
    private List<HistoricoGrupo> historicoGrupos; 
     

}
