package com.Pruebas.Pruebas.Repositorios;

import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.HistoricoGrupo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class HistoricoGrupoInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void insertHistoricoNuevo(HistoricoGrupo historicoNuevo, String grupo){
        entityManager.createNativeQuery("INSERT INTO ssa_hist_grupo(fechai, id_escuela_samba, fechaf, grupo)VALUES(cast(? as date) + cast('1 day' as interval), ?, null, ?)")
        .setParameter(1, historicoNuevo.getFechaf())
        .setParameter(2, historicoNuevo.getId_escuela_samba())
        .setParameter(3, grupo)
        .executeUpdate();
    }
}
