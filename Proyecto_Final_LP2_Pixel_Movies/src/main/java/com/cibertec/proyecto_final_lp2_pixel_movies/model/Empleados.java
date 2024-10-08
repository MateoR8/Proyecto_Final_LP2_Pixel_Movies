package com.cibertec.proyecto_final_lp2_pixel_movies.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "EMPLEADOS")
@Data
@Getter
@Setter
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPLEADO")
    private Integer idEmpleado;

    @Column(name = "DNI_EMPLEADO", length = 20 , nullable = false)
    private String dniEmpleado;

    @Column(name = "NOMBRES_EMPLEADO", length = 100 , nullable = false)
    private String nombreEmpleado;

    @Column(name = "APELLIDO_PAT_EMPLEADO", length = 100 , nullable = false)
    private String apellidoPaternoEmpleado;

    @Column(name = "APELLIDO_MAT_EMPLEADO", length = 100 , nullable = false)
    private String apellidoMaternoEmpleado;

    @Column(name = "NUM_CELULAR_EMPLEADO", length = 15 , nullable = false)
    private String numeroCelularEmpleado;

    @Column(name = "FECH_NACIMIENTO_EMPLEADO", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimientoEmpleado;

    @Column(name = "CORREO_EMPLEADO", length = 100 , nullable = false)
    private String correoEmpleado;
}
