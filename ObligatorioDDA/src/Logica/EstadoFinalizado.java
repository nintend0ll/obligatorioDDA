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
public class EstadoFinalizado extends EstadoPedido {
    public EstadoFinalizado(Pedido p) {
        super(p, Pedido.Estados.FINALIZADO);
    }

    @Override
    public void confirmar() throws PedidoException {
        throw new PedidoException("El pedido ya fue confirmado y procesado.");
    }

    @Override
    public void procesar() throws PedidoException {
        throw new PedidoException("El pedido ya fue procesado.");
    }

    @Override
    public void finalizar() throws PedidoException {
        throw new PedidoException("El pedido ya fue finalizado.");
    }

    @Override
    public void entregar() throws PedidoException {
        getPedido().cambiarEstado(new EstadoEntregado(getPedido()));
    }
    
    @Override
    public void eliminarPedido() throws PedidoException {
        throw new PedidoException("Un poco tarde… ese pedido ya está finalizado");
    }

    
    // Gestor
    @Override
    public void finalizarPedido() throws PedidoException {
        throw new PedidoException("Error: El pedido ya está finalizado");    
    }

    @Override
    public void entregarPedido() throws PedidoException {
        getPedido().hacerEntregarPedido();
    }
    
}
