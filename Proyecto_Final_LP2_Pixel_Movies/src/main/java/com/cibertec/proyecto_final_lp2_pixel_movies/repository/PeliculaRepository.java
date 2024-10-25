package com.cibertec.proyecto_final_lp2_pixel_movies.repository;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Peliculas,Integer> {
    @Query(value = "SELECT * FROM Peliculas WHERE IDIOMA_PELI = :idiomaPelicula", nativeQuery = true)
    List<Peliculas> findPeliculasByIdiomaPelicula(@Param("idiomaPelicula") String idiomaPelicula);
}
