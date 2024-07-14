package org.example;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario(){
        productos = new ArrayList<>();
    }
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public Producto buscarProductoPorCodigo(String codigo){
        for (Producto producto : productos){
            if ( producto.getCodigo().equals(codigo)){
                return producto;
            }
        }
        return null;
    }

    public void mostrarProductos(){
        for(Producto producto : productos){
            System.out.println("Codigo: "+ producto.getCodigo()+ " \n Nombre: "+ producto.getNombre() + " \n Precio: " + producto.getPrecio()+ "\n Cantidad: "+ producto.getCantidad());
        }
    }


}
