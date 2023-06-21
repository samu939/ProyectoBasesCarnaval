package com.Pruebas.Pruebas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Pruebas.Pruebas.Modelo.Presentacion;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.PresentacionPK;

public interface PresentacionRepository extends JpaRepository<Presentacion,PresentacionPK> {
    
}
