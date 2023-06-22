package com.Pruebas.Pruebas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pruebas.Pruebas.Modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    
}
