/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controladores;

import Logica.Categoria;
import Logica.Item;
import Logica.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface VistaPantallaClientes {

    public void mostrarMensajes(String message);

    public void mostrarClienteLogueado(String nombreCompleto);
    
    public void mostraCategorias(ArrayList<Categoria> categorias);

    public void mostrarItemsxCategoria(ArrayList<Item> items);

    public void cargarTabla(ArrayList<Pedido> pedidos);

    public void mostrarTotal(float total);

    public void confirmarLectura();
    
   
}
