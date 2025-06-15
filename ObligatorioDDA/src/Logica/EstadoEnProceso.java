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
public class EstadoEnProceso extends EstadoPedido {

    public EstadoEnProceso(Pedido p) {
        super(p, Pedido.Estados.EN_PROCESO);
    }
   
    @Override
    public void confirmar() throws PedidoException {
        throw new PedidoException("Error: el pedido ya se encuentra confirmado y en proceso");
    }

    @Override
    public void procesar() throws PedidoException {
        throw new PedidoException("Error: el pedido ya se encuentra en proceso");
    }

    @Override
    public void finalizar() throws PedidoException {
        getPedido().cambiarEstado(new EstadoFinalizado(getPedido()));
    }

    @Override
    public void entregar() throws PedidoException {
        throw new PedidoException("Error: el pedido debe ser primero finalizado");
    }
    
    @Override
    public void eliminarPedido() throws PedidoException {
        throw new PedidoException("Un poco tarde… ya estamos elaborando este pedido!");
    }
    
    // Gestor
    @Override
    public void finalizarPedido() throws PedidoException {
        getPedido().hacerFinalizarPedido();
    }

    @Override
    public void entregarPedido() throws PedidoException {
        throw new PedidoException("Error: no se puede entregar un pedido en proceso.");
    }
    
}
