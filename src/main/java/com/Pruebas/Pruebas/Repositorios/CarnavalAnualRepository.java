package com.Pruebas.Pruebas.Repositorios;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pruebas.Pruebas.Modelo.CarnavalAnual;

public interface CarnavalAnualRepository extends JpaRepository<CarnavalAnual, LocalDate> {

}
