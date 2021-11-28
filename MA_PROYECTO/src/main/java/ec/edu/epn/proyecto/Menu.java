package ec.edu.epn.proyecto;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public ArrayList<String> opciones = new ArrayList<>();
    private final Usuario usuario;
    private ArrayList<Cita> citas = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private int eleccion;

    public Menu(Usuario usuario) {
        this.usuario = usuario;
    }

    public void generarListaAsistente(){
        opciones.add("0. Salir");
        opciones.add("1. Ingresar Cita");
        opciones.add("2. Eliminar Cita");
        opciones.add("3. Modificar Cita");
    }

    public ArrayList<String> generarListaGerente(){
        opciones.add("0. Salir");
        opciones.add("1. Crear producto");
        return opciones;
    }


    public boolean mostrarOpciones() {
        String tipoUsuario = this.usuario.getTipo();
        switch (tipoUsuario) {
            case "Gerente":
                if (opciones.isEmpty()) {
                    generarListaGerente();
                }
                System.out.print(this);
                break;
            case "Peluquero":
                System.out.println("Próximamente Peluquero");
                System.exit(0);
                return false;
            case "Asistente":
                if (opciones.isEmpty()) {
                    generarListaAsistente();
                }
                System.out.print(this);
                break;
            default:
                System.out.println("No es un tipo de usuario valido");
                System.exit(0);
                return false;
            }
            return true;
        }

    public void escogerOpcion() {
        do {
            if(mostrarOpciones()){
                Scanner inputEleccion = new Scanner(System.in);
                try {
                    eleccion = inputEleccion.nextInt();
                }catch (Exception e){
                    System.out.println("Esa no es una opción valida");
                    System.exit(0);
                }

                String tipoUsuario = this.usuario.getTipo();
                switch (tipoUsuario) {
                    case "Gerente":
                        desarrollarOpcionesGerente();
                        break;
                    case "Peluquero":
                        break;
                    case "Asistente":
                        desarrollarOpcionesAsistente();
                        break;
                    default:
                        System.out.println("No es un tipo de usuario valido");
                        System.exit(0);
                        break;
                }
            }
        }while(eleccion!=0);
    }

    private void desarrollarOpcionesGerente(){
        //determina las acciones de la eleccion.
        switch (eleccion) {
            case 0:
                System.out.println("\n¡Muchas gracias por usar este programa!");
                createDividers();
                System.exit(0);
            case 1:
                String[] datos = obtenerDatos();
                if(this.revisarPrecio(datos)) {
                    Producto nProducto = this.obtenerProducto(datos);
                    ArrayList<Producto> newProducts = Producto.crear(productos, nProducto);
                    productos = newProducts;
                }else{
                    System.out.println("El precio ingresado tiene errores.");
                    System.out.println("Producto no creado.");
                }
                break;
            default:
                System.out.println("Esa no es una opción valida");
                break;
        }
    }

    public String[] obtenerDatos(){
        Scanner inputTipoProducto = new Scanner(System.in);
        System.out.print("Ingresar el tipo de producto: ");
        String tipoProducto = inputTipoProducto.nextLine();
        Scanner inputDetalleProducto = new Scanner(System.in);
        System.out.print("Ingresar detalle del producto: ");
        String detalleProducto = inputDetalleProducto.nextLine();
        Scanner inputPrecioProducto = new Scanner(System.in);
        System.out.print("Ingresar el precio del producto: ");
        String precioProducto = inputPrecioProducto.nextLine();
        return new String[]{tipoProducto,detalleProducto,precioProducto};
    }

    public Producto obtenerProducto(String[] datos){
        String tipo = datos[0];
        String detalle = datos[1];
        double precio = Double.parseDouble(datos[2]);
        String nombre = tipo + " " + detalle;
        System.out.println(nombre);
        return new Producto(nombre,precio);
    }

    public String[] validarObtenerDatos(String[] datos, boolean isPriceValid){
        return new String[]{};
    }

    public boolean revisarPrecio(String[] datos){
        String precioS = datos[2];
        int length = precioS.length();
        double precio = 0.00;
        try {
            precio = Double.parseDouble(datos[2]);
        }catch (Exception e){
            System.out.println("El precio no debe contener caracteres alfabeticos");
            return false;
        }
        if(precioS.contains(".")) {
            int dotIndex = precioS.indexOf(".");
            if((length-(dotIndex+1))<=2){
                return !(precio < 0);
            }else{
                return false;
            }
        }else{
            return !(precio < 0);
        }
    }

    private void desarrollarOpcionesAsistente(){
        //determina las acciones de la eleccion.
        switch (eleccion) {
            case 0:
                System.out.println("\n¡Muchas gracias por usar este programa!");
                createDividers();
                System.exit(0);
            case 1:
                Cita temp1 = new Cita();
                citas = temp1.reservar(citas);
                break;
            case 2:
                if (citas.isEmpty()) {
                    System.out.println("No existen citas");
                } else {
                    Cita temp4 = new Cita();
                    citas = temp4.eliminar(citas);
                    break;
                }
                break;
            case 3:
                if (citas.isEmpty()) {
                    System.out.println("No existen citas");
                } else {
                    Cita temp7 = new Cita();
                    citas = temp7.actualizar(citas);
                    break;
                }
                break;
            default:
                System.out.println("Esa no es una opción valida");
                break;
        }
    }
    public void createDividers(){
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");
    }

    @Override
    public String toString() {
        createDividers();
        System.out.println("\t\t\t\t\tMenú Principal\n");
        for(String opcion: opciones){
            System.out.println(opcion);
        }
        return "Seleccione el número de la opción que desee realizar: ";
    }

}

