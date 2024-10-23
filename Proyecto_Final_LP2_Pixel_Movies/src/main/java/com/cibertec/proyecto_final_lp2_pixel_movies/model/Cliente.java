package com.cibertec.proyecto_final_lp2_pixel_movies.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdMutability;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "CLIENTES")
@Data
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @Column(name = "DNI_CLIENTE", length = 20, nullable = false)
    private String dniCliente;

    @Column(name = "NOMBRES_CLIENTE", length = 100, nullable = false)
    private String nombresCliente;

    @Column(name = "APELLIDO_PAT_CLIENTE", length = 100, nullable = false)
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MAT_CLIENTE", length = 100, nullable = false)
    private String apellidoMaterno;

    @Column(name = "NUM_CELULAR_CLIENTE", length = 15, nullable = false)
    private String numCelular;

    @Column(name = "FECHA_NACIMIENTO_CLIENTE", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @Column(name = "CORREO_CLIENTE", length = 100, nullable = false)
    private String correo;

}
