package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Productos;

import java.util.List;

public interface ProductoService {
    List<Productos> listarProductos();
    void guardarProducto(Productos producto);
    Productos obtenerProductoPorId(Integer id);
    void eliminarProducto(Integer id);
}