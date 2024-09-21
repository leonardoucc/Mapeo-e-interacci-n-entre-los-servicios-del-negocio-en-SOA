package org.soa.repositories;

import org.soa.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Consulta que me devuelven todos los usuarios que coincidan con el correo ingreasado
    @Query(value = "SELECT * FROM usuario WHERE correo_usuario = :email LIMIT 1", nativeQuery = true)
    Usuario findByEmail(@Param("email") String email);
}
