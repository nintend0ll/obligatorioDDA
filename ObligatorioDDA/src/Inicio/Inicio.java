/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Inicio;
import IU.Principal;

/**
 *
 * @author agust
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1) Precarga de información
        DatosTest.cargar();
        DatosTest.test();
        //IU
        new Principal().setVisible(true);
        
    }
    
}
