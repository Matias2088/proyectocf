

package org.example;

import java.util.Scanner;

public class VentaYGestionDeStock {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Inventario inventario = new Inventario();

        inventario.agregarProducto(new Producto("Chicles","001", 150.0,100));
        inventario.agregarProducto(new Producto("Alfajor", "002",650, 100));
        inventario.agregarProducto(new Producto( "Lays", "003", 1600, 68));

        boolean continuar = true;
        while (continuar){
            System.out.println("Seleccione una opcion");
            System.out.println("1. Mostrar Inventario");
            System.out.println("2. Realzar venta");
            System.out.println("3. Salir");
            int opcion = scan.nextInt();

            switch (opcion){
                case 1:
                    inventario.mostrarProductos();
                    break;
                case 2:
                    Venta venta = new Venta();
                    System.out.println("Ingrese el codigo del producto");
                    String codigo = scan.next();
                    Producto producto = inventario.buscarProductoPorCodigo(codigo);

                    if ( producto != null){
                        System.out.println("Ingrese la cantidad a vender: ");
                        int cantidad = scan.nextInt();
                        venta.agregarProducto(producto, cantidad);
                        venta.mostrarVenta();
                    }
                    else{
                        System.out.println("No se encuentra el producto");
                    }
                    break;
                case 3:
                    continuar = false;
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion invalida. ");
            }
        }
        scan.close();


    }

}