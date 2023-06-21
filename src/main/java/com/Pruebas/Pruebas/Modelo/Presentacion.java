package com.Pruebas.Pruebas.Modelo;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.PresentacionPK;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "ssa_presentacion")
@IdClass(PresentacionPK.class)
public class Presentacion {
    @Id
    @ManyToOne(targetEntity = HistoricoGrupo.class, fetch = FetchType.EAGER)
    @JoinColumns({ @JoinColumn(name = "id_escuela_samba", referencedColumnName = "id_escuela_samba"),
            @JoinColumn(name = "fechai_historico_grupo", referencedColumnName = "fechai") })
    private HistoricoGrupo historicoGrupo;
    @Id
    @ManyToOne(targetEntity = Calendario.class, fetch = FetchType.EAGER)
    @JoinColumns({ @JoinColumn(name = "id_calendario", referencedColumnName = "id"),
            @JoinColumn(name = "ano_carnaval", referencedColumnName = "ano_carnaval") })
    private Calendario calendario;
    @Column(nullable = false)
    private Time hora_inicio_escuela;
    @Column(columnDefinition = "int not null constraint check_orden check (orden_desfile>0 and orden_desfile<13)", nullable = false)
    private int orden_desfile;
    @Column(columnDefinition = "int not null constraint check_resultado check(resultado<13 and resultado>0)", nullable = false)
    private int resultado;
    @Column(length = 100)
    private String tema_general;
    @Column(length = 1500)
    private String titulo_letra_cancion;

}
