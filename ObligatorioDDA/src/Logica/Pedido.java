/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.PedidoException;
import Exceptions.ServicioException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author agust
 */
public class Pedido {
    private Servicio servicio;
    private String comentario;
    private EstadoPedido estado = new EstadoNoConfirmado(this);
    public enum Estados{NO_CONFIRMADO,CONFIRMADO,EN_PROCESO, FINALIZADO, ENTREGADO};
    private Item item;
    private UnidadProcesadora unidadProcesadora;
    private Date fecha;
    private Gestor gestor;

    public Pedido(Servicio servicio, String comentario, Item item, UnidadProcesadora unidadProcesadora, Gestor gestor) {
        this.servicio = servicio;
        this.comentario = comentario;
        this.item = item;
        this.unidadProcesadora = unidadProcesadora;
        this.gestor = gestor;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public Item getItem() {
        return item;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }
    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        this.unidadProcesadora = unidadProcesadora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    // Métodos agregados
    
    public void validar() throws ServicioException{
        if(servicio.getDispositivo().getCliente() == null){
            throw new ServicioException("Error: Debe identificarse antes de agregar/eliminar pedidos.");
        }
        if(item == null){
            throw new ServicioException("Error: Debe seleccionar un item.");
        }
    }
   
    
    protected void cambiarEstado(EstadoPedido estadoNuevo){
        estado = estadoNuevo;
    }
    
    // Devuelve lista de pedidos sin confirmar por falta de stock (pedidos a borrar)
    public ArrayList<Pedido> confirmarPedido() throws PedidoException{
        ArrayList<Pedido> pedidosAEliminar = new ArrayList();
        if(item.tieneStock()){
            this.unidadProcesadora = item.getUnidadProcesadora();
            estado.confirmar();
            this.fecha = new Date();
            
            unidadProcesadora.agregar(this);
            
            item.decrementarStock();
            
            pedidosAEliminar = item.devolverPedidosSinStock();
            return pedidosAEliminar;
        }
        else{
            pedidosAEliminar = item.devolverPedidosSinStock();
            return pedidosAEliminar;
        }
     }
    

    @Override
    public String toString() {
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaFormateada = sdf.format(fecha); 
        return item.getNombre() + " - " + "Cliente: " + servicio.getCliente().getNombreCompleto() + " - " + fechaFormateada;
    }
    
    
    
    public void finalizarPedido() throws PedidoException{
        estado.finalizarPedido();
    }
    
    public void hacerFinalizarPedido() throws PedidoException{
        estado.finalizar();
        getServicio().avisar(Servicio.eventos.cambioPedidos);
    }
    
    public void entregarPedido() throws PedidoException{
        estado.entregarPedido();
    }
    
    public void hacerEntregarPedido() throws PedidoException{
        estado.entregar();
        getServicio().avisar(Servicio.eventos.cambioPedidos);
    }
    
    
    
   
  
    
}
