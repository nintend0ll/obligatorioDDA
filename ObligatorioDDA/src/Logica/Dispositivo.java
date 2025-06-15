/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.ServicioException;
import Observador.Observable;

/**
 *
 * @author agust
 */
public class Dispositivo {
    
    private static int contador;
    private int id;
    private boolean estaOcupado;
    private Cliente cliente;
    private Servicio servicio;
    
    
    public Dispositivo() {
        this.id = ++contador;
        estaOcupado = false;
    }

    public int getId() {
        return id;
    }

    public boolean isEstaOcupado() {
        return estaOcupado;
    }

    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public String finalizarServicio() throws ServicioException{
        String mensaje = "";
        
        if(cliente == null){
            throw new ServicioException("Error: Debe identificarse antes de finalizar el servicio");
        }
        
        servicio.validar();
        
        
        int pedidosEnProceso = servicio.contarPedidosConfirmadosNoEntregados();
        if (pedidosEnProceso > 0) {
            mensaje += "¡Tienes " + pedidosEnProceso + " pedidos en proceso, recuerda ir a retirarlos!   ";
            
            mensaje += "¡Pago realizado! Descuentos aplicados a : " + servicio.getCliente().getTipoCliente().toString() + ", " +
            servicio.getCliente().getTipoCliente().getDescripcionBeneficio();
        }
        else{
            mensaje += "¡Pago realizado! Descuentos aplicados a : " + servicio.getCliente().getTipoCliente().toString() + ", " +
            servicio.getCliente().getTipoCliente().getDescripcionBeneficio();
                    
            this.cliente.setDispositivo(null);
            this.cliente.setServicio(null);
            this.cliente = null;
            this.setEstaOcupado(false);
            this.setServicio(null);
        } 
       
        
        return mensaje;     
    }
    
    
    
    
    
    
}
