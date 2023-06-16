package com.example.finalapp;

public class Platillo_Tierra extends Platillo {

    private String termino, elaboracion;

    public Platillo_Tierra(String nombre, String descripcion, char tipo, float precio, int cantidad, String termino, String elaboracion) {
        super(nombre, descripcion, tipo, precio, cantidad);
        this.termino = termino;
        this.elaboracion = elaboracion;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }
}
