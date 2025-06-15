/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Exceptions.PedidoException;
import Exceptions.ServicioException;
import Observador.Observable;
import java.util.ArrayList;

/**
 *
 * @author agust
 */
public class Servicio extends Observable {
    public enum eventos{cambioPedidos, itemsEliminados};
    
    private Fachada fachada = Fachada.getInstancia();
    
    private Cliente cliente;
    private Dispositivo dispositivo;
    private ArrayList<Pedido> pedidos = new ArrayList();
    private ArrayList<Item> itemsEliminados = new ArrayList();
    private float montoTotal;

    public Servicio(Cliente cliente) {
        this.cliente = cliente;
        montoTotal = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public ArrayList<Item> getItemsEliminados() {
        return itemsEliminados;
    }

    public void setItemsEliminados(ArrayList<Item> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }
    
    public void vaciarItemsEliminados() {
        itemsEliminados.clear();
    }
    
    public float calcularTotal(){
        float total = 0;
        for(Pedido p: getPedidos()){
            total += p.getItem().getPrecioUnitario();
        }
        return total;
    }
    
    public float calcularTotalAguasMinerales(){
        float totalAguas = 0;
        for(Pedido p: getPedidos()){
            if (p.getItem().getNombre().equals("Agua mineral")) {
                totalAguas += p.getItem().getPrecioUnitario();
            }
        }
        return totalAguas;
    }
    
    public float calcularTotalCafes(){
        float totalCafes = 0;
        for(Pedido p: getPedidos()){
            String nombreItem = p.getItem().getNombre().toLowerCase();
            if (nombreItem.contains("cafe")) {
                totalCafes += p.getItem().getPrecioUnitario();
            }
        }
        return totalCafes;
    }
    
    public void validar() throws ServicioException{
        if(getPedidos().isEmpty()){
            throw new ServicioException("Error: no hay pedidos en el servicio.");
        }
        if(hayPedidosSinConfirmar()){
            throw new ServicioException("Error: ¡Tienes pedidos sin confirmar!");
        }
    }
    

    public boolean hayPedidosSinConfirmar() {
        for(Pedido p: pedidos){
            if(p.getEstado().getEstado() == Pedido.Estados.NO_CONFIRMADO){
                return true;
            }
        }
        return false;
    }
    
    public int contarPedidosConfirmadosNoEntregados() {
        int contador = 0;
        for(Pedido p: pedidos){
            if(p.getEstado().getEstado() == Pedido.Estados.CONFIRMADO || p.getEstado().getEstado() == Pedido.Estados.EN_PROCESO 
                    || p.getEstado().getEstado() == Pedido.Estados.FINALIZADO){
                contador++;
            }
        }
        return contador;
    }
    
    public float calcularMontoTotal(){
        float total = 0;
        for(Pedido p: pedidos){
            total += p.getItem().getPrecioUnitario();
        }
        
        float descuento = cliente.getTipoCliente().calcularDescuento(this);
        return total - descuento;
    }
   
    
    public void agregarPedido(Item item, String comentario) throws ServicioException{
        Pedido p = new Pedido(this, comentario, item, null, null);
        p.validar();
        p.getItem().agregarPedido(p);
        pedidos.add(p);
    }

    public void eliminarPedido(int posPedido) throws ServicioException, PedidoException {
        if(posPedido == -1){
            throw new ServicioException("Debe seleccionar un pedido");
        }
        Pedido p = pedidos.get(posPedido);
        p.getEstado().eliminarPedido();
    }
    
    public void hacerEliminarPedido(Pedido p){
        pedidos.remove(p);
        p.getItem().eliminarPedido(p);
        p.getItem().incrementaStock();
        
        if(p.getUnidadProcesadora() != null){
            p.getUnidadProcesadora().remover(p);
        }
    }
    

    public void confirmarPedidos() throws PedidoException{
       ArrayList<Pedido> pedidosAEliminar = new ArrayList();
       for(Pedido p: pedidos){
            if(p.getEstado().getEstado() == Pedido.Estados.NO_CONFIRMADO){
                pedidosAEliminar.addAll(p.confirmarPedido());
            } 
       }
       
       if(!pedidosAEliminar.isEmpty()){
            for (Pedido p2 : pedidosAEliminar) {
                // Eliminar del servicio de a quién pertenece ese pedido
                Servicio servicio = p2.getServicio();
                servicio.getPedidos().remove(p2);
                servicio.itemsEliminados.add(p2.getItem());
                servicio.avisar(eventos.cambioPedidos);
                servicio.avisar(eventos.itemsEliminados);
            }          
       }
       
       pedidos.removeAll(pedidosAEliminar);
       avisar(eventos.cambioPedidos);
    }
    
    public String getPedidosFinalizados(){
        String msg = "";
        for(Pedido p: pedidos){
            if(p.getEstado().getEstado() == Pedido.Estados.FINALIZADO){
                msg += "Pedido finalizado, recuerda retirarlo. Pedido de: " + p.getItem();
            }
        }
        return msg;
    }
    
    
}
