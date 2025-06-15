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
public class Categoria {
    private String nombre;
    private ArrayList<Item> items = new ArrayList();

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
    public void agregarItem(Item i){
        if(!items.contains(i)){
           items.add(i);
        }
    }
    
    
    public ArrayList<Item> getItemsConStock(){
        ArrayList<Item> itemsConStock = new ArrayList();
        for(Item i: items){
            if(i.tieneStock()){
                itemsConStock.add(i);
            }
        }
        return itemsConStock;
    }
    
    
}
