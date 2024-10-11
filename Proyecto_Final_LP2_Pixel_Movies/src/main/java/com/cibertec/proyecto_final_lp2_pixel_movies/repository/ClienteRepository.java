package com.cibertec.proyecto_final_lp2_pixel_movies.repository;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}