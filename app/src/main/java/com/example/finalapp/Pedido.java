package com.example.finalapp;

import java.io.Serializable;

public class Pedido implements Serializable {
    private int id;
    private long telefono;
    private float total;
    private String nombre, domicilio, metodo_pago;

    public Pedido(int id, long telefono, float total, String nombre, String domicilio, String metodo_pago) {
        this.id = id;
        this.telefono = telefono;
        this.total = total;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.metodo_pago = metodo_pago;
    }

    public Pedido(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
}
