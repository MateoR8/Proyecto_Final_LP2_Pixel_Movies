package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Empleados;

import java.util.List;

public interface EmpleadoService {
    List<Reservas> listarEmpleados();
    void guardarEmpleado(Empleados empleado);
    void borrarEmpleado(Integer id);
    Reservas buscarEmpleado(Integer id);
}
