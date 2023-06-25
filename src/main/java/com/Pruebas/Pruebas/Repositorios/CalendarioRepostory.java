package com.Pruebas.Pruebas.Repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Pruebas.Pruebas.Modelo.Calendario;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CalendarioPK;


public interface CalendarioRepostory extends JpaRepository<Calendario, CalendarioPK> {

    @Query(value = "SELECT * FROM ssa_calendario order by fecha asc", nativeQuery = true)
    List<Calendario> OrderByFecha();

    @Query(value = "select * from ssa_calendario sc where sc.ano_carnaval=:ano and sc.tipo='general' and sc.pago='Si' order by sc.fecha asc", nativeQuery = true)
    List<Calendario> findAllByAno_Carnaval(@Param("ano") LocalDate ano);

    List<Calendario> findByNombreContainingIgnoreCase(String cadena);

    @Query(value = "select * from ssa_calendario sc where sc.ano_carnaval=:ano and sc.tipo='desfile' and upper(sc.nombre) like upper('%'||:grupo||'%')", nativeQuery = true)
    List<Calendario> findAllDesfilesByYearAndName(@Param("ano") LocalDate ano, @Param("grupo") String grupo);

    @Query(value = "select * from ssa_calendario sc where sc.tipo='desfile' and (upper(sc.nombre) like '%'||'ESPECIAL'||'%' ) and sc.ano_carnaval=:ano", nativeQuery = true)
    List<Calendario> findAllDesfilesEspecialByYear(@Param("ano") LocalDate ano);

    @Query(value = "select * from ssa_calendario sc where sc.tipo='desfile' and (upper(sc.nombre) like '%'||'ACCESO'||'%' ) and sc.ano_carnaval=:ano", nativeQuery = true)
    Optional<Calendario> findDesfileAccesoByYear(@Param("ano") LocalDate ano);

    @Query(value = "SELECT * FROM ssa_calendario where id=:id", nativeQuery = true)
    Optional<Calendario> findByIdOnly(@Param("id") int id);
}
