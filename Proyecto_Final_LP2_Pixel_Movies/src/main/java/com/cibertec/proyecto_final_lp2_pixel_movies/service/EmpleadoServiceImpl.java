package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Empleados;
import com.cibertec.proyecto_final_lp2_pixel_movies.repository.EmpleadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleados> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public void guardarEmpleado(Empleados empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void borrarEmpleado(Integer id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró empleado con el id: " + id);
        }
    }

    @Override
    public Empleados buscarEmpleado(Integer id) {
        return empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró empleado con el id: " + id));
    }
}