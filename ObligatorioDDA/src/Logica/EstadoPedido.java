/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.PedidoException;

/**
 *
 * @author Usuario
 */
public abstract class EstadoPedido {
    private Pedido pedido;
    private Pedido.Estados estado;

    public EstadoPedido(Pedido p, Pedido.Estados pe){
        this.pedido = p;
        this.estado = pe;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido.Estados getEstado() {
        return estado;
    }
    
    
    
    
    public abstract void confirmar() throws PedidoException;
    public abstract void procesar() throws PedidoException;
    public abstract void finalizar() throws PedidoException;
    public abstract void entregar() throws PedidoException;
    
    public abstract void eliminarPedido() throws PedidoException;
    public abstract void finalizarPedido() throws PedidoException;
    public abstract void entregarPedido() throws PedidoException;

    
}
