package com.Pruebas.Pruebas.Modelo;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.DetalleReservacionPK;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ssa_detalle_reservacion")
@IdClass(DetalleReservacionPK.class)
public class DetalleReservacion {
    @Id
    @ManyToOne(targetEntity = TipoEntrada.class, fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name = "ano_carnaval", referencedColumnName= "")})
    private Autorizado autorizado;

}