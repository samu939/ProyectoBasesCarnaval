package com.Pruebas.Pruebas.Repositorios;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Pruebas.Pruebas.Modelo.CarnavalAnual;

public interface CarnavalAnualRepository extends JpaRepository<CarnavalAnual, LocalDate> {

    @Query(value = "select * from ssa_carnaval_anual c order by c.ano asc",nativeQuery = true)
    List<CarnavalAnual> findAllOrderByAno();
}
