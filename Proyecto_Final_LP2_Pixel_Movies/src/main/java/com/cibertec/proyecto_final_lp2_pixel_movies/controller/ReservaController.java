package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Reservas;
import com.cibertec.proyecto_final_lp2_pixel_movies.service.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
@AllArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping("/listarReservas")
    public String listarReservas(Model model) {
        model.addAttribute("listaReservas", reservaService.listarReservas());
        return "reservas/reservas";
    }

    @GetMapping("/nuevaReserva")
    public String nuevaReserva(Model model) {
        model.addAttribute("reserva", new Reservas());
        return "reservas/nuevaReserva";
    }

    @PostMapping("/guardarReserva")
    public String guardarReserva(@ModelAttribute("reserva") Reservas reserva) {
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas/listarReservas";
    }

    @GetMapping("/actualizarReserva/{id}")
    public String actualizarReserva(@PathVariable ("id") Integer id, Model model) {
        model.addAttribute("reserva", reservaService.buscarReserva(id));
        return "reservas/actualizarReserva";
    }

    @GetMapping("/eliminarReserva/{id}")
    public String eliminarReserva(@PathVariable ("id") Integer id) {
        reservaService.borrarReserva(id);
        return "redirect:/reservas/listarReservas";
    }
}
