package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Productos;
import com.cibertec.proyecto_final_lp2_pixel_movies.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
@RequiredArgsConstructor
@SessionAttributes("admin")

public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/listarProductos")
    public String verPaginaInicio(Model model) {
        model.addAttribute("listarProductos", productoService.listarProductos());
        return "productos/productos";
    }

    @GetMapping("/nuevoProducto")
    public String nuevoEmpleado(Model model) {
        model.addAttribute("producto", new Productos());
        return "productos/nuevoProducto";
    }

    @PostMapping("/guardarProducto")
    public String guardarEmpleado(@ModelAttribute("producto") Productos producto) {
        productoService.guardarProducto(producto);
        return "redirect:/productos/listarProductos";
    }

    @GetMapping("/actualizarProducto/{id}")
    public String actualizarEmpleado(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("producto", productoService.obtenerProductoPorId(id));
        return "productos/actualizarProducto";
    }

    @GetMapping("/eliminarProducto/{id}")
    public String eliminarEmpleado(@PathVariable("id") Integer id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos/listarProductos";
    }
}

