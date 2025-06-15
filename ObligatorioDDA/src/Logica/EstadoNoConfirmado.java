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
public class EstadoNoConfirmado extends EstadoPedido {

    public EstadoNoConfirmado(Pedido p) {
        super(p, Pedido.Estados.NO_CONFIRMADO);
    }

    @Override
    public void confirmar() throws PedidoException {
        getPedido().cambiarEstado(new EstadoConfirmado(getPedido()));
    }

    @Override
    public void procesar() throws PedidoException {
        throw new PedidoException("Error: no se puede procesar un pedido no confirmado.");
    }

    @Override
    public void finalizar() throws PedidoException {
        throw new PedidoException("Error: no se puede finalizar un pedido no confirmado, ni procesado.");
    }

    @Override
    public void entregar() throws PedidoException {
        throw new PedidoException("Error: no se puede entregar un pedido no confirmado, ni procesado, ni finalizado.");
    }
    
    @Override
    public void eliminarPedido() throws PedidoException {
        getPedido().getServicio().hacerEliminarPedido(getPedido());
    }
    

    // Gestor
    @Override
    public void finalizarPedido() throws PedidoException {
        throw new PedidoException("Error: no se puede finalizar un pedido no confirmado.");
    }

    @Override
    public void entregarPedido() throws PedidoException {
        throw new PedidoException("Error: no se puede entregar un pedido no confirmado.");
    }

}
