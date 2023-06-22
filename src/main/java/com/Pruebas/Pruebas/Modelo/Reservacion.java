package com.Pruebas.Pruebas.Modelo;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.ReservacionPK;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name="ssa_reservacion")
@IdClass(ReservacionPK.class)
public class Reservacion {
    @Id
    @ManyToOne(targetEntity = Empresa.class,fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")})
    private Empresa empresa;
    @Id
    @ManyToOne(targetEntity = Cliente.class,fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")})
    private Cliente cliente;
    

}
