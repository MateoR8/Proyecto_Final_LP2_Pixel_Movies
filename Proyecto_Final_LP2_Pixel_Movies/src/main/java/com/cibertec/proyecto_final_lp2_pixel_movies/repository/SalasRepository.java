package com.cibertec.proyecto_final_lp2_pixel_movies.repository;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Salas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalasRepository extends JpaRepository<Salas,Integer> {
}
