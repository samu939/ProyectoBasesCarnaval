package com.Pruebas.Pruebas.Modelo;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.DetalleReservacionPK;

import jakarta.persistence.Column;
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
    @ManyToOne(targetEntity = Autorizado.class, fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name = "ano_carnaval", referencedColumnName= "ano_carnaval"),
                @JoinColumn(name="id_empresa_autorizado", referencedColumnName="id_empresa"),
                @JoinColumn(name="id_tipo_entrada", referencedColumnName = "id_tipoEntrada")})
    private Autorizado autorizado;
    @Id
    @ManyToOne(targetEntity = Reservacion.class, fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name = "id_empresa_reservacion", referencedColumnName = "id_empresa"),
                @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente"),
                @JoinColumn(name = "num_reservacion", referencedColumnName = "numero")})
    private Reservacion reservacion;
    @Column(nullable = false)
    private int cantidad;

}