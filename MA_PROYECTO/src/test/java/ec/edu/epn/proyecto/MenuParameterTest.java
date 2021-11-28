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
        objects.add(new Object[]{ new String[]{"Cepillo","ABC3","10"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC2","199.4"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC4","1.93"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC5","1000.339"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC6","10.999"}});
        objects.add(new Object[]{ new String[]{"Cepillo","ABC7","124"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC8","199."}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC9","1.93"}});
        objects.add(new Object[]{new String[]{"Cepillo","ABC7","1000.4522"}});
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