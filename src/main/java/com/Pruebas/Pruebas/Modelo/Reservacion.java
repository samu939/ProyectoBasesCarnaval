package com.Pruebas.Pruebas.Modelo;

import java.sql.Date;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.ReservacionPK;

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
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name="ssa_reservacion")
@SequenceGenerator(
    name="ssa_numero_reservacion",
    sequenceName="ssa_numero_reservacion",
    initialValue = 1,
    allocationSize = 1
)
@IdClass(ReservacionPK.class)
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssa_numero_reservacion")
    private int numero;
    @Id
    @ManyToOne(targetEntity = Empresa.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private Empresa id_empresa;
    @Id
    @ManyToOne(targetEntity = Cliente.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente id_cliente;
    @Column(nullable = false)
    private Date fecha_hora_emision;
    @Column(name="total a pagar")
    private double total;
    @Column(name="fecha cancelado")
    private Date fechac;

}
