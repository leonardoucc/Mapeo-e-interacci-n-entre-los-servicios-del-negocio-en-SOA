package org.soa.pedidos;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getCantidad() >= cantidad) {
            producto.setCantidad(producto.getCantidad() - cantidad);
            productos.add(new Producto(producto.getNombre(), producto.getPrecio(), cantidad));
            System.out.println("Producto añadido al carrito: " + producto.getNombre());
        } else {
            System.out.println("No hay suficiente stock de " + producto.getNombre());
        }
    }

    public void mostrarCarrito() {
        System.out.println("Productos en el carrito:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }


    public void vaciarCarrito() {
        productos.clear();
        System.out.println("El carrito ha sido vaciado.");
    }
}

