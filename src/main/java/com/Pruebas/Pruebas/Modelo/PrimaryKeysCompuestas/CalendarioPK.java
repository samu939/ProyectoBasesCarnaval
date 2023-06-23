package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import java.io.Serializable;
import java.sql.Date;

import com.Pruebas.Pruebas.Modelo.CarnavalAnual;

public class CalendarioPK implements Serializable {
    private CarnavalAnual ano_carnaval;
    private int id;

    public CalendarioPK() {
    }

    public CarnavalAnual getAno_carnaval() {
        return ano_carnaval;
    }

    public void setAno_carnaval(CarnavalAnual ano_carnaval) {
        this.ano_carnaval = ano_carnaval;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ano_carnaval == null) ? 0 : ano_carnaval.hashCode());
        result = prime * result + id;
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
        CalendarioPK other = (CalendarioPK) obj;
        if (ano_carnaval == null) {
            if (other.ano_carnaval != null)
                return false;
        } else if (!ano_carnaval.equals(other.ano_carnaval))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

}
