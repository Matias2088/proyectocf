

package org.example;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VentaYGestionDeStock {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Inventario inventario = new Inventario();
        String archivo = "productos.txt";

        try {
            inventario.cargarProductos(archivo);
        } catch (IOException e) {
            System.out.println("No se pudo cargar el inventario desde el archivo.");
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Realizar venta");
            System.out.println("3. Agregar producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                int opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1:
                        inventario.mostrarProductos();
                        break;
                    case 2:
                        realizarVenta(reader, inventario);
                        break;
                    case 3:
                        agregarProducto(reader, inventario);
                        break;
                    case 4:
                        continuar = false;
                        System.out.println(" Hasta luego");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor intente de nuevo.");
            }
        }

        try {
            inventario.guardarProductos(archivo);
        } catch (IOException e) {
            System.out.println("No se pudo guardar el inventario en el archivo.");
        }
    }

    private static void realizarVenta(BufferedReader reader, Inventario inventario) throws IOException {
        Venta venta = new Venta();
        System.out.print("Ingrese el código del producto: ");
        String codigo = reader.readLine();
        Producto producto = inventario.buscarProductoPorCodigo(codigo);

        if (producto != null) {
            System.out.print("Ingrese la cantidad a vender: ");
            int cantidad = Integer.parseInt(reader.readLine());
            venta.agregarProducto(producto, cantidad);
            venta.mostrarVenta();
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void agregarProducto(BufferedReader reader, Inventario inventario) throws IOException {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = reader.readLine();
        System.out.print("Ingrese el código del producto: ");
        String codigo = reader.readLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(reader.readLine());
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = Integer.parseInt(reader.readLine());

        Producto nuevoProducto = new Producto(nombre, codigo, precio, cantidad);
        inventario.agregarProducto(nuevoProducto);
        System.out.println("Producto agregado exitosamente.");
    }
}



