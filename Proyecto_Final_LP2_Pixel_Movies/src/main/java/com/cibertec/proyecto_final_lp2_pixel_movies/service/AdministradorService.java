package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Administrador;

public interface AdministradorService {
    Administrador obtenerAdministrador(String nombreUsuario, String contrasenia);
}
