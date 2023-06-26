package com.Pruebas.Pruebas.Repositorios;

import com.Pruebas.Pruebas.Modelo.HistoricoPrecioS;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class HistPrecioSInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertHistoricoNuevo(HistoricoPrecioS historicoPrecioS){
        entityManager.createNativeQuery("INSERT INTO ssa_hist_precio_sambodromo(id_tipo_entrada, fechai, precio, fechaf) values (?,?,?,?)")
                .setParameter(1,historicoPrecioS.getId_tipo_entrada().getId())
                .setParameter(2,historicoPrecioS.getFechai())
                .setParameter(3,historicoPrecioS.getPrecio())
                .setParameter(4,historicoPrecioS.getFechaf())
                .executeUpdate();
    }
}
