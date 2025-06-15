/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Usuario
 */
public class Comun extends TipoCliente {

    public Comun() {
        super("Comunes");
    }

    @Override
    public float calcularDescuento(Servicio s) {
        return 0;
    }

    @Override
    public String getDescripcionBeneficio() {
        return "No hay beneficios aplicados.";
    }
    
    
}
