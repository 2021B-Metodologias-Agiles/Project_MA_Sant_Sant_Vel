/*
Class diagram link:
https://lucid.app/lucidchart/a365ba40-b746-4b8f-bea4-647a4f56f84c/edit?viewport_loc=407%2C-68%2C2389%2C1075%2C0_0&invitationId=inv_82ade4c6-f5e7-400f-b2aa-a0b7def313e2
*/
package main.java.ma.epn.project2021B;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cita {
    private String fechaCompleta;
    private String numCedula;

    public ArrayList<Cita> reservar(ArrayList<Cita> citas){

        while(true){
            Scanner inputfechaCompleta = new Scanner(System.in);
            System.out.print("Ingresar la fecha completa (dd/MM/yyyy hh:mm): ");
            this.fechaCompleta = inputfechaCompleta.nextLine();
            if(validarFechaCompleta(fechaCompleta)){
                break;
            }
            System.out.println("\nFecha inválida");
        }
        Scanner inputCI = new Scanner(System.in);
        int disponibilidad = -1;
        Cita citaTemp = new Cita();

        if (citas.isEmpty()) {
            System.out.print("Ingresar número de cédula del cliente: ");
            this.numCedula = inputCI.nextLine();
            citaTemp.setFechaCompleta(fechaCompleta);
            citaTemp.setNumCedula(numCedula);
            citas.add(citaTemp);
            System.out.println("\nCita agendada\n");
            System.out.println(citas);
        } else {
            for (Cita cita : citas) {
                if (cita.getFechaCompleta().equals(this.fechaCompleta)) {
                    disponibilidad = EstadoFecha.FECHA_OCUPADA.ordinal();
                    break;
                } else {
                    disponibilidad = EstadoFecha.FECHA_LIBRE.ordinal();
                }

            }
            if(disponibilidad == EstadoFecha.FECHA_OCUPADA.ordinal()){
                System.out.println("\nFecha no disponible\n");
                reservar(citas);
            }else {
                System.out.print("Ingresar número de cédula: ");
                this.numCedula = inputCI.nextLine();
                citaTemp.setFechaCompleta(fechaCompleta);
                citaTemp.setNumCedula(numCedula);
                citas.add(citaTemp);
                System.out.println("\nCita agendada\n");
                System.out.println(citas);
                return citas;
            }
        }
        return citas;
    }

    public ArrayList<Cita> eliminar(ArrayList<Cita> citas){
        Scanner inputfechaCompleta = new Scanner(System.in);
        System.out.print("Ingresar la fecha completa (dd/MM/yyyy hh:mm): ");
        this.fechaCompleta = inputfechaCompleta.nextLine();
        int existencia = -1;
        Cita citaTemp = new Cita();
        citaTemp.setFechaCompleta(fechaCompleta);
        int citaElegida = 0;
        String confirmacion;
        for (int i = 0; i <citas.size(); i++) {
            if (citas.get(i).getFechaCompleta().equals(citaTemp.getFechaCompleta())) {
                existencia = EstadoFecha.FECHA_OCUPADA.ordinal();
                citaElegida = i;
            }
        }
        if(existencia == EstadoFecha.FECHA_OCUPADA.ordinal()){
            Scanner inputConfirmacion = new Scanner(System.in);
            System.out.println("¿Está seguro que desea eliminar la cita?(s/n) ");
            confirmacion = inputConfirmacion.nextLine();
            if (confirmacion.equals("s") || confirmacion.equals("S") || confirmacion.equals("si") || confirmacion.equals("Si") || confirmacion.equals("SI")) {
                citas.remove(citaElegida);
                System.out.println("\nCita eliminada\n");
                return citas;
            }else if (confirmacion.equals("n") || confirmacion.equals("N") || confirmacion.equals("no") || confirmacion.equals("No") || confirmacion.equals("NO")){
                System.out.println("\nCita no eliminada\n");
                return citas;
            }else{
                System.out.println("No es una opción valida");
                return citas;
            }
        }
        if (existencia == -1) {
            System.out.println("\nCita no existente\n");
            eliminar(citas);
        }
        return citas;
    }

    public ArrayList<Cita> actualizar(ArrayList<Cita> citas){
        Scanner inputfechaCompleta = new Scanner(System.in);
        System.out.print("Ingresar la fecha completa actual (dd/MM/yyyy hh:mm): ");
        this.fechaCompleta = inputfechaCompleta.nextLine();
        int disponibilidad = -1;
        int existencia = -1;
        Cita citaTemp = new Cita();
        citaTemp.setFechaCompleta(fechaCompleta);
        int citaElegida = 0;
        for (int i = 0; i <citas.size(); i++) {
            if (citas.get(i).getFechaCompleta().equals(citaTemp.getFechaCompleta())) {
                existencia = EstadoFecha.FECHA_OCUPADA.ordinal();
                citaElegida = i;
                break;
            }
            else{
                existencia = EstadoFecha.FECHA_LIBRE.ordinal();
            }
        }
        if (existencia == EstadoFecha.FECHA_OCUPADA.ordinal()) {
            while(true){
                String nuevaFecha;
                while(true) {
                    Scanner inputNuevaFecha = new Scanner(System.in);
                    System.out.print("Ingrese nueva fecha y hora (dd/MM/yyyy hh:mm): ");
                    nuevaFecha = inputNuevaFecha.nextLine();
                    if(validarFechaCompleta(nuevaFecha)){
                        break;
                    }
                    System.out.println("\nFecha inválida");
                }
                String numCedula = citas.get(citaElegida).getNumCedula();
                citaTemp.setFechaCompleta(nuevaFecha);
                citaTemp.setNumCedula(numCedula);
                for (Cita cita : citas) {
                    if (cita.getFechaCompleta().equals(nuevaFecha)) {
                        disponibilidad = EstadoFecha.FECHA_OCUPADA.ordinal();
                        break;
                    } else {
                        disponibilidad = EstadoFecha.FECHA_LIBRE.ordinal();
                    }
                }
                if (disponibilidad == EstadoFecha.FECHA_LIBRE.ordinal()) {
                    citas.remove(citaElegida);
                    citas.add(citaTemp);
                    System.out.println("\nCita actualizada\n");
                    break;
                } else if (disponibilidad == EstadoFecha.FECHA_OCUPADA.ordinal()) {
                    System.out.println("\nFecha no disponible\n");
                }
            }
        }else if (existencia == EstadoFecha.FECHA_LIBRE.ordinal()){
            System.out.println("\nNo existen citas en esa fecha y hora\n");
            actualizar(citas);
        }

        return citas;
    }

    public boolean validarFechaCompleta(String fecha){
        Pattern pat = Pattern.compile("[0-3]{1,2}/[0-2]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}");
        Matcher mat = pat.matcher(fecha);
        return mat.matches();
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
        return "- " +
                "Fecha: " + fechaCompleta +
                ", cédula del cliente: " + numCedula + "\n";
    }
}

enum EstadoFecha{
    FECHA_LIBRE, FECHA_OCUPADA
}
