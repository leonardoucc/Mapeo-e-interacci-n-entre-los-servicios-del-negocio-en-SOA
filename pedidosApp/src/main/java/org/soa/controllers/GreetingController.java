package org.soa.controllers;

import org.soa.models.Usuario;
import org.soa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//ESTO ES SOLO UNA PRUEBA Y UN EJEMPLO

@RestController
public class GreetingController {

    Usuario usuario;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/greeting")
    public String greeting() {
        usuario = new Usuario();
        usuario.setCorreoUsuario("leonardo@gmail.com");
        usuario.setNombreUsuario("leo");
        usuario.setPassword("123");
        usuarioRepository.save(usuario);
        return "Hello, World!";
    }
}
