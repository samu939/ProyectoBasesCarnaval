package com.Pruebas.Pruebas.Repositorios;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Pruebas.Pruebas.Modelo.Presentacion;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.PresentacionPK;

public interface PresentacionRepository extends JpaRepository<Presentacion, PresentacionPK> {

    @Query(value = "select sp.fechai_historico_grupo,sp.id_escuela_samba,sp.id_calendario,sp.ano_carnaval,sp.hora_inicio_escuela,sp.orden_desfile,sp.resultado,sp.tema_general,sp.titulo_letra_cancion from ssa_Presentacion sp,ssa_hist_grupo shg  where sp.ano_carnaval =:ano and (shg.fechai= sp.fechai_historico_grupo and shg.id_escuela_samba=sp.id_escuela_samba and shg.grupo=:grupo) order by resultado asc; ", nativeQuery = true)
    List<Presentacion> findAllByAno_Carnaval(@Param("ano") LocalDate ano, @Param("grupo") String grupo);

    @Query(value = "select * from ssa_presentacion sp where sp.id_escuela_samba=:id and sp.ano_carnaval=:ano", nativeQuery = true)
    Optional<Presentacion> findSameYear(@Param("id") int id, @Param("ano") LocalDate ano);

    @Query(value = "select * from ssa_presentacion sp where sp.id_calendario=:id and sp.ano_carnaval=:ano and sp.orden_desfile=:orden", nativeQuery = true)
    Optional<Presentacion> findSameOrder(@Param("id") int id, @Param("ano") LocalDate ano, @Param("orden") int orden);

    @Query(value = "select * from ssa_presentacion sp where sp.ano_carnaval=:ano and (sp.id_calendario=(select sc.id from ssa_calendario sc where sc.tipo='desfile' and (upper(sc.nombre) like '%'||'ESPECIAL'||'%' and upper(sc.nombre) like '%'||'1'||'%') and sc.ano_carnaval=:ano) or sp.id_calendario=(select sc.id from ssa_calendario sc where sc.tipo='desfile' and (upper(sc.nombre) like '%'||'ESPECIAL'||'%' and upper(sc.nombre) like '%'||'2'||'%') and sc.ano_carnaval=:ano)) and sp.resultado=:pos", nativeQuery = true)
    Optional<Presentacion> findSamePosEspecial(@Param("ano") LocalDate ano, @Param("pos") int pos);

    @Query(value = "select * from ssa_presentacion sp where sp.ano_carnaval=:ano and (sp.id_calendario=(select sc.id from ssa_calendario sc where sc.tipo='desfile' and upper(sc.nombre) like '%'||'ACCESO'||'%' and sc.ano_carnaval=:ano)) and sp.resultado=:pos", nativeQuery = true)
    Optional<Presentacion> findSamePosAcceso(@Param("ano") LocalDate ano, @Param("pos") int pos);

    @Query(value = "select * from ssa_presentacion sp where sp.id_calendario=:id and sp.ano_carnaval=:ano and sp.hora_inicio_escuela=:hora", nativeQuery = true)
    Optional<Presentacion> findSameHour(@Param("id") int id, @Param("ano") LocalDate ano, @Param("hora") Time hora);
}
