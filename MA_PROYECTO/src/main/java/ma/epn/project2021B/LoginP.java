/*
Class diagram link:
https://lucid.app/lucidchart/a365ba40-b746-4b8f-bea4-647a4f56f84c/edit?viewport_loc=407%2C-68%2C2389%2C1075%2C0_0&invitationId=inv_82ade4c6-f5e7-400f-b2aa-a0b7def313e2
*/
package main.java.ma.epn.project2021B;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginP {
    private String username;
    private String password;
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioLogeado;

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

    public String getPassword() {
        return password;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }
}
