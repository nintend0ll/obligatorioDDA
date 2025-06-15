/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Usuario
 */
public class Frecuente extends TipoCliente {
    
    public Frecuente() {
        super("Frecuentes");
    }

    @Override
    public float calcularDescuento(Servicio s) {
        // 0 por cada café del servicio
        return s.calcularTotalCafes();
    }

    @Override
    public String getDescripcionBeneficio() {
        return "Beneficio aplicado: cafés gratis.";
    }
    
}
