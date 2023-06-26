package com.Pruebas.Pruebas.Repositorios;

import java.util.List;
import java.util.Optional;

import lombok.val;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Pruebas.Pruebas.Modelo.HistoricoPrecioS;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.HistoricoPrecioSPK;

public interface HistPrecioSRepository extends JpaRepository<HistoricoPrecioS,HistoricoPrecioSPK>{

    @Query(value="select * from ssa_hist_precio_sambodromo shps where shps.id_tipo_entrada=:id_entrada and shps.fechaf is null",nativeQuery = true)
    Optional<HistoricoPrecioS>findByEntradaV(@Param("id_entrada") int id_entrada);

    @Query(value = "select * from ssa_hist_precio_sambodromo sh where sh.id_tipo_entrada=:id and sh.fechaf is null ", nativeQuery = true)
    Optional<HistoricoPrecioS> findAllByIdFechaActivo(@Param("id") int id);
    
}
