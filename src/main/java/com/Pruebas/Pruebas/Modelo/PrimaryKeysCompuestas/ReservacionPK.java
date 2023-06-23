package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;


public class ReservacionPK {

    private int id_empresa;
    private int id_cliente;
    private int numero;

    public ReservacionPK() {

    }

    public ReservacionPK(int num, int id_empresa, int id_cliente) {
        this.numero = num;
        this.id_cliente = id_cliente;
        this.id_empresa = id_empresa;

    }

    public int getEmpresa() {
        return id_empresa;
    }

    public void setEmpresa(int empresa) {
        this.id_empresa = empresa;
    }

    public int getCliente() {
        return id_cliente;
    }

    public void setCliente(int cliente) {
        this.id_cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int num) {
        this.numero = num;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_cliente;
        result = prime * result + id_empresa;
        result = prime * result + id_empresa;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ReservacionPK other = (ReservacionPK) obj;
        if (id_empresa != other.id_empresa) {
            return false;
        }
        if (id_cliente != other.id_cliente) {
            return false;
        }
        if (numero != other.numero) {
            return false;
        }
        return true;
    }

}
