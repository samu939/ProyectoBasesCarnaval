package com.Pruebas.Pruebas.Repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Pruebas.Pruebas.Modelo.EscuelaSamba;

import jakarta.websocket.server.PathParam;

public interface EscuelaSambaRepository extends JpaRepository<EscuelaSamba, Integer> {

    @Query(value = "select * from ssa_escuela_samba ses where not exists (select * from ssa_presentacion sp where sp.id_escuela_samba=ses.id and sp.ano_carnaval=:ano)",nativeQuery = true)
    List<EscuelaSamba> findDontHavePresentationInYear(@PathParam("ano") LocalDate ano);
}
