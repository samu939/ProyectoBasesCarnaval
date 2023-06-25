package com.Pruebas.Pruebas.Repositorios;


import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.TicketEventoPK;
import com.Pruebas.Pruebas.Modelo.TicketEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketEventoRepositoy extends JpaRepository<TicketEvento, TicketEventoPK> {
    @Query(value = "SELECT * from SSA_ticket_evento st order by st.id", nativeQuery = true)
    List<TicketEvento> OrderById();
}
