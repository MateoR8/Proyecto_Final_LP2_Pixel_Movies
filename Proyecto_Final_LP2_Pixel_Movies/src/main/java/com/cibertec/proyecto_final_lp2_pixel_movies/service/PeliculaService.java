package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Peliculas;

import java.util.List;

public interface PeliculaService {

    List<Peliculas> listarPeliculas();
    void guardarPelicula(Peliculas pelicula);
    void borrarPelicula(Integer id);
    Peliculas buscarPelicula(Integer id);
}
