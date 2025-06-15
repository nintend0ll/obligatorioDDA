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
public class EstadoConfirmado extends EstadoPedido {

    public EstadoConfirmado(Pedido p) {
        super(p, Pedido.Estados.CONFIRMADO);
    }

    @Override
    public void confirmar() throws PedidoException {
        throw new PedidoException("Error: el pedido ya está confirmado.");
    }

    @Override
    public void procesar() throws PedidoException {
        getPedido().cambiarEstado(new EstadoEnProceso(getPedido()));
    }

    @Override
    public void finalizar() throws PedidoException {
        throw new PedidoException("Error: el pedido debe estar procesado primero.");
    }

    @Override
    public void entregar() throws PedidoException {
        throw new PedidoException("Error: el pedido debe estar procesado y finalizado primero.");

    }
    
    @Override
    public void eliminarPedido() throws PedidoException {
        getPedido().getServicio().hacerEliminarPedido(getPedido());
    }


    
    // Gestor
    @Override
    public void finalizarPedido() throws PedidoException {
        throw new PedidoException("Error: No se puede finalizar un pedido confirmado.");
    }

    @Override
    public void entregarPedido() throws PedidoException {
        throw new PedidoException("Error: no se puede entregar un pedido confirmado.");
    }

}
