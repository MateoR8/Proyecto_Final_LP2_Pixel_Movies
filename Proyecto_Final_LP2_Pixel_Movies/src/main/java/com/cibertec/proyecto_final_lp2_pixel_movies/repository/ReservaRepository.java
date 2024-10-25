package com.cibertec.proyecto_final_lp2_pixel_movies.repository;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reservas,Integer>{
    @Query(value = "SELECT * FROM Reservas WHERE ID_PELICULAS = :idPelicula", nativeQuery = true)
    List<Reservas> findReservasByIdPeliculas(Integer idPelicula);
}
