package com.Pruebas.Pruebas.Repositorios;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Pruebas.Pruebas.Modelo.Calendario;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CalendarioPK;



public interface CalendarioRepostory  extends JpaRepository<Calendario,CalendarioPK>{
    
    @Query(value="SELECT * FROM ssa_calendario order by fecha asc", nativeQuery = true)
    List<Calendario> OrderByFecha();

    List<Calendario> findByNombreContainingIgnoreCase(String cadena);
}
