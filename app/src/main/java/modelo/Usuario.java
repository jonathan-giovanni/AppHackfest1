package modelo;

/**
 * Created by admin on 18/11/17.
 */

public class Usuario {
    String id;
    String nombre;
    String pass;
    String telefono;

    public Usuario(String id, String nombre, String pass, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
