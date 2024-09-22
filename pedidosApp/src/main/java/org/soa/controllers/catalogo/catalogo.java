package org.soa.controllers.catalogo;

import org.soa.models.Usuario; // Asegúrate de que tienes el modelo de Usuario importado
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.http.HttpSession;

@Controller
public class catalogo {

    @GetMapping("/catalogo")
    public String showCatalogo() {
        return "catalogo"; // Nombre de la vista catalogo.html
    }

    @GetMapping("/api/user")
    @ResponseBody
    public Usuario getUsuario(@SessionAttribute(name = "usuarioActivo", required = false) Usuario usuario, HttpSession session) {
        return (Usuario) session.getAttribute("user"); // Retorna el objeto Usuario
    }
}

