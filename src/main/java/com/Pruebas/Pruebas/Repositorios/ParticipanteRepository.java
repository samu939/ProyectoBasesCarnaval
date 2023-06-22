package com.Pruebas.Pruebas.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.Participante;


@Repository
public interface ParticipanteRepository extends JpaRepository<Participante,Integer>{
    List<Participante> findAllByGenero(char genero);
}
