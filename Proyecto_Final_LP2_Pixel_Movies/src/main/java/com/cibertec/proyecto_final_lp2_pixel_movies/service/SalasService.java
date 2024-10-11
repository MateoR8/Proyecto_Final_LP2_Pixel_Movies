package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Salas;

import java.util.List;

public interface SalasService{
    List<Salas> listarSalas();
    void guardarSalas(Salas salas);
    Salas obtenerSalas(Integer id);
    void eliminarSalas(Integer id);

}
