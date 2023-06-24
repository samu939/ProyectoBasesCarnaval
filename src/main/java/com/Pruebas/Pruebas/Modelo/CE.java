package com.Pruebas.Pruebas.Modelo;

import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CEPK;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ssa_c_e")
@IdClass(CEPK.class)
public class CE {
    @Id
    @ManyToOne(targetEntity = Color.class,fetch = FetchType.EAGER)
    @JoinColumn(name="id_color",referencedColumnName = "id")
    private Color id_color;
    @Id
    @ManyToOne(targetEntity = EscuelaSamba.class,fetch = FetchType.EAGER)
    @JoinColumn(name="id_escuela_samba",referencedColumnName = "id")
    private EscuelaSamba id_escuelaSamba;
}
