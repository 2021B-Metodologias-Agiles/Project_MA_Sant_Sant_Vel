package ec.edu.epn.proyecto;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cita {
    private String fechaCompleta;
    private String numCedula;

    public Cita(){}

    public Cita (String fechaCompleta, String numCedula){
        this.fechaCompleta = fechaCompleta;
        this.numCedula = numCedula;
    }

    public ArrayList<Cita> reservar(ArrayList<Cita> citas){
        getFechaCorrecta();
        int disponibilidad = -1;
        if (citas.isEmpty()) {
            setCitaAgendada(citas);
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
                setCitaAgendada(citas);
                return citas;
            }
        }
        return citas;
    }

    private void getFechaCorrecta() {
        while(true){
            Scanner inputfechaCompleta = new Scanner(System.in);
            System.out.print("Ingresar la fecha completa (dd/MM/yyyy hh:mm): ");
            this.fechaCompleta = inputfechaCompleta.nextLine();
            if(validarFechaCompleta(fechaCompleta)){
                break;
            }
            System.out.println("\nFecha inválida");
        }
    }

    private void setCitaAgendada(ArrayList<Cita> citas) {
        Scanner inputCI = new Scanner(System.in);
        System.out.print("Ingresar número de cédula del cliente: ");
        this.numCedula = inputCI.nextLine();
        citas.add(new Cita(fechaCompleta, numCedula));
        System.out.println("\nCita agendada\n");
        System.out.println(citas);
    }

    public ArrayList<Cita> eliminar(ArrayList<Cita> citas){
        Scanner inputfechaCompleta = new Scanner(System.in);
        System.out.print("Ingresar la fecha completa (dd/MM/yyyy hh:mm): ");
        this.fechaCompleta = inputfechaCompleta.nextLine();
        int existencia = -1;
        int citaElegida = 0;
        for (int i = 0; i <citas.size(); i++) {
            if (citas.get(i).getFechaCompleta().equals(this.fechaCompleta)) {
                existencia = EstadoFecha.FECHA_OCUPADA.ordinal();
                citaElegida = i;
            }
        }
        if(existencia == EstadoFecha.FECHA_OCUPADA.ordinal()){
            if(solicitarConfimacion()){
                citas.remove(citaElegida);
                System.out.println("\nCita eliminada\n");
            }else{
                System.out.println("\nCita no eliminada\n");
            }
            return citas;
        }
        if (existencia == -1) {
            System.out.println("\nCita no existente\n");
            eliminar(citas);
        }
        return citas;
    }

    private boolean solicitarConfimacion() {
        String confirmacion;
        Scanner inputConfirmacion = new Scanner(System.in);
        System.out.println("¿Está seguro que desea eliminar la cita?(s/n) ");
        confirmacion = inputConfirmacion.nextLine();
        boolean esS = confirmacion.equalsIgnoreCase("s");
        boolean esSi = confirmacion.equalsIgnoreCase("Si");
        boolean esN = confirmacion.equalsIgnoreCase("n");
        boolean esNo = confirmacion.equalsIgnoreCase("No");
        if (esS || esSi) {
            return true;
        }else if (esN || esNo){
            return false;
        }else{
            System.out.println("No es una opción valida");
            return solicitarConfimacion();
        }
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
            setFechaActualizada(citas, disponibilidad, citaTemp, citaElegida);
        }else if (existencia == EstadoFecha.FECHA_LIBRE.ordinal()){
            System.out.println("\nNo existen citas en esa fecha y hora\n");
            actualizar(citas);
        }

        return citas;
    }

    private void setFechaActualizada(ArrayList<Cita> citas, int disponibilidad, Cita citaTemp, int citaElegida) {
        while(true) {
            String nuevaFecha;
            nuevaFecha = getNuevaFechaCorrecta();
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
    }

    private String getNuevaFechaCorrecta() {
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
        return nuevaFecha;
    }

    public boolean validarFechaCompleta(String fecha){
        Pattern pat = Pattern.compile("[0-9]{1,2}/[0-2]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}");
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

