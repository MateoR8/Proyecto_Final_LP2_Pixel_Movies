package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Administrador;
import com.cibertec.proyecto_final_lp2_pixel_movies.repository.AdministradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdministradorServiceImpl implements AdministradorService{

    private final AdministradorRepository administradorRepository;

    @Override
    public Administrador obtenerAdministrador(String nombreUsuario, String contrasenia) {
        return administradorRepository.findByNombreUsuarioAndContrasenia(nombreUsuario, contrasenia);
    }
}
