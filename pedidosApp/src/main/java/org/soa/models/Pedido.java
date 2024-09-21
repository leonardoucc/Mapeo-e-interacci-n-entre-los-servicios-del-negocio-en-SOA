package org.soa.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "fecha_pedido")
    private Date fechaPedido;

    @Column(name = "total_pedido")
    private Date totalPedido;


    // Getters y Setters
    
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getTotal_pedido() {
        return totalPedido;
    }

    public void setTotal_pedido(Date totalPedido) {
        this.totalPedido = totalPedido;
    }
}
