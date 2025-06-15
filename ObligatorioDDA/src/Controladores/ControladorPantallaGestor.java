/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Exceptions.PedidoException;
import Logica.Fachada;
import Logica.Gestor;
import Logica.Pedido;
import Logica.UnidadProcesadora;
import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorPantallaGestor implements Observador{
    private Fachada fachada = Fachada.getInstancia();
    private VistaPantallaGestor vista;
    private Gestor gestorLogueado;
    private ArrayList<Pedido> pedidosPendientes;
    private ArrayList<Pedido> pedidosEnProcesoMios;

    public ControladorPantallaGestor(VistaPantallaGestor vista, Gestor g) {
        this.vista = vista;
        this.gestorLogueado = g;
        this.gestorLogueado.getUnidadProcesadora().agregarObservador(this);
        mostrarPedidosUnidadProcesadora();
        cargarTabla();
    }
    
    public void setBienvenida() {
        vista.mostrarBienvenida(gestorLogueado.getNombreCompleto(), gestorLogueado.getUnidadProcesadora().getNombre());
    }
    
    public void tomarPedido(int pos){
        if(pos == -1){
            mostrarMensajesPantalla("Error: Debe seleccionar un pedido");
        }
        else{
            try{
                Pedido p = pedidosPendientes.get(pos);
                gestorLogueado.tomarPedido(p);
            }
            catch(PedidoException pe){
                mostrarMensajesPantalla(pe.getMessage());
            }
        }
    }
        
    public void mostrarPedidosUnidadProcesadora(){
        this.pedidosPendientes = gestorLogueado.getUnidadProcesadora().getPedidosPendientes();
        vista.mostrarPedidos(pedidosPendientes);
    }
    
    public void cargarTabla(){
        this.pedidosEnProcesoMios = gestorLogueado.getUnidadProcesadora().getPedidosEnProcesoMios(gestorLogueado);
        vista.cargarTabla(pedidosEnProcesoMios);
    }
    
    
    public void finalizarPedidos(int pos){
        if(pos == -1){
            mostrarMensajesPantalla("Error: Debe seleccionar un pedido");
        }
        else{
            try{ 
                Pedido p = pedidosEnProcesoMios.get(pos);
                p.finalizarPedido();
                cargarTabla();
                mostrarMensajesPantalla("¡Pedido finalizado!");
            }
            catch(PedidoException pe){
                mostrarMensajesPantalla(pe.getMessage());
            }
        }
    }
    
    public void entregarPedido(int pos){
        if(pos == -1){
            mostrarMensajesPantalla("Error: Debe seleccionar un pedido");
        }
        else{
            try{ 
                Pedido p = pedidosEnProcesoMios.get(pos);
                p.entregarPedido();
                cargarTabla();
                mostrarMensajesPantalla("¡Pedido entregado!");
            }
            catch(PedidoException pe){
                mostrarMensajesPantalla(pe.getMessage());
            }
        }
    }
    
    public void cerrarVentana(){
        if(!gestorLogueado.tienePedidosPendientes()){
            vista.cerrarVentana();
        }
        else{
            mostrarMensajesPantalla("Error: Tiene pedidos pendientes.");
        }
    }
    
    
    public void mostrarMensajesPantalla(String msg){
        vista.mostrarMensajes(msg);
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(UnidadProcesadora.eventos.cambioUnidadProcesadora)){
            mostrarPedidosUnidadProcesadora();
            cargarTabla();
        }
    }
    
    
}
