/*
Class diagram link:
https://lucid.app/lucidchart/a365ba40-b746-4b8f-bea4-647a4f56f84c/edit?viewport_loc=407%2C-68%2C2389%2C1075%2C0_0&invitationId=inv_82ade4c6-f5e7-400f-b2aa-a0b7def313e2
*/
package test.java.ma.epn.project2021B;

import main.java.ma.epn.project2021B.LoginP;
import main.java.ma.epn.project2021B.Menu;
import main.java.ma.epn.project2021B.Usuario;

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
