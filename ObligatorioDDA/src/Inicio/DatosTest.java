/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inicio;

import Logica.Categoria;
import Logica.Cliente;
import Logica.Comun;
import Logica.DeLaCasa;
import Logica.Dispositivo;
import Logica.EstadoPedido;
import Logica.Fachada;
import Logica.Frecuente;
import Logica.Gestor;
import Logica.Ingrediente;
import Logica.Insumo;
import Logica.Item;
import Logica.Pedido;
import Logica.Preferencial;
import Logica.Servicio;
import Logica.TipoCliente;
import Logica.UnidadProcesadora;

/**
 *
 * @author agust
 */
public class DatosTest {
    public static void cargar(){
        Fachada fachada = Fachada.getInstancia();
        
        // Dispositivos

        fachada.agregarDispositivo(new Dispositivo());
        
        // Clientes con sus tipos
        
        TipoCliente tc1 = new Comun();
        TipoCliente tc2 = new DeLaCasa();
        TipoCliente tc3 = new Frecuente();
        TipoCliente tc4 = new Preferencial();
        
        Cliente c1 = new Cliente(0, "1234", "Jordi", tc1);
        Cliente c2 = new Cliente(1, "1234", "Agustina", tc2);
        Cliente c3 = new Cliente(2, "1234", "Sofia", tc3);
        Cliente c4 = new Cliente(3, "1234", "Marco", tc4);
        
        fachada.agregarCliente(c1);
        fachada.agregarCliente(c2);
        fachada.agregarCliente(c3);
        fachada.agregarCliente(c4);
        
        // Unidades Procesadoras
        UnidadProcesadora up1 = new UnidadProcesadora("Cocina");
        UnidadProcesadora up2 = new UnidadProcesadora("Bar");
        UnidadProcesadora up3 = new UnidadProcesadora("Barra De Sushi");
        
        fachada.agregarUnidadProcesadora(up1);
        fachada.agregarUnidadProcesadora(up2);
        fachada.agregarUnidadProcesadora(up3);
        
        // Gestores
        Gestor g1 = new Gestor("ca", "1234", "Charly Fideos", up1);
        Gestor g2 = new Gestor("b", "1234", "Barney Bebidas", up2);
        Gestor g3 = new Gestor("ma", "1234", "Mao Zedong", up3);
        Gestor g4 = new Gestor("m", "1234", "Momo hirai", up1);
        Gestor g5 = new Gestor("a", "1234", "Ariana Grande", up2);
        Gestor g6 = new Gestor("c", "1234", "Chuu", up3);
        
        up1.addGestor(g1);
        up2.addGestor(g2);
        up3.addGestor(g3);
        up1.addGestor(g4);
        up2.addGestor(g5);
        up3.addGestor(g6);
        
        fachada.agregarGestor(g1); 
        fachada.agregarGestor(g2);    
        fachada.agregarGestor(g3); 
        fachada.agregarGestor(g4);
        fachada.agregarGestor(g5);
        fachada.agregarGestor(g6);

        // Categorías
        Categoria cat1 = new Categoria("Entrada");
        Categoria cat2 = new Categoria("Principal");
        Categoria cat3 = new Categoria("Postre");
        Categoria cat4 = new Categoria("Bebida");

        fachada.agregarCategoria(cat1);
        fachada.agregarCategoria(cat2);
        fachada.agregarCategoria(cat3);
        fachada.agregarCategoria(cat4);

        // Insumos existentes
        Insumo i1 = new Insumo("Milanesa", 10, 11);
        Insumo i2 = new Insumo("Papas", 20, 21);
        Insumo i3 = new Insumo("Coca cola", 5, 6);
        Insumo i4 = new Insumo("Gin", 5, 6);
        Insumo i5 = new Insumo("Arroz", 15, 16);
        Insumo i6 = new Insumo("Panceta", 20, 21);
        Insumo i7 = new Insumo("Cafe", 10, 11);
        Insumo i8 = new Insumo("Agua mineral", 10, 11);
        Insumo i9 = new Insumo("Salmon", 10, 11);
        Insumo i10 = new Insumo("Wasabi", 5, 6);

        // Nuevos insumos
        Insumo i11 = new Insumo("Tteok", 10, 11);
        Insumo i12 = new Insumo("Gochujang", 10, 11);
        Insumo i13 = new Insumo("Chorizo", 15, 16);
        Insumo i14 = new Insumo("Asado", 20, 21);
        Insumo i15 = new Insumo("Pan", 10, 11);
        Insumo i16 = new Insumo("Jamón", 10, 11);
        Insumo i17 = new Insumo("Queso", 10, 11);
        Insumo i18 = new Insumo("Lechuga", 10, 11);
        Insumo i19 = new Insumo("Tomate", 10, 11);
        Insumo i20 = new Insumo("Vodka", 10, 11);
        Insumo i21 = new Insumo("Jugo de naranja", 10, 11);
        Insumo i22 = new Insumo("Tónica", 10, 11);
        Insumo i23 = new Insumo("Dulce de leche", 10, 11);
        Insumo i24 = new Insumo("Merengue", 10, 11);
        Insumo i25 = new Insumo("Helado", 10, 11);
        Insumo i26 = new Insumo("Arroz dulce", 10, 11);
        Insumo i27 = new Insumo("Pasta de porotos rojos", 10, 11);
        Insumo i28 = new Insumo("Tónica", 10, 11);
                
        fachada.agregarInsumo(i1);
        fachada.agregarInsumo(i2);
        fachada.agregarInsumo(i3);
        fachada.agregarInsumo(i4);
        fachada.agregarInsumo(i5);
        fachada.agregarInsumo(i6);
        fachada.agregarInsumo(i7);
        fachada.agregarInsumo(i8);
        fachada.agregarInsumo(i9);
        fachada.agregarInsumo(i10);
        fachada.agregarInsumo(i11);
        fachada.agregarInsumo(i12);
        fachada.agregarInsumo(i13);
        fachada.agregarInsumo(i14);
        fachada.agregarInsumo(i15);
        fachada.agregarInsumo(i16);
        fachada.agregarInsumo(i17);
        fachada.agregarInsumo(i18);
        fachada.agregarInsumo(i19);
        fachada.agregarInsumo(i20);
        fachada.agregarInsumo(i21);
        fachada.agregarInsumo(i22);
        fachada.agregarInsumo(i23);
        fachada.agregarInsumo(i24);
        fachada.agregarInsumo(i25);
        fachada.agregarInsumo(i26);
        fachada.agregarInsumo(i27);
        fachada.agregarInsumo(i28);
        
        // Ítems
        Item item1 = new Item("Milanesa con fritas", 950, cat2, up1);
        item1.agregarIngrediente(new Ingrediente(i1, 1));
        item1.agregarIngrediente(new Ingrediente(i2, 1));
        cat2.agregarItem(item1);
        fachada.agregarItem(item1);

        Item item2 = new Item("Gin Tonic", 600, cat4, up2);
        item2.agregarIngrediente(new Ingrediente(i4, 1));
        item2.agregarIngrediente(new Ingrediente(i28, 1));
        cat4.agregarItem(item2);
        fachada.agregarItem(item2);

        Item item3 = new Item("Nigiri", 700, cat1, up3);
        item3.agregarIngrediente(new Ingrediente(i5, 1));
        item3.agregarIngrediente(new Ingrediente(i9, 1));
        item3.agregarIngrediente(new Ingrediente(i10, 1));
        cat1.agregarItem(item3);
        fachada.agregarItem(item3);

        // Nuevos platos coreanos y uruguayos
        Item item4 = new Item("Tteokbokki", 750, cat2, up1);
        item4.agregarIngrediente(new Ingrediente(i11, 1));
        item4.agregarIngrediente(new Ingrediente(i12, 1));
        cat2.agregarItem(item4);
        fachada.agregarItem(item4);

        Item item5 = new Item("Chivito uruguayo", 890, cat2, up1);
        item5.agregarIngrediente(new Ingrediente(i15, 1));
        item5.agregarIngrediente(new Ingrediente(i16, 1));
        item5.agregarIngrediente(new Ingrediente(i17, 1));
        item5.agregarIngrediente(new Ingrediente(i18, 1));
        item5.agregarIngrediente(new Ingrediente(i19, 1));
        cat2.agregarItem(item5);
        fachada.agregarItem(item5);

        Item item6 = new Item("Asado con chorizo", 1200, cat2, up1);
        item6.agregarIngrediente(new Ingrediente(i14, 1));
        item6.agregarIngrediente(new Ingrediente(i13, 1));
        cat2.agregarItem(item6);
        fachada.agregarItem(item6);

        
        // Tragos y bebidas
        Item item7 = new Item("Vodka con naranja", 520, cat4, up2);
        item7.agregarIngrediente(new Ingrediente(i20, 1));
        item7.agregarIngrediente(new Ingrediente(i21, 1));
        cat4.agregarItem(item7);
        fachada.agregarItem(item7);

        Item item8 = new Item("Cafe", 200, cat4, up2);
        item8.agregarIngrediente(new Ingrediente(i7, 1));
        cat4.agregarItem(item8);
        fachada.agregarItem(item8);

        Item item9 = new Item("Agua mineral", 150, cat4, up2);
        item9.agregarIngrediente(new Ingrediente(i8, 1));
        cat4.agregarItem(item9);
        fachada.agregarItem(item9);

        // Postres
        Item item10 = new Item("Chajá", 480, cat3, up1);
        item10.agregarIngrediente(new Ingrediente(i23, 1));
        item10.agregarIngrediente(new Ingrediente(i24, 1));
        item10.agregarIngrediente(new Ingrediente(i25, 1));
        cat3.agregarItem(item10);
        fachada.agregarItem(item10);

        Item item11 = new Item("Sikhye (Arroz dulce)", 390, cat3, up1);
        item11.agregarIngrediente(new Ingrediente(i26, 1));
        cat3.agregarItem(item11);
        fachada.agregarItem(item11);

        Item item12 = new Item("Tteok relleno de poroto rojo", 420, cat3, up1);
        item12.agregarIngrediente(new Ingrediente(i11, 1));
        item12.agregarIngrediente(new Ingrediente(i27, 1));
        cat3.agregarItem(item12);
        fachada.agregarItem(item12);

        Item item13 = new Item("Sushi", 500, cat1, up3);
        item13.agregarIngrediente(new Ingrediente(i5, 1));
        item13.agregarIngrediente(new Ingrediente(i9, 1));
        item13.agregarIngrediente(new Ingrediente(i10, 1));
        cat1.agregarItem(item13);
        fachada.agregarItem(item13);
        
       // Servicios
        Servicio s1 = new Servicio(c1);
        Servicio s2 = new Servicio(c2);

        //fachada.agregarServicioACliente();
      
        // fachada.agregarPedidoAServicio(int numeroDeCliente, Pedido p, Servicio s);
      
        
    }
    
