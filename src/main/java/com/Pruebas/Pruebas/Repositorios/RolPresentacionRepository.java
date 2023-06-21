package com.Pruebas.Pruebas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pruebas.Pruebas.Modelo.RolPresentacion;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.RolPresentacionPK;

public interface RolPresentacionRepository extends JpaRepository<RolPresentacion,RolPresentacionPK>{
    
}
