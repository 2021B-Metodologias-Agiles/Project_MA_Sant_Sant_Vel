package main.java.ma.epn.project;

import java.util.Scanner;

public class Cita {
    private String fechaCompleta;
    private String numCedula;

    public void reservar(){
        Scanner inputfechaCompleta = new Scanner(System.in);
        System.out.println("Ingresar la fecha completa: ");
        System.out.println("(dd/MM/yyyy hh:mm)");
        this.fechaCompleta = inputfechaCompleta.nextLine();
        Scanner inputNumCedula = new Scanner(System.in);
        System.out.println("Ingresar numero de cedula: ");
        this.numCedula = inputNumCedula.nextLine();
    }
    public void eliminar(){
        Scanner inputfechaCompleta = new Scanner(System.in);
        System.out.println("Ingresar la fecha completa: ");
        System.out.println("(dd/MM/yyyy hh:mm)");
        this.fechaCompleta = inputfechaCompleta.nextLine();
    }
    public void actualizar(){
        Scanner inputfechaCompleta = new Scanner(System.in);
        System.out.println("Ingresar la fecha completa actual: ");
        System.out.println("(dd/MM/yyyy hh:mm)");
        this.fechaCompleta = inputfechaCompleta.nextLine();
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
}
