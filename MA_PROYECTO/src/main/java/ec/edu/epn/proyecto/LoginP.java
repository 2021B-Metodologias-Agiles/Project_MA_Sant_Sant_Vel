package ec.edu.epn.proyecto;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginP {
    private String username;
    private String password;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioActual;

    public void obtenerLogin(){
        Scanner inputUsername = new Scanner(System.in);
        System.out.print("Ingresar usuario: ");
        username = inputUsername.nextLine();
        Scanner inputPassword = new Scanner(System.in);
        System.out.print("Ingresar contraseña: ");
        password = inputPassword.nextLine();
    }

    public void completarLogin(){
        obtenerLogin();
        int temp1 = 0;
        for(Usuario usr : usuarios){
            if(usr.getUsername().equals(getUsername()) && usr.getPassword().equals(getPassword())){
                usuarioActual = usr;
                temp1 = 1;
                break;
            }
        }if(temp1 == 0){
            completarLogin();
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
}
