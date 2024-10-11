package com.cibertec.proyecto_final_lp2_pixel_movies.repository;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Peliculas,Integer> {
}
