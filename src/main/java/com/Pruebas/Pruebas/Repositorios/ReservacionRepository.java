package com.Pruebas.Pruebas.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.Reservacion;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.ReservacionPK;

@Repository
public interface ReservacionRepository extends JpaRepository<Reservacion, ReservacionPK> {

    @Query(value = "select * from ssa_reservacion sr where sr.numero = (select max(sr2.numero) from ssa_reservacion sr2)",nativeQuery = true)
    Optional<Reservacion> findLastByNumber();
}
