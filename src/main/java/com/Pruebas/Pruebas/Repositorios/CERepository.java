package com.Pruebas.Pruebas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.CE;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CEPK;

@Repository
public interface CERepository extends JpaRepository<CE,CEPK>{
    
}
