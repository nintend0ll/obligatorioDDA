/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.ClienteException;
import Exceptions.GestorException;
import Exceptions.PedidoException;
import Exceptions.ServicioException;
import java.util.ArrayList;

/**
 *
 * @author agust
 */
public class Fachada {
    
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaPedidos sPedidos = new SistemaPedidos();
    private static Fachada instancia = new Fachada();
    
    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {
    }
          
   // Sistema Acceso
    
    public void agregarCliente(Cliente c) {
        sAcceso.agregarCliente(c);
    }
    
   public void agregarGestor(Gestor g){
       sAcceso.agregarGestor(g);
   }

    public ArrayList<Gestor> getGestores() {
        return sAcceso.getGestores();
    }
    
    public void agregarDispositivo(Dispositivo d){
        sAcceso.agregarDispositivo(d);
    }
    
    public Cliente loginCliente(String user, String pwd) throws ClienteException{
        return sAcceso.loginCliente(user, pwd);
    }
    
    public Gestor loginGestor(String user, String pwd) throws GestorException{
        return sAcceso.loginGestor(user, pwd);
    }
    
   // Sistema Pedidos
    
    public void agregarUnidadProcesadora(UnidadProcesadora up){
        sPedidos.agregarUnidadProcesadora(up);
    }
    
    public void agregarCategoria(Categoria c){
        sPedidos.agregarCategoria(c);
    }

    public void agregarInsumo(Insumo i){
        sPedidos.agregarInsumo(i);
    }
    
    public void agregarItem(Item i){
        sPedidos.agregarItem(i);
    }
    
    // Para testear
    public ArrayList<Cliente> getClientes() {
        return sAcceso.getClientes();
    }

    public ArrayList<Item> getItems() {
        return sPedidos.getItems();
    }

    public ArrayList<Insumo> getInsumos() {
        return sPedidos.getInsumos();
    }

    public ArrayList<UnidadProcesadora> getUnidadesProcesadoras() {
        return sPedidos.getUnidadesProcesadoras();
    }

    public ArrayList<Categoria> getCategorias() {
        return sPedidos.getCategorias();
    }
    
    public ArrayList<Item> getItemsPorCategoriaConStock(String nombreCategoria){
        return sPedidos.getItemsPorCategoriaConStock(nombreCategoria);
    }

    public ArrayList<Servicio> getServiciosDelSistema(){
        return sPedidos.getServicios();
    }


    public void agregarServicio(Servicio s) {
        sPedidos.agregarServicio(s);
    }
    
    
   
}
