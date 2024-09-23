package org.soa.pedidos;

public class Main {
    public static void main(String[] args) {
        // Creación de algunos productos
        Producto p1 = new Producto("Manzana", 0.5, 100);
        Producto p2 = new Producto("Pan", 1.0, 50);

        // Crear el carrito
        Carrito carrito = new Carrito();

        // Agregar productos al carrito
        carrito.agregarProducto(p1, 5);
        carrito.agregarProducto(p2, 3);

        // Mostrar el carrito
        carrito.mostrarCarrito();

        // Crear un pedido
        Pedido pedido = new Pedido(carrito);

        // Confirmar o cancelar el pedido
        pedido.confirmarPedido();
        // pedido.cancelarPedido();
    }
}

