package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import java.time.LocalDate;

public class HistoricoPrecioSPK {

    private int id_tipo_entrada;
    private LocalDate fechai;

    public HistoricoPrecioSPK() {
    }

    public HistoricoPrecioSPK(int id_tipo_entrada, LocalDate fechai) {
        this.id_tipo_entrada = id_tipo_entrada;
        this.fechai = fechai;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_tipo_entrada;
        result = prime * result + ((fechai == null) ? 0 : fechai.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HistoricoPrecioSPK other = (HistoricoPrecioSPK) obj;
        if (id_tipo_entrada != other.id_tipo_entrada)
            return false;
        if (fechai == null) {
            if (other.fechai != null)
                return false;
        } else if (!fechai.equals(other.fechai))
            return false;
        return true;
    }

    public int getId_tipo_entrada() {
        return id_tipo_entrada;
    }

    public void setId_tipo_entrada(int id_tipo_entrada) {
        this.id_tipo_entrada = id_tipo_entrada;
    }

    public LocalDate getFechai() {
        return fechai;
    }

    public void setFechai(LocalDate fechai) {
        this.fechai = fechai;
    }


}
