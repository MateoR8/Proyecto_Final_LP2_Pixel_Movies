package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Peliculas;
import com.cibertec.proyecto_final_lp2_pixel_movies.service.PeliculaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
@AllArgsConstructor
@SessionAttributes("admin")
public class PeliculaController {

    private final PeliculaService peliculaService;

    @GetMapping("/listarPeliculas")
    public String listarPeliculas(Model model) {
        model.addAttribute("listaPeliculas", peliculaService.listarPeliculas());
        return "peliculas/peliculas";
    }

    @GetMapping("/nuevaPelicula")
    public String nuevaPelicula(Model model) {
        model.addAttribute("pelicula", new Peliculas());
        return "peliculas/nuevaPelicula";
    }

    @PostMapping("/guardarPelicula")
    public String guardarPelicula(@ModelAttribute("pelicula") Peliculas pelicula) {
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/peliculas/listarPeliculas";
    }

    @GetMapping("/actualizarPelicula/{id}")
    public String actualizarPelicula(@PathVariable ("id") Integer id, Model model) {
        model.addAttribute("pelicula", peliculaService.buscarPelicula(id));
        return "peliculas/actualizarPelicula";
    }

    @GetMapping("/eliminarPelicula/{id}")
    public String eliminarPelicula(@PathVariable ("id") Integer id) {
        peliculaService.borrarPelicula(id);
        return "redirect:/peliculas/listarPeliculas";
    }

    @GetMapping("/filtro")
    public String filtro(Model model) {
        return "peliculas/filtroPeliculas";
    }

    @GetMapping("/listarPeliculasporIdioma")
    public String listarPeliculasporIdioma(@RequestParam("idiomaPelicula") String idiomaPelicula, Model model) {
        List<Peliculas> lista = peliculaService.listarPeliculasPorIdioma(idiomaPelicula);
        model.addAttribute("filtroPeliculas", lista);
        model.addAttribute("idiomaPelicula", idiomaPelicula);
        return "peliculas/filtroPeliculas";
    }


}
