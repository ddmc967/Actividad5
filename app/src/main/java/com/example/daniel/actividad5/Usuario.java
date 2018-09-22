package com.example.daniel.actividad5;

public class Usuario {

    private String nombre;
    private String apellido;
    private String edad;
    private int foto;

    public Usuario(){

    }

    public Usuario(String nombre, String apellido, String edad, int foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() { return apellido;}

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {return edad;}

    public void setEdad (String edad) {this.edad = edad;}

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}