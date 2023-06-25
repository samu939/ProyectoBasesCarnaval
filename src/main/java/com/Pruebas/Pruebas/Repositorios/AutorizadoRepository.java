package com.Pruebas.Pruebas.Repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Pruebas.Pruebas.Modelo.Autorizado;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.AutorizadoPK;

public interface AutorizadoRepository  extends JpaRepository<Autorizado,AutorizadoPK>{
    
    @Query(value = "select sa.ano_carnaval,sa.existencia,sa.id_tipo_entrada,sa.id_empresa from ssa_autorizado sa where sa.id_tipo_entrada=:id_entrada and sa.id_empresa=:id_empresa and sa.ano_carnaval=:ano", nativeQuery = true)
    Optional<Autorizado> findByEntradaEmpresa(@Param("id_entrada") int id_entrada,@Param("id_empresa") int id_empresa,@Param("ano") LocalDate ano);

    @Query(value="select sa.ano_carnaval,sa.existencia,sa.id_tipo_entrada,sa.id_empresa from ssa_autorizado sa, ssa_tipo_entrada ste where sa.id_empresa=:id and sa.id_tipo_entrada=ste.id",nativeQuery = true)
    List<Autorizado> findAllEntradasDispoA(@Param("id") int id);

    
}
