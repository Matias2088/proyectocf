package org.example;

public class Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private int cantidad;

    public Producto(String nombre, String codigo, double precio, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }



    public int getCantidad() {
        return cantidad;
    }



    public void agregarCantidad( int cantidad){
        this.cantidad += cantidad;
    }

    public void reducirCantidad( int cantidad){
        this.cantidad -= cantidad;
    }
}
