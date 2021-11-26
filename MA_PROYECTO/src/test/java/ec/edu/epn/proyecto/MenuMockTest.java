package ec.edu.epn.proyecto;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MenuMockTest {

    @Test
    public void given_array_and_boolean_when_validate_price_then_return_boolean(){
        Usuario gerente = new Usuario
                ("us1", "pas1", "Maria", "Caseres","Gerente");
        Menu miMenu = Mockito.mock(Menu.class);
        Mockito.when(miMenu.validarObtenerDatos(new String[]{"Cepillo","ABC","10.99"},true))
                .thenReturn( new String[]{"Cepillo","ABC","10.99"});
        Mockito.when(miMenu.validarObtenerDatos(new String[]{"Acondicionador","Pentane","37.452"},false))
                .thenReturn(new String[]{"Acondicionador","Pentane","37.45"});
        String[] expected1 = new String[]{"Cepillo","ABC","10.99"};
        String[] expected2 = new String[]{"Acondicionador","Pentane","37.45"};
        assertArrayEquals(expected1,miMenu
                .validarObtenerDatos(new String[]{"Cepillo","ABC","10.99"},true));
        assertArrayEquals(expected2,miMenu
                .validarObtenerDatos(new String[]{"Acondicionador","Pentane","37.452"},false));
    }
}