package com.cibertec.proyecto_final_lp2_pixel_movies.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "PELICULAS")
@Data
@Getter
@Setter
public class Peliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PELICULAS")
    private Integer idPelicula;

    @Column(name = "NOMBRE_PELICULA", length = 50, nullable = false)
    private String nombrePelicula;

    @Column(name = "DIRECTOR_PELI", length = 50, nullable = false)
    private String directorPelicula;

    @Column(name = "GENERO_PELI", length = 30, nullable = false)
    private String generoPelicula;

    @Column(name = "DURACION_PELI", nullable = false)
    private Time duracionPelicula;

    @Column(name = "IDIOMA_PELI", length = 30, nullable = false)
    private String idiomaPelicula;

    @Column(name = "CLASIFICACION_PELI", length = 50, nullable = false)
    private String ClasificacionPelicula;


}
