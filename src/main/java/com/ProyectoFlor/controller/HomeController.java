package com.ProyectoFlor.controller;

import com.ProyectoFlor.model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/index"})
    public String index(HttpSession session, Model model) {
        // Si hay un usuario en sesión, lo añadimos al modelo para que las vistas lo usen
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        }
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("HomeController: /login solicitado");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // quitamos /admin de aquí para evitar duplicados con AdminController
    // si alguna vista necesita un enlace directo, usen /admin (AdminController lo maneja)

    @GetMapping("/productos")
    public String productos() {
        return "productos";
    }
}
