package com.Pruebas.Pruebas.Repositorios;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Pruebas.Pruebas.Modelo.Presentacion;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.PresentacionPK;

public interface PresentacionRepository extends JpaRepository<Presentacion,PresentacionPK> {
    
    @Query(value="select sp.fechai_historico_grupo,sp.id_escuela_samba,sp.id_calendario,sp.ano_carnaval,sp.hora_inicio_escuela,sp.orden_desfile,sp.resultado,sp.tema_general,sp.titulo_letra_cancion from ssa_Presentacion sp,ssa_hist_grupo shg  where sp.ano_carnaval =:ano and (shg.fechai= sp.fechai_historico_grupo and shg.id_escuela_samba=sp.id_escuela_samba and shg.grupo=:grupo and shg.fechaf isnull) order by resultado asc; ", nativeQuery=true)
    List<Presentacion> findAllByAno_Carnaval(@Param("ano")LocalDate ano,@Param("grupo")String grupo);
}
