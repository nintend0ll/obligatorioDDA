/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.PedidoException;
import Observador.Observable;
import java.util.ArrayList;

/**
 *
 * @author agust
 */
public class UnidadProcesadora extends Observable{

    public enum eventos{cambioUnidadProcesadora}
    
    private String nombre;
    private ArrayList<Gestor> gestores = new ArrayList();
    private ArrayList<Pedido> pedidos = new ArrayList();
    
    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }    
    
    
    public void addGestor(Gestor g){
        gestores.add(g);
    }
    
    public void agregar(Pedido p) {
        pedidos.add(p);
        avisar(eventos.cambioUnidadProcesadora);
    }
    
    public void remover(Pedido p){
        pedidos.remove(p);
        avisar(eventos.cambioUnidadProcesadora);
    }
    
    public ArrayList<Pedido> getPedidosPendientes(){
        ArrayList<Pedido> ret = new ArrayList();

        for(Pedido p: pedidos){
            if(p.getGestor() == null){
               ret.add(p);
            }
        }
        return ret;
    }
    
    public ArrayList<Pedido> getPedidosEnProcesoMios(Gestor g){
        ArrayList<Pedido> ret = new ArrayList();
        for(Pedido p: pedidos){
            if((p.getEstado().getEstado() == Pedido.Estados.EN_PROCESO || p.getEstado().getEstado() == Pedido.Estados.FINALIZADO ||
                    p.getEstado().getEstado() == Pedido.Estados.ENTREGADO) && p.getGestor().equals(g)){
               ret.add(p);
            }
        }
        return ret;
    }
    
    
    
    
}
