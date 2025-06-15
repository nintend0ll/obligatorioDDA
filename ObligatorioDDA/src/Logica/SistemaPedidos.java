/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class SistemaPedidos{
     private ArrayList<UnidadProcesadora> unidadesProcesadoras = new ArrayList();
     private ArrayList<Categoria> categorias = new ArrayList();
     private ArrayList<Insumo> insumos = new ArrayList();
     private ArrayList<Item> items = new ArrayList();
     private ArrayList<Servicio> servicios = new ArrayList();
     
    public ArrayList<UnidadProcesadora> getUnidadesProcesadoras() {
        return unidadesProcesadoras;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public ArrayList<Insumo> getInsumos() {
        return insumos;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
     
    // métodos
    public void agregarUnidadProcesadora(UnidadProcesadora up){
       unidadesProcesadoras.add(up);
    }

    public void agregarCategoria(Categoria c){
        categorias.add(c);
    }

    public void agregarInsumo(Insumo i){
        insumos.add(i);
    }

    public void agregarItem(Item i){
        items.add(i);
    }
    
    public void agregarServicio(Servicio s){
        servicios.add(s);
    }
    
    public ArrayList<Servicio> getServicios(){
        return servicios;
    }
    
    public ArrayList<Item> getItemsPorCategoriaConStock(String nombreCategoria){
        ArrayList<Item> items = new ArrayList();
        for(Categoria c: categorias){
            if(c.getNombre().equals(nombreCategoria)){
                items = c.getItemsConStock();
                return items;
            }
        }
        return items;
    }
}
