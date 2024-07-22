package org.example;

import java.io.*;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println("Código: " + producto.getCodigo() + " - Nombre: " + producto.getNombre() + " - Precio: " + producto.getPrecio() + " - Cantidad: " + producto.getCantidad());
        }
    }

    public void guardarProductos(String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Producto producto : productos) {
                writer.write(producto.getNombre() + "," + producto.getCodigo() + "," + producto.getPrecio() + "," + producto.getCantidad());
                writer.newLine();
            }
        }
    }

    public void cargarProductos(String archivo) throws IOException {
        productos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String nombre = partes[0];
                    String codigo = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    int cantidad = Integer.parseInt(partes[3]);
                    productos.add(new Producto(nombre, codigo, precio, cantidad));
                }
            }
        }
    }
}
