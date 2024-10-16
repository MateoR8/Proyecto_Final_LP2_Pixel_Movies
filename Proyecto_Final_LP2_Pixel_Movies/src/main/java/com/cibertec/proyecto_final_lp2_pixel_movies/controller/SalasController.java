package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Salas;
import com.cibertec.proyecto_final_lp2_pixel_movies.service.SalasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/salas")
@AllArgsConstructor
public class SalasController {
    private final SalasService salasService;

    @GetMapping("listarSalas")
    public String listarSalas(Model model) {
        model.addAttribute("listaSalas", salasService.listarSalas());
        return "salas/salas";
    }

    @GetMapping("/nuevaSala")
    public String nuevaSala(Model model) {
        model.addAttribute("sala", new Salas());
        return "salas/nuevaSala";
    }

    @PostMapping("/guardarSala")
    public String guardarSala(@ModelAttribute("sala") Salas sala) {
        salasService.guardarSalas(sala);
        return "redirect:/salas/listarSalas";
    }

    @GetMapping("/actualizarSala/{id}")
    public String actualizarSala(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sala", salasService.obtenerSalas(id));
        return "salas/actualizarSala";
    }

    @GetMapping("/eliminarSala/{id}")
    public String eliminarSala(@PathVariable("id") Integer id) {
        salasService.eliminarSalas(id);
        return "redirect:/salas/listarSalas";
    }

}
