package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import com.Pruebas.Pruebas.Modelo.Cliente;
import com.Pruebas.Pruebas.Modelo.Empresa;

public class ReservacionPK {

    private Empresa id_empresa;
    private Cliente id_cliente;
    private int numero;
    public ReservacionPK(Empresa id_empresa, Cliente id_cliente, int numero) {
        this.id_empresa = id_empresa;
        this.id_cliente = id_cliente;
        this.numero = numero;
    }
    public ReservacionPK() {
    }
    public Empresa getId_empresa() {
        return id_empresa;
    }
    public void setId_empresa(Empresa id_empresa) {
        this.id_empresa = id_empresa;
    }
    public Cliente getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_empresa == null) ? 0 : id_empresa.hashCode());
        result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
        result = prime * result + numero;
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
        ReservacionPK other = (ReservacionPK) obj;
        if (id_empresa == null) {
            if (other.id_empresa != null)
                return false;
        } else if (!id_empresa.equals(other.id_empresa))
            return false;
        if (id_cliente == null) {
            if (other.id_cliente != null)
                return false;
        } else if (!id_cliente.equals(other.id_cliente))
            return false;
        if (numero != other.numero)
            return false;
        return true;
    }

   

}
