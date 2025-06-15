/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.ClienteException;


/**
 *
 * @author agust
 */
public class Cliente {
    private Fachada fachada = Fachada.getInstancia();
    private int numeroCliente;
    private String password;
    private String nombreCompleto;
    private Dispositivo dispositivo;
    private TipoCliente tipoCliente;
    private Servicio servicio;

    public Cliente(int numeroCliente, String password, String nombreCompleto, TipoCliente tc) {
        this.numeroCliente = numeroCliente;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.tipoCliente = tc;
    }
    
    public Cliente(){}

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    // Métodos agregados
    
    public void agregarNuevoServicio(Dispositivo d) throws ClienteException{
        if(d.getCliente() != null){
            throw new ClienteException("Error: primero debe finalizar el servicio actual.");
        }
        else{
            this.dispositivo = d;
            Servicio s = new Servicio(this);
            dispositivo.setServicio(s);
            dispositivo.setEstaOcupado(true);
            dispositivo.setCliente(this);
            dispositivo.setServicio(s);
            s.setDispositivo(dispositivo);
            fachada.agregarServicio(s);
        }
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.numeroCliente;
        return hash;
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
        final Cliente other = (Cliente) obj;
        return this.numeroCliente == other.numeroCliente;
    }
    
    
    
    
}
