package com.Pruebas.Pruebas.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Pruebas.Pruebas.Modelo.Color;

import jakarta.websocket.server.PathParam;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    @Query(value = "select sc.id,sc.nombre from ssa_color sc, ssa_escuela_samba ses, ssa_c_e sce where sce.id_color=sc.id and sce.id_escuela_samba=ses.id and sce.id_escuela_samba=:id",nativeQuery = true)
    List<Color> findColoresByEscuelaId(@PathParam("id")int id);
}
