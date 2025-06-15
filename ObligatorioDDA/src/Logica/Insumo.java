/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author agust
 */
public class Insumo {
    private String nombre;
    public int stockMinimo;
    public int stockActual;
    private ArrayList<Item> items = new ArrayList();
    
    
    public Insumo(String nombre, int stockMinimo, int stockActual) {
        this.nombre = nombre;
        this.stockMinimo = stockMinimo;
        this.stockActual = stockActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
    
    public void decrementarStock(int cantidad){
        setStockActual(stockActual - cantidad);
    }
    
    public void incrementarStock(int cantidad){
        setStockActual(stockActual + cantidad);
    }
    
    public void agregarItem(Item i){
        if(!items.contains(i)){
            items.add(i);
        }
    }
    
    public ArrayList<Item> devolverItemsConInsumoSinStock(){
        ArrayList<Item> itemsConInsumosSinStock = new ArrayList();
        if(stockActual < stockMinimo){
            for(Item i: items){
                if(!i.tieneStock()){
                    itemsConInsumosSinStock.add(i);
                }
            }
        }
        return itemsConInsumosSinStock;
    }
}
