package com.Pruebas.Pruebas.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.DetalleReservacion;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.DetalleReservacionPK;


@Repository
public interface DetalleReservacionRepositry extends JpaRepository<DetalleReservacion,DetalleReservacionPK>{
    @Query(value = "select * from ssa_detalle_reservacion sdr where sdr.num_reservacion =:numero",nativeQuery = true)
    Optional<DetalleReservacion> findByNumero_reserva(@Param("numero")int numero);
}
