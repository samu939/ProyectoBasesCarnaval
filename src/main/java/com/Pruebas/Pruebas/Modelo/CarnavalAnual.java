package com.Pruebas.Pruebas.Modelo;
import lombok.Data;
import lombok.Getter;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "ssa_carnaval_anual")
public class CarnavalAnual {
    @Id
    private Date ano;
    @Column(nullable = false)
    private Date fechai;
    @Column(nullable = false)
    private Date fechaf;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rey", nullable = false)
    private Participante id_rey;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reina", nullable = false)
    private Participante id_reina;
    @OneToMany(mappedBy = "ano_carnaval")
    private List<Calendario> Calendario;
}
