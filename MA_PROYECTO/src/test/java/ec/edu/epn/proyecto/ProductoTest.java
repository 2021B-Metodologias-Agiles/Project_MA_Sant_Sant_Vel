package ec.edu.epn.proyecto;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ProductoTest {

    @Test
    public void given_product_when_no_products_then_create(){
        Producto nuevoProducto = new Producto("Shampoo", 20.00);
        ArrayList<Producto> productos = new ArrayList<>();
        productos = Producto.crear(productos, nuevoProducto);

        assertNotNull(productos);
    }

    @Test
    public void given_product_when_unique_product_then_create(){
        Producto productoViejo = new Producto("Shampoo XYZ", 20.00);
        Producto nuevoProducto = new Producto("Shampoo ABC", 25.00);
        ArrayList<Producto> actual = new ArrayList<>();
        ArrayList<Producto> expected = new ArrayList<>();

        actual = Producto.crear(actual, productoViejo);
        actual = Producto.crear(actual, nuevoProducto);

        expected.add(productoViejo);
        expected.add(nuevoProducto);

        assertEquals(expected, actual);
    }

    @Test
    public void given_product_when_product_exists_then_dont_create(){
        Producto productoViejo = new Producto("Shampoo XYZ", 20.00);
        Producto nuevoProducto1 = new Producto("Shampoo ABC", 25.00);
        Producto nuevoProducto2 = new Producto("Shampoo ABC", 5.00);
        ArrayList<Producto> actual = new ArrayList<>();
        ArrayList<Producto> expected = new ArrayList<>();

        actual = Producto.crear(actual, productoViejo);
        actual = Producto.crear(actual, nuevoProducto1);
        actual = Producto.crear(actual, nuevoProducto2);

        expected.add(productoViejo);
        expected.add(nuevoProducto1);

        assertEquals(expected, actual);
    }

    @Test
    public void given_product_when_product_exists_then_true(){
        Producto productoViejo = new Producto("Shampoo XYZ", 20.00);
        Producto nuevoProductoUno = new Producto("Shampoo ABC", 25.00);
        Producto nuevoProductoDos = new Producto("Shampoo ABC", 25.00);
        ArrayList<Producto> productos = new ArrayList<>();

        Producto.crear(productos, productoViejo);
        Producto.crear(productos, nuevoProductoUno);

        assertTrue(Producto.validarProductoExistente(productos, nuevoProductoDos));
    }
}