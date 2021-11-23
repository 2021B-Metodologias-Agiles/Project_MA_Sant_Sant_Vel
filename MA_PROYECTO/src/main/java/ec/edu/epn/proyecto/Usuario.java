package ec.edu.epn.proyecto;

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
