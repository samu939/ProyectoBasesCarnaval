package com.Pruebas.Pruebas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.Reservacion;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.ReservacionPK;

@Repository
public interface ReservacionRepository extends JpaRepository<Reservacion, ReservacionPK> {

}
