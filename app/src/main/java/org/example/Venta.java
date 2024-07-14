package org.example;


import java.util.ArrayList;

public class Venta {
    private ArrayList<Producto> productosVendidos;
    private double total;

    public Venta(){
        productosVendidos = new ArrayList<>();
        total = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad ){
        if (producto.getCantidad() >= cantidad){
            producto.reducirCantidad(cantidad);
            productosVendidos.add(new Producto(producto.getNombre(), producto.getCodigo(), producto.getPrecio(), cantidad));
            total += producto.getPrecio()* cantidad;
        }else {
            System.out.println("No hay suficiente stock del producto");
        }
    }

    public double getTotal(){
        return total;
    }

    public void mostrarVenta(){
        System.out.println("Productos vendidos: ");
        for (Producto producto : productosVendidos){
            System.out.println(" Codigo: " + producto.getCodigo()+"| Nombre: "+ producto.getNombre()+" | Precio: "+ producto.getPrecio() +"| Cantidad "+ producto.getCantidad());}
        System.out.println("Total: "+ total);
    }

}
