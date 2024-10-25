package com.cibertec.proyecto_final_lp2_pixel_movies.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admin_user")
@Data
@Getter
@Setter
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario", length = 200, nullable = false)
    private String nombreUsuario;

    @Column(name = "nombre_usuario_real", length = 200, nullable = false)
    private String nombreUsuarioReal;

    @Column(name = "contrasenia_usuario", length = 200, nullable = false)
    private String contrasenia;

}
