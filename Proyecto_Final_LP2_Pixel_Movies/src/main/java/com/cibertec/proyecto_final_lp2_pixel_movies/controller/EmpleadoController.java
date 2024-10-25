package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Empleados;
import com.cibertec.proyecto_final_lp2_pixel_movies.service.EmpleadoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Empleados")
@RequiredArgsConstructor
@SessionAttributes("admin")

public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping("/listarEmpleados")
    public String listarEmpleados(Model model) {
        model.addAttribute("listaEmpleados", empleadoService.listarEmpleados());
        return "Empleados/empleados";
    }

    @GetMapping("/nuevoEmpleado")
    public String nuevoEmpleado(Model model) {
        model.addAttribute("empleado", new Empleados());
        return "Empleados/nuevoEmpleado";
    }

    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleados empleado) {
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/Empleados/listarEmpleados";
    }

    @GetMapping("/actualizarEmpleado/{id}")
    public String actualizarEmpleado(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("empleado", empleadoService.buscarEmpleado(id));
        return "Empleados/actualizarEmpleado";
    }

    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable("id") Integer id) {
        empleadoService.borrarEmpleado(id);
        return "redirect:/Empleados/listarEmpleados";
    }
}
