package com.Pruebas.Pruebas.Modelo;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.TicketEventoPK;

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
@Table(name = "ssa_ticket_evento")
@SequenceGenerator(name = "ssa_id_ticket_evento", sequenceName = "ssa_id_ticket_evento", initialValue = 1, allocationSize = 1)
@IdClass(TicketEventoPK.class)
public class TicketEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssa_id_ticket_evento")
    private int id;
    @Id
    @ManyToOne(targetEntity = Calendario.class, fetch = FetchType.EAGER)
    @JoinColumns({ @JoinColumn(name = "id_calendario", referencedColumnName = "id"),
            @JoinColumn(name = "ano_carnaval", referencedColumnName = "ano_carnaval") })
    private Calendario calendario;

    @Column(length = 100, nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Date fecha_emision;
    @Column(nullable = false)
    private Time hora_emision;
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal costo;

}
