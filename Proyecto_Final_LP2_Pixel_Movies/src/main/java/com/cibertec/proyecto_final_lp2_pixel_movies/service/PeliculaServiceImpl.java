package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Peliculas;
import com.cibertec.proyecto_final_lp2_pixel_movies.repository.PeliculaRepository;
import com.cibertec.proyecto_final_lp2_pixel_movies.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository peliculaRepository;

    @Override
    public List<Peliculas> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public void guardarPelicula(Peliculas pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public void borrarPelicula(Integer id) {

        if(peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró la película con el id: " + id);
        }
    }

    @Override
    public Peliculas buscarPelicula(Integer id) {
        return peliculaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la película con el id: " + id));
    }

    @Override
    public List<Peliculas> listarPeliculasPorIdioma(String idiomaPelicula) {
        return peliculaRepository.findPeliculasByIdiomaPelicula(idiomaPelicula);
    }
}
