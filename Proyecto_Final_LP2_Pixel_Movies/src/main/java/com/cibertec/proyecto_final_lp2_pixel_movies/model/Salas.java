package com.cibertec.proyecto_final_lp2_pixel_movies.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SALAS")
@Data
@Getter
@Setter
public class Salas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SALA")
    private Integer idSala;

    
    @Column(name = "COD_SALA", length = 7, nullable = false)
    private String codSala;

    @Column(name = "CAPACIDAD_SALA", nullable = false)
    private Integer CapacidadSala;
}
