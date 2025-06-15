/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Usuario
 */
public class DeLaCasa extends TipoCliente {
    
    public DeLaCasa() {
        super("DeLaCasa");
    }

    @Override
    public float calcularDescuento(Servicio s) {
        return 500;    
    }

    @Override
    public String getDescripcionBeneficio() {
        return "Beneficio de $500";
    }
    
}
