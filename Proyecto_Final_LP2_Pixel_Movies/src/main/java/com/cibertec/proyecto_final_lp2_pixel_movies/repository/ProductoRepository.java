package com.cibertec.proyecto_final_lp2_pixel_movies.repository;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos,Integer> {
}