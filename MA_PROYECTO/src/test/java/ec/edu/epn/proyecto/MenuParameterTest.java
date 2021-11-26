package ec.edu.epn.proyecto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class MenuParameterTest {

    private String[] a;
    @Parameterized.Parameters
    public static Iterable<Object[]>parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{ new String[]{"Cepillo","ABC","10.99"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC","199.45"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC","1.93"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC","1000.339"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC","10.999"}});
        return objects;
    }

    public MenuParameterTest(String[] a){
        this.a = a;
    }
    @Test
    public void given_price_data_when_create_product_then_price_bool(){
        Usuario gerente = new Usuario("us1", "pas1", "Maria", "Caseres","Gerente");
        Menu miMenu = new Menu(gerente);
        Boolean condition = miMenu.revisarPrecio(a);
        assertTrue(condition);
    }
}