    public static void test(){
        Fachada fachada = Fachada.getInstancia();

        // Verificar cantidad de clientes
        System.out.println("Cantidad de clientes: " + fachada.getClientes().size()); // Esperado: 4

        // Verificar datos de un cliente específico
        Cliente cliente0 = fachada.getClientes().get(0);
        System.out.println("Cliente 0: " + cliente0.getNombreCompleto()); // Esperado: Jordi
        System.out.println("Tipo de Cliente 0: " + cliente0.getTipoCliente().getClass().getSimpleName()); // Esperado: Comun

        // Verificar unidades procesadoras
        System.out.println("Cantidad de unidades procesadoras: " + fachada.getUnidadesProcesadoras().size()); // Esperado: 3

        UnidadProcesadora cocina = fachada.getUnidadesProcesadoras().get(0);
        System.out.println("Primera unidad procesadora: " + cocina.getNombre()); // Esperado: Cocina

        // Verificar gestores
        System.out.println("Cantidad de gestores: " + fachada.getGestores().size()); // Esperado: 5

        // Verificar categorías
        System.out.println("Cantidad de categorías: " + fachada.getCategorias().size()); // Esperado: 4

        // Verificar insumos
        System.out.println("Cantidad de insumos: " + fachada.getInsumos().size()); // Esperado: 10

        // Verificar ítems
        System.out.println("Cantidad de ítems: " + fachada.getItems().size()); // Esperado: 3

    }
}
