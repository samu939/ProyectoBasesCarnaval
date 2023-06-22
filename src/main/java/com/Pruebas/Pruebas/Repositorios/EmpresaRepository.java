package com.Pruebas.Pruebas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pruebas.Pruebas.Modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa,Integer>{
    
}
