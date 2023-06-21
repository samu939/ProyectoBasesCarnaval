package com.Pruebas.Pruebas.Modelo;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

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
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "ssa_rol_presentacion")
public class RolPresentacion {
    @Id
    private int id_calendario;
    @Id
    private Date ano_carnaval;
    @Id
    private int id_escuela_samba;
    @Id
    private Date fechai_historico_grupo; 
    @Id
    private int id_participante;
    @Column(columnDefinition = "Varchar(20) not null constraint check_rol check (rol in('porta-bandeira','carnavalesco','reina percusionista','maestre-sala'))",nullable = false, length = 20)
    private String rol;

    @ManyToOne(targetEntity = Presentacion.class,fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name="id_escuela_samba", referencedColumnName="id_escuela_samba"),
                  @JoinColumn(name="fechai_historico_grupo", referencedColumnName="fechai_historico_grupo"),
                  @JoinColumn(name="id_calendario", referencedColumnName="id_calendario"),
                  @JoinColumn(name="ano_carnaval", referencedColumnName="ano_carnaval")})
    private Presentacion presentacion;

    @ManyToOne(targetEntity = Participante.class,fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name="id_participante", referencedColumnName="id")})
    private Participante participante;

}
