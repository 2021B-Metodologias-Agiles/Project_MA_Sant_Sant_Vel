package ec.edu.epn.proyecto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class ProductoParameterTest {

    private ArrayList<Producto> expected;
    private Producto productoViejo;
    private Producto nuevoProducto;

    @Parameterized.Parameters
    public static Iterable<Object[]>parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{new Producto("Shampoo XYZ", 20.00),new Producto("Cepillo ACME", 8.00),new ArrayList<Producto>(Arrays.asList(new Producto("Shampoo XYZ", 20.00), new Producto("Cepillo ACME", 8.00)))});
        objects.add(new Object[]{new Producto("Shampoo XYZ", 20.00),new Producto("Acondicionador Pentane", 37.45),new ArrayList<Producto>(Arrays.asList(new Producto("Shampoo XYZ", 20.00), new Producto("Acondicionador Pentane", 37.45)))});
        objects.add(new Object[]{new Producto("Shampoo XYZ", 20.00),new Producto("Comida Chow Dog", 28.50),new ArrayList<Producto>(Arrays.asList(new Producto("Shampoo XYZ", 20.00), new Producto("Comida Chow Dog", 28.50)))});
        objects.add(new Object[]{new Producto("Shampoo XYZ", 20.00),new Producto("Shampoo Dedal", 129.99),new ArrayList<Producto>(Arrays.asList(new Producto("Shampoo XYZ", 20.00), new Producto("Shampoo Dedal", 129.99)))});
        objects.add(new Object[]{new Producto("Shampoo XYZ", 20.00),new Producto("Shampoo Sevitel", 23.45),new ArrayList<Producto>(Arrays.asList(new Producto("Shampoo XYZ", 20.00), new Producto("Shampoo Sevitel", 23.45)))});
        return objects;
    }

    public ProductoParameterTest(Producto productoViejo, Producto nuevoProducto, ArrayList<Producto> expected){
        this.productoViejo = productoViejo;
        this.nuevoProducto = nuevoProducto;
        this.expected = expected;
    }

    @Test
    public void given_product_when_unique_product_then_create(){
        ArrayList<Producto> actual = new ArrayList<>();
        Producto.crear(actual, productoViejo);
        Producto.crear(actual, nuevoProducto);

        assertEquals(expected.toString(), actual.toString());
    }
}