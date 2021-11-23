package ec.edu.epn.proyecto;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public ArrayList<String> opciones = new ArrayList<>();
    private final Usuario usuario;
    private ArrayList<Cita> citas = new ArrayList<>();
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

    public void mostrarOpciones() {
        String tipoUsuario = this.usuario.getTipo();
        switch (tipoUsuario) {
            case "Gerente":
                System.out.println("Próximamente Gerente");
                System.exit(0);
                break;
            case "Peluquero":
                System.out.println("Próximamente Peluquero");
                System.exit(0);
                break;
            case "Asistente":
                if (opciones.isEmpty()) {
                    generarListaAsistente();
                }
                System.out.print(this);
                break;
            default:
                System.out.println("No es un tipo de usuario valido");
                System.exit(0);
                break;
            }
        }

    public void escogerOpcion() {
        do {
            mostrarOpciones();
            Scanner inputEleccion = new Scanner(System.in);
            try {
                eleccion = inputEleccion.nextInt();
            }catch (Exception e){
                System.out.println("Esa no es una opción valida");
                System.exit(0);
            }
            developOption();
        }while(eleccion!=0);
    }

    private void developOption() {
        //determina las acciones de la eleccion.
        switch (eleccion) {
            case 0:
                System.out.println("\n¡Muchas gracias por usar este programa!");
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

    @Override
    public String toString() {
        System.out.println("\tMenú Principal");
        for(String opcion: opciones){
            System.out.println(opcion);
        }
        return "Seleccione el número de la opción que desee realizar: ";
    }

}

