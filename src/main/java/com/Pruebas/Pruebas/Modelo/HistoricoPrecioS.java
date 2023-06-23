package com.Pruebas.Pruebas.Modelo;

import java.time.LocalDate;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.HistoricoPrecioSPK;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ssa_hist_precio_sambodromo")
@IdClass(HistoricoPrecioSPK.class)
public class HistoricoPrecioS {
    @Id
    @ManyToOne(targetEntity = TipoEntrada.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_entrada", referencedColumnName = "id")
    private TipoEntrada id_tipo_entrada;
    @Id
    private LocalDate fechai;
    @Column(nullable = false)
    private double precio;
    private LocalDate fechaf;
}
