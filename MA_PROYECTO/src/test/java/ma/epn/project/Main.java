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
    }
    static ArrayList<Usuario> usuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1;
        usuario1 = new Usuario("us1", "pas1", "Maria", "Caseres","Gerente");
        Usuario usuario2;
        usuario2 = new Usuario("us2", "pas2", "Juan", "Paredes","Peluquero");
        Usuario usuario3;
        usuario3 = new Usuario("us3", "pas3", "Jose", "Smith","Asistente");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
    }
}
