/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controladores;

import Logica.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface VistaPantallaGestor {
    public void mostrarBienvenida(String nombreCompleto, String unidadProcesadora);

    public void mostrarPedidos(ArrayList<Pedido> pedidos);
    
    public void cargarTabla(ArrayList<Pedido> pedidos);

    public void mostrarMensajes(String msg);

    public void cerrarVentana();
}
