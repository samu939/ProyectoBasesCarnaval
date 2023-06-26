package com.Pruebas.Pruebas.Repositorios;

import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.DetalleReservacion;
import com.Pruebas.Pruebas.Modelo.HistoricoGrupo;
import com.Pruebas.Pruebas.Modelo.TicketEvento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class detalleReservacionInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserDetalleNuevo(DetalleReservacion detalle) {
        entityManager.createNativeQuery("INSERT INTO ssa_detalle_reservacion(id_tipo_entrada, id_empresa_autorizado, ano_carnaval, num_reservacion, id_empresa_reserva, id_cliente, cantidad) VALUES(?, ?, ?, ?, ?, ?, ?)")
                .setParameter(1, detalle.getAutorizado().getTipoEntrada().getId())
                .setParameter(2, detalle.getAutorizado().getEmpresa().getId())
                .setParameter(3, detalle.getAutorizado().getAno_carnaval().getAno())
                .setParameter(4, detalle.getReservacion().getNumero())
                .setParameter(5, detalle.getReservacion().getId_empresa().getId())
                .setParameter(6, detalle.getReservacion().getId_cliente().getId())
                .setParameter(7, detalle.getCantidad())
                .executeUpdate();
    }
}
