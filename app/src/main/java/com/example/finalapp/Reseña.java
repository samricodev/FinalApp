package com.example.finalapp;
public class Reseña {

    private String nombre, titulo, fecha, descripcion;
    private int calificacion;

    public Reseña(String nombre, String titulo, String fecha, String descripcion, int calificacion) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
    }

    public Reseña(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
