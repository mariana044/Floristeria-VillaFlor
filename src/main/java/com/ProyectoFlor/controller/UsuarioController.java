package com.ProyectoFlor.controller;

import com.ProyectoFlor.model.Usuario;
import com.ProyectoFlor.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String guardarRegistro(@ModelAttribute Usuario usuario, Model model) {

        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            model.addAttribute("error", "El correo ya está registrado");
            return "registro";
        }

        // No seteamos rol, usamos el DEFAULT de la BD
        usuarioRepository.save(usuario);

        return "redirect:/login";
    }
}
