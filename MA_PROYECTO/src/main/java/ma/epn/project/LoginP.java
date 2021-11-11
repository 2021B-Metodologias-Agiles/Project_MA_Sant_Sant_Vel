package main.java.ma.epn.project;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginP {
    private String username;
    private String password;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioLogeado;

    public void obtenerLogin(){
        Scanner inputUsername = new Scanner(System.in);
        System.out.println("Ingresar usuario: ");
        username = inputUsername.nextLine();
        Scanner inputPassword = new Scanner(System.in);
        System.out.println("Ingresar contraseña: ");
        password = inputPassword.nextLine();
    }

    public void completarLogin(){
        obtenerLogin();
        int temp1 = 0;
        for(Usuario usr : usuarios){
            if(usr.getUsername().equals(getUsername()) && usr.getPassword().equals(getPassword())){
                usuarioLogeado = usr;
                temp1 = 1;
                break;
            }else{}
        }if(temp1 == 0){
            completarLogin();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
}
