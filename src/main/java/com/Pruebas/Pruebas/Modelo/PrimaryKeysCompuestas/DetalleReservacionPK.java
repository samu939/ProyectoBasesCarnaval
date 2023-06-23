package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import com.Pruebas.Pruebas.Modelo.Autorizado;
import com.Pruebas.Pruebas.Modelo.Reservacion;

public class DetalleReservacionPK {
    private Autorizado autorizado;
    private Reservacion reservacion;
    
    public DetalleReservacionPK(Autorizado autorizado, Reservacion reservacion) {
        this.autorizado = autorizado;
        this.reservacion = reservacion;
    }

    public DetalleReservacionPK() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((autorizado == null) ? 0 : autorizado.hashCode());
        result = prime * result + ((reservacion == null) ? 0 : reservacion.hashCode());
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
        DetalleReservacionPK other = (DetalleReservacionPK) obj;
        if (autorizado == null) {
            if (other.autorizado != null)
                return false;
        } else if (!autorizado.equals(other.autorizado))
            return false;
        if (reservacion == null) {
            if (other.reservacion != null)
                return false;
        } else if (!reservacion.equals(other.reservacion))
            return false;
        return true;
    }

    public Autorizado getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Autorizado autorizado) {
        this.autorizado = autorizado;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;}
}