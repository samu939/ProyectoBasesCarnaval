package com.Pruebas.Pruebas.Modelo;
import lombok.Data;
import lombok.Getter;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.HistoricoGrupoPK;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "ssa_hist_grupo")
@IdClass(HistoricoGrupoPK.class)
public class HistoricoGrupo {
    @Id
    private Date fechai;
    @Id
    private int id_escuela_samba;

    @Column(columnDefinition = "VarChar(15) not null constraint check_grupo check (grupo in('acceso','especial'))",nullable = false,length = 15) 
    private String grupo;
    @Column(nullable = false)
    private Date fechaf;

    @MapsId("id_escuela_samba")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_escuela_samba")
    private EscuelaSamba escuela_samba;
}
