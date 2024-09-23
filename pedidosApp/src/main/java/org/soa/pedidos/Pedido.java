package org.soa.pedidos;

public class Pedido {
    private Carrito carrito;

    public Pedido(Carrito carrito) {
        this.carrito = carrito;
    }

    public void confirmarPedido() {
        System.out.println("Pedido confirmado.");
        carrito.mostrarCarrito();
        // Aquí podrías agregar más lógica como notificar al cliente o registrar en base de datos.
    }

    public void cancelarPedido() {
        System.out.println("Pedido cancelado.");
        carrito.vaciarCarrito();
    }

}

