package com.Pruebas.Pruebas.Viejo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto,Integer>{

    List<Contacto> findByNombreContaining(String cadena);

    @Query(value="SELECT * FROM contacto order by id asc", nativeQuery = true)
    List<Contacto> OrderById();

    Contacto findByNombre(String nombre);
}
