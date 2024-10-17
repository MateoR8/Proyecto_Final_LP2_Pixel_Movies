package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaginaPrincipalController {
    @GetMapping ("/paginaPrincipal")
    public String mostrarPaginaPrincipal() {
        // Retornamos el nombre del archivo HTML que Thymeleaf debe renderizar
        return "Principal"; // Este es el nombre del archivo HTML en la carpeta templates
    }
}
