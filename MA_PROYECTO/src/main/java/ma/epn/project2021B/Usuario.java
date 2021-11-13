/*
Class diagram link:
https://lucid.app/lucidchart/a365ba40-b746-4b8f-bea4-647a4f56f84c/edit?viewport_loc=407%2C-68%2C2389%2C1075%2C0_0&invitationId=inv_82ade4c6-f5e7-400f-b2aa-a0b7def313e2
Authors:
Santacruz Cesar, Santamaria Lizbeth, Velastegui Daniel
*/
package main.java.ma.epn.project2021B;

public class Usuario {
    private final String username;
    private final String password;
    private final String nombre;
    private final String apellido;
    private final String tipo;

    public Usuario (String username, String password, String nombre, String apellido, String tipo) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTipo() {
        return tipo;
    }

}
