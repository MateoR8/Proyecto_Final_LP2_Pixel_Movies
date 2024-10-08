package com.cibertec.proyecto_final_lp2_pixel_movies.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTOS")
@Data
@Getter
@Setter
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;

    @Column(name = "NOMBRE_PRODUCTO", length = 100, nullable = false)
    private String nombreProducto;

    @Column(name = "PRECIO_PRODUCTO", scale = 2, nullable = false)
    private BigDecimal precioProducto;

    @Column(name = "MARCA_PRODUCTO", length = 30, nullable = false)
    private String marcaProducto;
}
