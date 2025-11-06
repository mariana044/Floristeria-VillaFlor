package com.ProyectoFlor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ProyectoFlor.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreoAndContrasena(String correo, String contrasena);
    boolean existsByCorreo(String correo);
}
