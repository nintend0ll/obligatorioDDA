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
 * @author Usuario
 */
public class SistemaAcceso {
    private ArrayList<Cliente> clientes = new ArrayList();
    private ArrayList<Gestor> gestores = new ArrayList();
    private ArrayList<Dispositivo> dispositivos = new ArrayList();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }
    
    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }
    
    public void agregarGestor(Gestor g){
        gestores.add(g);
    }
    
    public void agregarDispositivo(Dispositivo d){
        dispositivos.add(d);
    }
    
    //Logins
    public Cliente loginCliente(String user, String pwd) throws ClienteException{
       // Sí el cliente ya está identificado en otro dispositivo
       Cliente c = buscarCliente(user, pwd);
       for(Dispositivo d: dispositivos){
           if(d.getCliente() == c){
               throw new ClienteException("Error: el cliente ya está identificado en otro dispositivo.");
           }
       }
       return c;
    }
    
    //TODO: Guardar gestores en un arrayList
    public Gestor loginGestor(String user, String pwd) throws GestorException{
       return buscarGestor(user, pwd);
    }
    
    
    //Buscar    
    private Cliente buscarCliente(String user, String pwd) throws ClienteException{
        for(Cliente c: clientes){
            try{
                int numeroCliente = Integer.parseInt(user);
                if(c.getNumeroCliente() == numeroCliente && c.getPassword().equals(pwd)){
                    return c;
                }
            }catch(Exception e){
                throw new ClienteException("El número de cliente debe ser un valor numérico.");
            }
           
        }
        throw new ClienteException("Error: Credenciales incorrectas");
    }
    

     //verificar si hay que hacer try catch para mostrar exception (para mi no, para mí tampoco)
    private Gestor buscarGestor(String user, String pwd) throws GestorException{
        for(Gestor g : gestores){      
            if(g.getNombreUsuario().equals(user) && g.getPassword().equals(pwd)){
                return g;
            }
        }
       throw new GestorException("Error: Credenciales incorrectas.");
    }

}
