package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import com.Pruebas.Pruebas.Modelo.CarnavalAnual;
import com.Pruebas.Pruebas.Modelo.Empresa;
import com.Pruebas.Pruebas.Modelo.TipoEntrada;

public class AutorizadoPK {

    private CarnavalAnual ano_carnaval;
    private TipoEntrada tipoEntrada;
    private Empresa empresa; 

    public AutorizadoPK() {
    }

    public AutorizadoPK(CarnavalAnual ano_carnaval, TipoEntrada tipoEntrada, Empresa empresa) {
        this.ano_carnaval = ano_carnaval;
        this.tipoEntrada = tipoEntrada;
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ano_carnaval == null) ? 0 : ano_carnaval.hashCode());
        result = prime * result + ((tipoEntrada == null) ? 0 : tipoEntrada.hashCode());
        result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
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
        AutorizadoPK other = (AutorizadoPK) obj;
        if (ano_carnaval == null) {
            if (other.ano_carnaval != null)
                return false;
        } else if (!ano_carnaval.equals(other.ano_carnaval))
            return false;
        if (tipoEntrada == null) {
            if (other.tipoEntrada != null)
                return false;
        } else if (!tipoEntrada.equals(other.tipoEntrada))
            return false;
        if (empresa == null) {
            if (other.empresa != null)
                return false;
        } else if (!empresa.equals(other.empresa))
            return false;
        return true;
    }

    public CarnavalAnual getAno_carnaval() {
        return ano_carnaval;
    }

    public void setAno_carnaval(CarnavalAnual ano_carnaval) {
        this.ano_carnaval = ano_carnaval;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


}
