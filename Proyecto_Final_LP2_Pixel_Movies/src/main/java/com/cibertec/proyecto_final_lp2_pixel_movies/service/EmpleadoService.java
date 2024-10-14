package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Empleados;

import java.util.List;

public interface EmpleadoService {
    List<Empleados> listarEmpleados();
    void guardarEmpleado(Empleados empleado);
    void borrarEmpleado(Integer id);
    Empleados buscarEmpleado(Integer id);
}
