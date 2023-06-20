package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import java.io.Serializable;
import java.sql.Date;

public class HistoricoGrupoPK implements Serializable{
    private Date fechai;
    private int id_escuela_samba;
    
    public HistoricoGrupoPK() {
    }

    public HistoricoGrupoPK(Date fechai, int id_escuela_samba) {
        this.fechai = fechai;
        this.id_escuela_samba = id_escuela_samba;
    }
    
    public Date getFechai() {
        return fechai;
    }
    public void setFechai(Date fechai) {
        this.fechai = fechai;
    }
    
    public int getId_escuela_samba() {
        return id_escuela_samba;
    }
    public void setId_escuela_samba(int id_escuela_samba) {
        this.id_escuela_samba = id_escuela_samba;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fechai == null) ? 0 : fechai.hashCode());
        result = prime * result + id_escuela_samba;
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
        HistoricoGrupoPK other = (HistoricoGrupoPK) obj;
        if (fechai == null) {
            if (other.fechai != null)
                return false;
        } else if (!fechai.equals(other.fechai))
            return false;
        if (id_escuela_samba != other.id_escuela_samba)
            return false;
        return true;
    }

}
