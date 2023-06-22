package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import com.Pruebas.Pruebas.Modelo.Cliente;
import com.Pruebas.Pruebas.Modelo.Empresa;


public class ReservacionPK {

    private Empresa empresa;
    private Cliente cliente;
    private int id;

    public ReservacionPK(){

    }

    public ReservacionPK(int id, int id_empresa, int id_cliente){
        this.id=id;


    }
    public Empresa getEmpresa(){
        return empresa;
    }
    public void setEmpresa(Empresa empresa){
        this.empresa=empresa;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        ReservacionPK other =(ReservacionPK) obj;
        if(empresa==null){
            if(other.empresa != null){
                return false;
            }
        }else if(!empresa.equals(other.empresa)){
            return false;
        }
        if (cliente==null){
            if(other.cliente!=null){
                return false;
            }
        }else if(!cliente.equals(other.cliente)){
            return false;
        }
        return true;
    }
    
}
