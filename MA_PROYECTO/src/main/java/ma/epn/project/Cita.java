package main.java.ma.epn.project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Cita {
    private String fechaCompleta;
    private String numCedula;

    public ArrayList<Cita> reservar(ArrayList<Cita> citas){
        Scanner inputfechaCompleta = new Scanner(System.in);
        System.out.println("Ingresar la fecha completa: ");
        System.out.println("(dd/MM/yyyy hh:mm)");
        this.fechaCompleta = inputfechaCompleta.nextLine();
        Scanner inputNumCedula = new Scanner(System.in);
        System.out.println("Ingresar numero de cedula: ");
        this.numCedula = inputNumCedula.nextLine();
        int temp2 = 0;
        Cita temp1 = new Cita();
        temp1.setFechaCompleta(fechaCompleta);
        temp1.setNumCedula(numCedula);
        if (citas.isEmpty()) {
            citas.add(temp1);
            System.out.println("Cita agendada");
            System.out.println(citas.toString());
            return citas;
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
                return citas;
            }else if (temp2 == 1) {
                citas.add(temp1);
                System.out.println("Cita agendada");
                System.out.println(citas.toString());
                return citas;
            }
            return citas;
        }
    }

    public ArrayList<Cita> eliminar(ArrayList<Cita> citas){
        Scanner inputfechaCompleta = new Scanner(System.in);
        System.out.println("Ingresar la fecha completa: ");
        System.out.println("(dd/MM/yyyy hh:mm)");
        this.fechaCompleta = inputfechaCompleta.nextLine();
        int temp3 = 0;
        Cita temp4 = new Cita();
        temp4.setFechaCompleta(fechaCompleta);
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
                return citas;
            }else if (confirmacion.equals("n")){
                System.out.println("cita no eliminada");
                return citas;
            }else{
                System.out.println("No es una opcion valida");
                return citas;
            }
        }
        if (temp3 == 0) {
            System.out.println("cita no existente");
            return citas;
        }
        return citas;
    }

    public ArrayList<Cita> actualizar(ArrayList<Cita> citas){
        Scanner inputfechaCompleta = new Scanner(System.in);
        System.out.println("Ingresar la fecha completa actual: ");
        System.out.println("(dd/MM/yyyy hh:mm)");
        this.fechaCompleta = inputfechaCompleta.nextLine();
        int temp6 = 0;
        Cita temp7 = new Cita();
        temp7.setFechaCompleta(fechaCompleta);
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
            return citas;
        } else if (temp6 == 2) {
            System.out.println("Fecha no disponible");
            return citas;
        }
        return citas;
    }

    public String getFechaCompleta() {
        return fechaCompleta;
    }

    public void setFechaCompleta(String fechaCompleta) {
        this.fechaCompleta = fechaCompleta;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fechaCompleta='" + fechaCompleta + '\'' +
                ", numCedula='" + numCedula + '\'' +
                '}';
    }
}
