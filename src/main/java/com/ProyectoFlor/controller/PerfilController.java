package com.ProyectoFlor.controller;

import com.ProyectoFlor.model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    @GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        // Si no hay sesión → volver a login
        if (usuario == null) {
            return "redirect:/login";
        }

        // Enviar usuario a la vista
        model.addAttribute("usuario", usuario);

        return "perfil";
    }
}

