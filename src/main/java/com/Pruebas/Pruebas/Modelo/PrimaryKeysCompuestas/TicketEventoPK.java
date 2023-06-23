package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import com.Pruebas.Pruebas.Modelo.Calendario;

public class TicketEventoPK {
    private int id;
    private Calendario calendario;

    public TicketEventoPK(int id, Calendario calendario) {
        this.id = id;
        this.calendario = calendario;
    }

    public TicketEventoPK() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((calendario == null) ? 0 : calendario.hashCode());
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
        if (id != other.id)
            return false;
        if (calendario == null) {
            if (other.calendario != null)
                return false;
        } else if (!calendario.equals(other.calendario))
            return false;
        return true;
    }

}
