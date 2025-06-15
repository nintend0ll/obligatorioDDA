/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author agust
 */
public class Item{
    private String nombre;
    private float precioUnitario;
    private Categoria categoria;
    private ArrayList<Ingrediente> ingredientes = new ArrayList();
    private ArrayList<Pedido> pedidos = new ArrayList();
    private UnidadProcesadora unidadProcesadora;
    private ArrayList<Insumo> insumos = new ArrayList();

    public Item(String nombre, float precioUnitario, Categoria categoria, UnidadProcesadora unidadProcesadora) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;
        this.unidadProcesadora = unidadProcesadora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
    
    
    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    
    public void agregarPedido(Pedido p){
        pedidos.add(p);
    }
    
    public void eliminarPedido(Pedido p){
        pedidos.remove(p);
    }
    
    // métodos agregados
    public void agregarIngrediente(Ingrediente i){
        if(!ingredientes.contains(i)){
            ingredientes.add(i);
            
            i.getInsumo().agregarItem(this); 
            if (!insumos.contains(i.getInsumo())) {
                insumos.add(i.getInsumo());
            }
        }
    }
    
    public boolean tieneStock(){
        for(Ingrediente i: ingredientes){
            if(i.getInsumo().getStockActual() < i.getInsumo().getStockMinimo()){
                return false;
            }
        }
        return true;
    }
    
    // Decrementa stock de un insumo
    public void decrementarStock(){
        for (Ingrediente ing : ingredientes) {
            ing.getInsumo().decrementarStock(ing.getCantidad());
        }
        if(!tieneStock()){
            
        }
    }
    
    public void incrementaStock(){
       for (Ingrediente ing : ingredientes) {
            ing.getInsumo().incrementarStock(ing.getCantidad());
        }
    }
    
    //Precondición: no hay más stock de este item
    // Borra los pedidos sin stock de sí mismo, y los devuelve
    public ArrayList<Pedido> eliminarPedidosSinStock(){
        ArrayList<Pedido> pedidosAEliminar = new ArrayList();

        for(Pedido p: pedidos){
            if(p.getEstado().getEstado() == Pedido.Estados.NO_CONFIRMADO){
                pedidosAEliminar.add(p);
            }
        }
        pedidos.removeAll(pedidosAEliminar);
        
        return pedidosAEliminar;
    }

    // Devuelve todos los pedidos de items con insumos que no tengan stock
    public ArrayList<Pedido> devolverPedidosSinStock(){
        ArrayList<Pedido> pedidosAEliminar = new ArrayList();
        
        if(!tieneStock()){
            for(Insumo i: insumos){
                if(i.stockActual < i.stockMinimo){

                    ArrayList<Item> itemsAEliminar = i.devolverItemsConInsumoSinStock();

                    for(Item it: itemsAEliminar){
                        pedidosAEliminar.addAll(it.eliminarPedidosSinStock());
                    }
                }
            }
        }
        return pedidosAEliminar;
    }
    
    
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
}
