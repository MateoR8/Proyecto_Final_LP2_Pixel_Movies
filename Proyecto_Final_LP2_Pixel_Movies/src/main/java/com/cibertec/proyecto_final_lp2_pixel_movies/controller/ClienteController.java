package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Cliente;

import com.cibertec.proyecto_final_lp2_pixel_movies.service.ClienteService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Clientes")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/listarClientes")
    public String listarClientes(Model model) {
        model.addAttribute("listaClientes", clienteService.listarClientes());
        return "Clientes/clientes";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Clientes/nuevoCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/Clientes/listarClientes";
    }

    @GetMapping("/actualizarCliente/{id}")
    public String actualizarCliente(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cliente", clienteService.buscarCliente(id));
        return "Clientes/actualizarCliente";
    }

    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id) {
        clienteService.borrarCliente(id);
        return "redirect:/Clientes/listarClientes";
    }
}
