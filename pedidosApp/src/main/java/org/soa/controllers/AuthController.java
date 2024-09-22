package org.soa.controllers;

import org.soa.models.Usuario;
import org.soa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody Usuario user) {
        // Verificar si el usuario ya existe
        if (userService.userExists(user.getCorreoUsuario())) {
            // Devolver un estado 409 Conflict si el usuario ya existe
            return ResponseEntity.status(409).body("El usuario ya existe");
        }

        // Registrar el usuario
        Usuario newUser = userService.registerUser(user);

        if (newUser != null) {
            // Si el registro fue exitoso
            return ResponseEntity.ok("Registro exitoso. Por favor, inicia sesión.");
        } else {
            // Si hubo un error en el registro, devolver un estado 400 Bad Request
            return ResponseEntity.status(400).body("Error en el registro");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario loginRequest, HttpSession session) {
        Usuario user = userService.loginUser(loginRequest.getCorreoUsuario(), loginRequest.getPassword());

        if (user != null) {
            // Guardar el usuario en la sesión
            session.setAttribute("user", user);
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        // Invalidar la sesión al cerrar sesión
        session.invalidate();
        return ResponseEntity.ok("Sesión cerrada");
    }
}
