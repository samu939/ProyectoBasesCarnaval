package com.Pruebas.Pruebas.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Pruebas.Pruebas.Modelo.HistoricoGrupo;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.HistoricoGrupoPK;


@Repository
public interface HistoricoGrupoRepository extends JpaRepository<HistoricoGrupo,HistoricoGrupoPK>{
    
}
