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
        opciones.add("0 Salir");
        opciones.add("1 Ingresar Cita");
        opciones.add("2 Eliminar Cita");
        opciones.add("3 Modificar Cita");
    }

    public void mostrarOpciones() {
        System.out.println("Seleccione el numero de la opcion que desee realizar: " + opciones);
    }

    public void escogerOpcion() {
        do {
            mostrarOpciones();
            Scanner input = new Scanner(System.in);
            eleccion = input.nextInt();
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
                        temp2 = 1;
                        System.out.println("Cita agendada");
                        break;
                    } else {
                        for (Cita cit : citas) {
                            if (!cit.getNumCedula().equals(temp1.getNumCedula()) && !cit.getFechaCompleta().equals(temp1.getFechaCompleta())) {
                                temp2 = 1;
                                break;
                            } else if (cit.getFechaCompleta().equals(temp1.getFechaCompleta()) && cit.getNumCedula().equals(temp1.getNumCedula())) {
                                temp2 = 1;
                                break;
                            } else if (cit.getNumCedula().equals(temp1.getNumCedula()) && !cit.getFechaCompleta().equals(temp1.getFechaCompleta())) {
                                temp2 = 1;
                                break;
                            } else {
                                System.out.println(cit.getNumCedula().equals(temp1.getNumCedula()) + "" + cit.getFechaCompleta().equals(temp1.getFechaCompleta()));
                                break;
                            }
                        }
                        if (temp2 == 0) {
                            System.out.println("fecha no disponible");
                            break;
                        } else {
                            citas.add(temp1);
                            System.out.println("Cita agendada");
                            break;
                        }
                    }
                case 2:
                    int temp3 = 0;
                    Cita temp4 = new Cita();
                    temp4.eliminar();
                    int temp5 = 0;
                    if (citas.isEmpty()) {
                        System.out.println("No existen citas");
                        break;
                    } else {
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
                        break;
                    }

                case 3:
                    int temp6 = 0;
                    while (temp6 == 0) {
                        Cita temp7 = new Cita();
                        temp7.actualizar();
                        for (Cita cit : citas) {
                            if (cit.getFechaCompleta().equals(temp7.getFechaCompleta())) {
                                String nuevaFecha;
                                Scanner inputNuevaFecha = new Scanner(System.in);
                                System.out.println("Ingrese nueva fecha y hora: ");
                                nuevaFecha = inputNuevaFecha.nextLine();
                                for (Cita cit2 : citas) {
                                    if (!cit2.getFechaCompleta().equals(nuevaFecha)) {
                                        temp6 = 1;
                                        break;
                                    }
                                }
                                if (temp6 == 1) {
                                    citas.add(temp7);
                                } else if (temp6 == 0) {
                                    System.out.println("Fecha no disponible");
                                }
                            }
                        }
                        if (temp6 == 0) {
                            System.out.println("cita no existente");
                        }
                    }
                default:
                    System.out.println("Esa no es una opcion valida");
                    break;
            }
        }while(eleccion!=0);
    }
}
