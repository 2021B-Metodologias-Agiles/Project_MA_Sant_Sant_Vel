package ec.edu.epn.proyecto;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class iPresupuestoMockTest {

    @Test
    public void given_two_double_when_subtraction_then_return_double(){
        IPresupuesto presupuesto = Mockito.mock(IPresupuesto.class);
        double expected = 989.01;
        Mockito.when(presupuesto.getPresupuesto()).thenReturn(expected);
        Producto actual = new Producto("Cepillo ABC",10.99);
        Mockito.when(presupuesto.restarPresupuesto(1000.00
                ,actual.getPrecio())).thenReturn(989.01);
        assertEquals(presupuesto.getPresupuesto()
                ,presupuesto.restarPresupuesto(1000.00,actual.getPrecio())
                ,989.01);
    }
}