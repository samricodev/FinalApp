package com.example.finalapp;

public class Platillo_Mar extends Platillo{

    private String categoria;
    private boolean crudo;

    public Platillo_Mar(String nombre, String descripcion, char tipo, float precio, int cantidad, String categoria, boolean crudo) {
        super(nombre, descripcion, tipo, precio, cantidad);
        this.categoria = categoria;
        this.crudo = crudo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isCrudo() {
        return crudo;
    }

    public void setCrudo(boolean crudo) {
        this.crudo = crudo;
    }
}
