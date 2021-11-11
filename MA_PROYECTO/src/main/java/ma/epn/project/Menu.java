package main.java.ma.epn.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public ArrayList<String> opciones = new ArrayList<>();

    private Usuario usuario;
    private ArrayList<Cita> citas = new ArrayList<>();
    private int eleccion;

    public Menu(Usuario usuario) {
        this.usuario = usuario;
    }

    public void generarListaAsistente(){
        opciones.add("0 Salir");
        opciones.add("1 Ingresar Cita");
        opciones.add("2 Eliminar Cita");
        opciones.add("3 Modificar Cita");
    }

    public void mostrarOpciones() {
        String tipoUsuario = this.usuario.getTipo();
        switch (tipoUsuario){
            case "Gerente":
                System.out.println("Proximamente Gerente");
                System.exit(0);
                break;
            case "Peluquero":
                System.out.println("Proximamente Peluquero");
                System.exit(0);
                break;
            case "Asistente":
                if(opciones.isEmpty()){
                    generarListaAsistente();
                }
                System.out.println("Seleccione el numero de la opcion que desee realizar: " + opciones);
                break;
            default:
                System.out.println("No es un tipo de usuario valido");
                System.exit(0);
        }

    }

    public void escogerOpcion() {
        do {
            mostrarOpciones();
            Scanner inputEleccion = new Scanner(System.in);
            try {
                eleccion = inputEleccion.nextInt();
            }catch (Exception e){
                System.out.println("Esa no es una opcion valida");
                System.exit(0);
            }
            switch (eleccion) {
                case 0:
                    System.out.println("Muchas gracias por usar este programa");
                    System.exit(0);
                case 1:
                    int temp2 = 0;
                    Cita temp1 = new Cita();
                    temp1.reservar();
                    if (citas.isEmpty()) {
                        citas.add(temp1);
                        System.out.println("Cita agendada");
                        System.out.println(citas.toString());
                    } else {
                        for (int i = 0; i <citas.size(); i++) {
                            if(citas.get(i).getFechaCompleta().equals(temp1.getFechaCompleta())) {
                                temp2 = 2;
                                break;
                            } else {
                                temp2 = 1;
                            }

                        }
                        if(temp2 == 2){
                            System.out.println("fecha no disponible");
                        }else if (temp2 == 1) {
                            citas.add(temp1);
                            System.out.println("Cita agendada");
                            System.out.println(citas.toString());
                        }
                    }
                    break;
                case 2:
                    if (citas.isEmpty()) {
                        System.out.println("No existen citas");
                    } else {
                        int temp3 = 0;
                        Cita temp4 = new Cita();
                        temp4.eliminar();
                        int temp5 = 0;
                        String confirmacion = "n";
                        for (int i = 0; i <citas.size(); i++) {
                            if (citas.get(i).getFechaCompleta().equals(temp4.getFechaCompleta())) {
                                temp3 = 1;
                                temp5 = i;
                            }
                        }
                        if(temp3 == 1){
                            Scanner inputConfirmacion = new Scanner(System.in);
                            System.out.println("¿Está serguro que desea eliminar la cita?(s/n) ");
                            confirmacion = inputConfirmacion.nextLine();
                            if (confirmacion.equals("s")) {
                                citas.remove(temp5);
                                System.out.println("cita eliminada");
                                temp3 = 1;
                                break;
                            }else if (confirmacion.equals("n")){
                                System.out.println("cita no eliminada");
                                break;
                            }else{
                                System.out.println("No es una opcion valida");
                                break;
                            }
                        }
                        if (temp3 == 0) {
                            System.out.println("cita no existente");
                            break;
                        }
                    }
                    break;

                case 3:
                    if (citas.isEmpty()) {
                        System.out.println("No existen citas");
                    } else {
                        int temp6 = 0;
                        Cita temp7 = new Cita();
                        temp7.actualizar();
                        int temp8 = 0;
                        for (int i = 0; i <citas.size(); i++) {
                            if (citas.get(i).getFechaCompleta().equals(temp7.getFechaCompleta())) {
                                temp6 = 2;
                                temp8 = i;
                                break;
                            }
                            else{
                                temp6 = 1;
                            }
                        }
                        if (temp6 == 2) {
                            String nuevaFecha;
                            Scanner inputNuevaFecha = new Scanner(System.in);
                            System.out.println("Ingrese nueva fecha y hora: ");
                            nuevaFecha = inputNuevaFecha.nextLine();
                            String numCedula = citas.get(temp8).getNumCedula();
                            temp7.setFechaCompleta(nuevaFecha);
                            temp7.setNumCedula(numCedula);
                            for (int j = 0; j < citas.size(); j++) {
                                if (citas.get(j).getFechaCompleta().equals(nuevaFecha)) {
                                    temp6 = 2;
                                    break;
                                } else {
                                    temp6 = 3;
                                }
                            }
                        }
                        if (temp6 == 3) {
                            citas.remove(temp8);
                            citas.add(temp7);
                            System.out.println("Cita actualizada");
                        } else if (temp6 == 2) {
                            System.out.println("Fecha no disponible");
                        }
                    }
                    break;
                default:
                    System.out.println("Esa no es una opcion valida");
                    break;
            }
        }while(eleccion!=0);
    }
}
