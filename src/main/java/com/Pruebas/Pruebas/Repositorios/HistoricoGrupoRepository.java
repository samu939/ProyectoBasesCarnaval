package com.Pruebas.Pruebas.Repositorios;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.HistoricoGrupo;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.HistoricoGrupoPK;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;


@Repository
public interface HistoricoGrupoRepository extends JpaRepository<HistoricoGrupo, HistoricoGrupoPK> {

    @Query(value = "select * from ssa_hist_grupo shg where shg.id_escuela_samba =:id and shg.fechaf is null and shg.fechai<:ano", nativeQuery = true)
    Optional<HistoricoGrupo> findActiveById(@Param("id") int id,@Param("ano")LocalDate ano);

    @Query(value = "select * from ssa_hist_grupo shg where shg.id_escuela_samba =:id and shg.fechaf is null", nativeQuery = true)
    Optional<HistoricoGrupo> findActiveByIdOnly(@Param("id") int id);


}
