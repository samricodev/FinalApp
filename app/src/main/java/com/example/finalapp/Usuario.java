package com.example.finalapp;

public class Usuario {

    private String nombre, apellido, correo, passwd;
    private int telefono;

    public Usuario(String nombre, String passwd) {
        this.nombre = nombre;
        this.apellido = "apellido";
        this.correo = "correo";
        this.passwd = passwd;
        this.telefono = 33333333;
    }

    public Usuario(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
