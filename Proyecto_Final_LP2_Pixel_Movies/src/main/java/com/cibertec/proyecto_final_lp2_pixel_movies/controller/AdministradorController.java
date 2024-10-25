package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Administrador;
import com.cibertec.proyecto_final_lp2_pixel_movies.service.AdministradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/acceso")
@RequiredArgsConstructor
@SessionAttributes("admin")
public class AdministradorController {

    private final AdministradorService administradorService;

    @GetMapping(value = "/login")
    public String inicioLogin() {
        return "acceso/login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("nombreUsuario") String nombreUsuario,
                        @RequestParam("contrasenia") String contrasenia,
                        Model model){
        Administrador administrador = administradorService.obtenerAdministrador(nombreUsuario, contrasenia);
        if(administrador ==null){
            model.addAttribute("error", "Invalido Usuario o Contraseña");
            return "redirect:/acceso/login?error=true";
        }
        model.addAttribute("admin", administrador);
        return "Principal";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "redirect:/acceso/login?logout=true";
    }
}