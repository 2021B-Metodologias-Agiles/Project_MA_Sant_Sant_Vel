package main.java.ma.epn.project;

public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String tipo;

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
