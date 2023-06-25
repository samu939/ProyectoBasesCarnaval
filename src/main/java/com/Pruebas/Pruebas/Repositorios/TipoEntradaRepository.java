package com.Pruebas.Pruebas.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.Pruebas.Pruebas.Modelo.TipoEntrada;

public interface TipoEntradaRepository extends JpaRepository<TipoEntrada, Integer> {
    @Query(value = "select ste.id,ste.calidad,ste.sector,ste.tipo,ste.tipo_desfile,ste.ubicacion from ssa_autorizado sa, ssa_tipo_entrada ste where sa.id_empresa=:id and sa.id_tipo_entrada=ste.id",nativeQuery = true)
    List<TipoEntrada> findAllEntradasDispo(@Param("id") int id);
}
