package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;


public class CEPK {
    
    private int id_color;
    private int id_escuelaSamba;
    
    public CEPK() {
    }

    public CEPK(int id_color, int id_escuelaSamba) {
        this.id_color = id_color;
        this.id_escuelaSamba = id_escuelaSamba;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_color;
        result = prime * result + id_escuelaSamba;
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
        CEPK other = (CEPK) obj;
        if (id_color != other.id_color)
            return false;
        if (id_escuelaSamba != other.id_escuelaSamba)
            return false;
        return true;
    }

    public int getId_color() {
        return id_color;
    }

    public void setId_color(int id_color) {
        this.id_color = id_color;
    }

    public int getId_escuelaSamba() {
        return id_escuelaSamba;
    }

    public void setId_escuelaSamba(int id_escuelaSamba) {
        this.id_escuelaSamba = id_escuelaSamba;
    }
    

    
}
