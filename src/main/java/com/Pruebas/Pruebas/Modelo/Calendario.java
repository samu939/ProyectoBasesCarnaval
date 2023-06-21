package com.Pruebas.Pruebas.Modelo;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CalendarioPK;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "ssa_calendario")
@SequenceGenerator(
    name="ssa_id_calendario",
    sequenceName = "ssa_id_calendario",
    initialValue = 1, 
    allocationSize = 1
)
@IdClass(CalendarioPK.class)
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssa_id_calendario")
    private int id;
    @Id
    @ManyToOne(targetEntity = CarnavalAnual.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "ano_carnaval",referencedColumnName = "ano")
    private CarnavalAnual ano_carnaval;

    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private Time horai;
    @Column(length = 60,nullable = false)
    private String nombre;
    @Column(length = 15, nullable = false, columnDefinition = "varchar(15) not null constraint check_tipoEv check(tipo in('desfile','general'))")
    private String tipo;
    @Column(length = 2, nullable = false, columnDefinition = "varchar(2) not null constraint check_tipoAud check(tipo_audiencia in('TP','ME'))")
    private String tipo_audiencia;
    @Column(length = 2, nullable = false,columnDefinition = "varchar(2) not null constraint check_pago check(pago in('Si','No'))")
    private String pago;
    @Column(length=300)
    private String descripcion;
    @Column(precision = 5, scale = 2)
    private BigDecimal costo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lugar_evento")
    private LugarEvento id_lugar_evento;

    


    
    
    
     
}
