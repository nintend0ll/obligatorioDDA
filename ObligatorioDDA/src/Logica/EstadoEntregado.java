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
public class EstadoEntregado extends EstadoPedido {

    public EstadoEntregado(Pedido p) {
        super(p, Pedido.Estados.ENTREGADO);
    }

    @Override
    public void confirmar() throws PedidoException {
        throw new PedidoException("Error: El pedido ya está entregado.");
    }

    @Override
    public void procesar() throws PedidoException {
        throw new PedidoException("Error: El pedido ya está entregado.");
    }

    @Override
    public void finalizar() throws PedidoException {
        throw new PedidoException("Error: El pedido ya está entregado.");
    }

    @Override
    public void entregar() throws PedidoException {
        throw new PedidoException("Error: El pedido ya está entregado.");
    }
    
    @Override
    public void eliminarPedido() throws PedidoException {
        throw new PedidoException("Error: Un poco tarde… ese pedido ya está entregado!");
    }

    // Gestor
    @Override
    public void finalizarPedido() throws PedidoException {
        throw new PedidoException("Error: El pedido ya está entregado.");
    }

    @Override
    public void entregarPedido() throws PedidoException {
        throw new PedidoException("Error: el pedido ya está entregado.");
    }

    
}
