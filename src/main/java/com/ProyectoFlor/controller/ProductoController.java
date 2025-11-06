package com.ProyectoFlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ProyectoFlor.service.ProductoService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/catalogo")
    public String verCatalogo(@RequestParam(required = false) String ch, Model model) {
        if (ch != null && !ch.isEmpty()) {
            model.addAttribute("productos", productoService.buscarPorNombre(ch));
            model.addAttribute("busqueda", ch);
        } else {
            model.addAttribute("productos", productoService.listarTodos());
        }
        return "catalogo";
    }
}
