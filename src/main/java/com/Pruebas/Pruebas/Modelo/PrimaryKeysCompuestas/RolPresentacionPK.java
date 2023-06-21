package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import com.Pruebas.Pruebas.Modelo.EscuelaSamba;
import com.Pruebas.Pruebas.Modelo.Participante;
import com.Pruebas.Pruebas.Modelo.Presentacion;

public class RolPresentacionPK {
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((presentacion == null) ? 0 : presentacion.hashCode());
        result = prime * result + ((participante == null) ? 0 : participante.hashCode());
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
        RolPresentacionPK other = (RolPresentacionPK) obj;
        if (presentacion == null) {
            if (other.presentacion != null)
                return false;
        } else if (!presentacion.equals(other.presentacion))
            return false;
        if (participante == null) {
            if (other.participante != null)
                return false;
        } else if (!participante.equals(other.participante))
            return false;
        return true;
    }
    public RolPresentacionPK() {
    }
    private Presentacion presentacion;
    private Participante participante;
    public Presentacion getPresentacion() {
        return presentacion;
    }
    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }
    public Participante getParticipante() {
        return participante;
    }
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
   
}
