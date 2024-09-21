package org.soa.repositories;

import org.soa.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesPedidoRepository extends JpaRepository<Producto, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
