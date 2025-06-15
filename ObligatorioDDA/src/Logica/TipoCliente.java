/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Usuario
 */
public abstract class TipoCliente {
    private String nombre;

    public TipoCliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tipo Cliente: " + nombre;
    }
    
    public abstract float calcularDescuento(Servicio s);
    
    public abstract String getDescripcionBeneficio();
    
}
