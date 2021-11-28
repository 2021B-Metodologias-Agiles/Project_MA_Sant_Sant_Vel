package ec.edu.epn.proyecto;

import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 0;
    }

    public static ArrayList<Producto> crear(ArrayList<Producto> productos, Producto producto){
        boolean esProductoExistente = false;
        if(productos.isEmpty()){
            productos.add(producto);
            System.out.println("Producto creado");
            System.out.println(producto.toString());
        }else{
            if(validarProductoExistente(productos, producto)){
                System.out.println("Ya existe un producto con este nombre");
                esProductoExistente = true;
            }
            if(!esProductoExistente){
                productos.add(producto);
                System.out.println("Producto creado");
                System.out.println(producto.toString());
            }
        }
        return productos;
    }

    public static boolean validarProductoExistente(ArrayList<Producto> productos, Producto producto){
        for (Producto productoExistente : productos) {
            if(producto.getNombre().equalsIgnoreCase(productoExistente.getNombre())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Producto: {" +
                "nombre= " + nombre  +
                ", precio= " + precio +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
