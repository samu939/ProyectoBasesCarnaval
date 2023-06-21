package com.Pruebas.Pruebas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pruebas.Pruebas.Modelo.Calendario;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CalendarioPK;


public interface CalendarioRepostory  extends JpaRepository<Calendario,CalendarioPK>{
    
}
