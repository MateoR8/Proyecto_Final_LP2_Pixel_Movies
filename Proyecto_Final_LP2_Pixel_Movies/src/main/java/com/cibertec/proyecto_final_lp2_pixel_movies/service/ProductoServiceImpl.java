package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Productos;
import com.cibertec.proyecto_final_lp2_pixel_movies.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;

    @Override
    public List<Productos> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void guardarProducto(Productos producto) {
        productoRepository.save(producto);
    }

    @Override
    public Productos obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id).orElseThrow( ()->new RuntimeException("Producto no encontrado para el id: "+id) );
    }

    @Override
    public void eliminarProducto(Integer id) {
        if(productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        }else {
            throw new RuntimeException("Producto no encontrado para el id: "+id);
        }
    }
}