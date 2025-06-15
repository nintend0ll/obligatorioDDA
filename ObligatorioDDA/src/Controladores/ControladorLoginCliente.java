/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Exceptions.ClienteException;
import Logica.Cliente;
import Logica.Dispositivo;
import Logica.Fachada;
import Observador.Observador;

/**
 *
 * @author Usuario
 */
public class ControladorLoginCliente {
    private VistaPantallaClientes vista;
    private Fachada fachada = Fachada.getInstancia();
    private Dispositivo dispositivoActivo;
    
    public ControladorLoginCliente(VistaPantallaClientes vpc, Dispositivo d){
        this.vista = vpc;
        dispositivoActivo = d;
        fachada.agregarDispositivo(dispositivoActivo); 
    }
    
    // TODO: Mejorar login, hace demasiadas cosas
    public void login(String user, String pwd){
        try{
            Cliente cliente = fachada.loginCliente(user, pwd);
            
            // En cuanto esté logueado el cliente le agregamos también un nuevo servicio
            cliente.agregarNuevoServicio(dispositivoActivo);
            
            vista.mostrarClienteLogueado(cliente.getNombreCompleto());
            vista.mostrarMensajes("¡Logueado/a con éxito!");
        }
        catch (ClienteException e){
             vista.mostrarMensajes(e.getMessage());
        }
    }
}
