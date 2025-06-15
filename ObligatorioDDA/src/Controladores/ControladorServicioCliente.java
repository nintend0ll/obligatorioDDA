/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Exceptions.PedidoException;
import Exceptions.ServicioException;
import Logica.Dispositivo;
import Logica.Item;
import Logica.Servicio;
import Observador.Observable;
import Observador.Observador;

/**
 *
 * @author Usuario
 */
public class ControladorServicioCliente implements Observador {
    private VistaPantallaClientes vista;
    private Dispositivo dispositivoActivo;
    private ControladorFachada ctrlFachada;

    public ControladorServicioCliente(VistaPantallaClientes vista, Dispositivo dispositivoActivo, ControladorFachada ctrl){
        this.vista = vista;
        this.dispositivoActivo = dispositivoActivo;
        this.ctrlFachada = ctrl;
    }

    public void confirmarPedidos(){
        try {
            if(dispositivoActivo.getCliente() == null){
                vista.mostrarMensajes("Error: Debe identificarse antes de confirmar pedidos.");
            } else {
                dispositivoActivo.getServicio().confirmarPedidos();
            }
        } catch (PedidoException pe){
            vista.mostrarMensajes(pe.getMessage());
        }
    }

    public void finalizarServicio(){
        try{
            String mensaje = dispositivoActivo.finalizarServicio();
            vista.mostrarMensajes(mensaje);
            ctrlFachada.mostrarPedidos();
            vista.confirmarLectura();
        } catch(ServicioException se){
            vista.mostrarMensajes(se.getMessage());
        }
    }

    @Override
    public void actualizar(Object evento, Observable origen){
        if(evento.equals(Servicio.eventos.cambioPedidos)){
            String mensaje = dispositivoActivo.getServicio().getPedidosFinalizados();
            if(!mensaje.isEmpty()){
                vista.mostrarMensajes(mensaje);
            }

            ctrlFachada.mostrarPedidos();
            ctrlFachada.cargarItemsxCategoria(ctrlFachada.getCategoriaSeleccionada());
            ctrlFachada.mostrarTotal();
        }

        if(evento.equals(Servicio.eventos.itemsEliminados)){
            String msg = "";
            for(Item i: dispositivoActivo.getServicio().getItemsEliminados()){
                msg += "Lo sentimos, nos hemos quedado sin stock de: " + i.getNombre() + " por lo que hemos quitado el pedido del servicio. ";
            }
            vista.mostrarMensajes(msg);
            dispositivoActivo.getServicio().vaciarItemsEliminados();
        }
    }
}