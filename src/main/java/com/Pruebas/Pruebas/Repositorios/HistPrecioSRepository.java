package com.Pruebas.Pruebas.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Pruebas.Pruebas.Modelo.HistoricoPrecioS;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.HistoricoPrecioSPK;

public interface HistPrecioSRepository extends JpaRepository<HistoricoPrecioS,HistoricoPrecioSPK>{

    @Query(value="select * from ssa_hist_precio_sambodromo shps where shps.id_tipo_entrada=:id_entrada and shps.fechaf is null",nativeQuery = true)
    Optional<HistoricoPrecioS>findByEntradaV(@Param("id_entrada") int id_entrada);
    
}
