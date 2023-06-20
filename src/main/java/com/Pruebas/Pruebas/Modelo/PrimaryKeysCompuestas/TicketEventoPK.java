package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import java.io.Serializable;
import java.sql.Date;

public class TicketEventoPK implements Serializable{
    private int id_calendario;
    private int id;
    private Date ano_carnaval;
    public TicketEventoPK() {
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_calendario;
        result = prime * result + id;
        result = prime * result + ((ano_carnaval == null) ? 0 : ano_carnaval.hashCode());
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
        TicketEventoPK other = (TicketEventoPK) obj;
        if (id_calendario != other.id_calendario)
            return false;
        if (id != other.id)
            return false;
        if (ano_carnaval == null) {
            if (other.ano_carnaval != null)
                return false;
        } else if (!ano_carnaval.equals(other.ano_carnaval))
            return false;
        return true;
    }
    
    public int getId_calendario() {
        return id_calendario;
    }
    public void setId_calendario(int id_calendario) {
        this.id_calendario = id_calendario;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getAno_carnaval() {
        return ano_carnaval;
    }
    public void setAno_carnaval(Date ano_carnaval) {
        this.ano_carnaval = ano_carnaval;
    }
}
