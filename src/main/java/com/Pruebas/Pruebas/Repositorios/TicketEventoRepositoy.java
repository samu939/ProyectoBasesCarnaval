package com.Pruebas.Pruebas.Repositorios;


import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.TicketEventoPK;
import com.Pruebas.Pruebas.Modelo.TicketEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketEventoRepositoy extends JpaRepository<TicketEvento, TicketEventoPK> {

}
