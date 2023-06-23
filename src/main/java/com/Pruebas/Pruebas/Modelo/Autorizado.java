package com.Pruebas.Pruebas.Modelo;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.AutorizadoPK;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SSA_autorizado")
@IdClass(AutorizadoPK.class)
public class Autorizado {
    @Id
    @ManyToOne(targetEntity = TipoEntrada.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipoEntrada", referencedColumnName = "id")
    private TipoEntrada tipoEntrada;
    @Id
    @ManyToOne(targetEntity = Empresa.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    private Empresa empresa;
    @Id
    @ManyToOne(targetEntity = CarnavalAnual.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "ano_carnaval", referencedColumnName = "ano")
    private CarnavalAnual ano_carnaval;
    @Column(nullable = false)
    private int existencia;

}
