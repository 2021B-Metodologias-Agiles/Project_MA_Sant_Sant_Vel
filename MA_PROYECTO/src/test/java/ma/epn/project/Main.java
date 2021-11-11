package test.java.ma.epn.project;

import main.java.ma.epn.project.LoginP;
import main.java.ma.epn.project.Menu;
import main.java.ma.epn.project.Usuario;

import java.sql.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        LoginP loginP = new LoginP();
        loginP.setUsuarios(usuarios());
        loginP.completarLogin();
        Menu menu = new Menu(loginP.getUsuarioLogeado());
        menu.escogerOpcion();
        /*
        Usuario temp1 = new Usuario();


        if(temp1.verificarDatos(loginP)==true){

            System.out.println(menu.getEleccion());
        }*/

    }
    static ArrayList<Usuario> usuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1;
        usuario1 = new Usuario("pepito100", "contrasena", "Jose", "Paredes","Asistente");
        Usuario usuario2;
        usuario2 = new Usuario("pepito100", "contrasena", "Jose", "Paredes","Asistente");
        Usuario usuario3;
        usuario3 = new Usuario("pepito100", "contrasena", "Jose", "Paredes","Asistente");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
    }
}
