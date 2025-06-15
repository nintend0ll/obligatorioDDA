/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.PedidoException;
import java.util.ArrayList;

/**
 *
 * @author agust
 */
public class Gestor {
    private String nombreUsuario;
    private String password;
    private String nombreCompleto;
    private UnidadProcesadora unidadProcesadora;
    private ArrayList<Pedido> pedidos = new ArrayList();

    public Gestor(String nombreUsuario, String password, String nombreCompleto, UnidadProcesadora unidadProcesadora) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.unidadProcesadora = unidadProcesadora;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public void setUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        this.unidadProcesadora = unidadProcesadora;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    public Pedido obtenerPedido(int pos){
        return pedidos.get(pos);
    }
    
    public void agregarPedido(Pedido p){
        pedidos.add(p);
    }
    
    public void tomarPedido(Pedido p) throws PedidoException{
        p.setGestor(this);
        agregarPedido(p);
        p.getEstado().procesar();
        p.getServicio().avisar(Servicio.eventos.cambioPedidos);
        p.getUnidadProcesadora().avisar(UnidadProcesadora.eventos.cambioUnidadProcesadora);
    }
    
    public boolean tienePedidosPendientes(){
        for(Pedido p: pedidos){
            if(p.getEstado().getEstado() != Pedido.Estados.ENTREGADO){
                return true;
            }
        }
        return false;
    }
    
}
