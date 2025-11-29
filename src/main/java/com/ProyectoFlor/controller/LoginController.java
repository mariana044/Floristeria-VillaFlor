package com.ProyectoFlor.controller;

import com.ProyectoFlor.model.Usuario;
import com.ProyectoFlor.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(
            @RequestParam String correo,
            @RequestParam String contrasena,
            Model model,
            HttpSession session) {

        Usuario usuario = usuarioRepository.findByCorreo(correo);

        if (usuario == null) {
            model.addAttribute("error", "Usuario no encontrado");
            return "login";
        }

        if (!usuario.getContrasena().equals(contrasena)) {
            model.addAttribute("error", "Contraseña incorrecta");
            return "login";
        }

        session.setAttribute("usuario", usuario);

        if (usuario.getRol().equalsIgnoreCase("admin")) {
            return "redirect:/admin";
        }

        return "redirect:/";
    }
}
