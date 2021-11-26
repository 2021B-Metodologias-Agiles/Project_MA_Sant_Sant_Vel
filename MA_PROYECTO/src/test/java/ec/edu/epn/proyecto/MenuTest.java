package ec.edu.epn.proyecto;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void given_user_when_manager_then_manager_options(){
        Usuario gerente = new Usuario("us1", "pas1", "Maria", "Caseres","Gerente");
        Menu miMenu = new Menu(gerente);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("0. Salir");
        expected.add("1. Crear producto");
        ArrayList<String> actual = miMenu.generarListaGerente();

        assertEquals(actual, expected);
    }

    @Test
    public void given_user_when_login_then_show_option(){
        Usuario gerente = new Usuario("us1", "pas1", "Maria", "Caseres","Gerente");
        Menu miMenu = new Menu(gerente);

        assertTrue(miMenu.mostrarOpciones());
    }

    @Test
    public void given_product_data_when_create_product_then_return_product(){
        Usuario gerente = new Usuario("us1", "pas1", "Maria", "Caseres","Gerente");
        Menu miMenu = new Menu(gerente);
        Producto expected = new Producto("Cepillo ABC",10.99);
        Producto actual = miMenu.obtenerProducto(new String[]{"Cepillo","ABC","10.99"});
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    public void given_price_data_when_create_product_then_price_bool(){
        Usuario gerente = new Usuario("us1", "pas1", "Maria", "Caseres","Gerente");
        Menu miMenu = new Menu(gerente);
        Boolean condition = miMenu.revisarPrecio(new String[]{"","","10.99"});
        assertTrue(condition);
    }

}