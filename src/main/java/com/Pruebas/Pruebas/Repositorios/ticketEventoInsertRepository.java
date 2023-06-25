package com.Pruebas.Pruebas.Repositorios;

import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.HistoricoGrupo;
import com.Pruebas.Pruebas.Modelo.TicketEvento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ticketEventoInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserTicketEventoNuevoNuevo(TicketEvento ticket) {
        entityManager.createNativeQuery("INSERT INTO ssa_ticket_evento(id_calendario, ano_carnaval, descripcion, fecha_emision, hora_emision, costo)VALUES(?, ?, ?, ?, ?, ?)")
                .setParameter(1, ticket.getCalendario().getId())
                .setParameter(2, ticket.getCalendario().getAno_carnaval().getAno())
                .setParameter(3, ticket.getDescripcion())
                .setParameter(4, ticket.getFecha_emision())
                .setParameter(5, ticket.getHora_emision())
                .setParameter(6, ticket.getCosto())
                .executeUpdate();
    }
}
