/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Usuario
 */
public class Preferencial extends TipoCliente {
    
    public Preferencial() {
        super("Preferenciales");
    }


    @Override
    public float calcularDescuento(Servicio s) {
        float descuento = 0;
        float totalAguas = s.calcularTotalAguasMinerales();
        float totalSinAguas = s.calcularTotal() - totalAguas;
        
        if(totalSinAguas > 2000){
            descuento +=  totalSinAguas * 0.05;
        }
        return descuento;
    }

    @Override
    public String getDescripcionBeneficio() {
        return "Aguas minerales gratis y si el monto total del servicio supera los $2000 tienen un 5% de descuento";
    }
    
}
