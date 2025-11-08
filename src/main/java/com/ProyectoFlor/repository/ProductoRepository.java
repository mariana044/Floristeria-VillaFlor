package com.ProyectoFlor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ProyectoFlor.model.Producto;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Buscar productos cuyo nombre contenga el texto buscado (ignorando mayúsculas/minúsculas)
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    // Buscar productos por id de categoría
    List<Producto> findByCategoriaId(Long categoriaId);

    // Buscar productos por nombre y categoría
    List<Producto> findByNombreContainingIgnoreCaseAndCategoriaId(String nombre, Long categoriaId);
}
