/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Exceptions.GestorException;
import Logica.Fachada;
import Logica.Gestor;

/**
 *
 * @author agust
 */
public class ControladorLoginGestor {
    
    private VistaLoginGestor vista;
    private Fachada fachada = Fachada.getInstancia();
    
    public ControladorLoginGestor(VistaLoginGestor v) {
        this.vista = v;
    }
    
    public Gestor login(String user, String pwd){
        Gestor gestor = null;
        try{
            gestor = fachada.loginGestor(user, pwd);
        }
        catch (GestorException e){
            vista.mostrarMensajesPantalla(e.getMessage());
        }
        return gestor;
    }

    
}
