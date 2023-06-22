package com.Pruebas.Pruebas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pruebas.Pruebas.Modelo.LugarEvento;

public interface LugarEventoRepository extends JpaRepository<LugarEvento,Integer>{
    
}
