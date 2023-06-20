package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import java.io.Serializable;
import java.sql.Date;

public class CalendarioPK implements Serializable {
    private Date ano_carnaval;
    private int id;
    public CalendarioPK(Date ano_carnaval, int id) {
        this.ano_carnaval = ano_carnaval;
        this.id = id;
    }
    public CalendarioPK() {
    }
    public Date getAno_carnaval() {
        return ano_carnaval;
    }
    public void setAno_carnaval(Date ano_carnaval) {
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
