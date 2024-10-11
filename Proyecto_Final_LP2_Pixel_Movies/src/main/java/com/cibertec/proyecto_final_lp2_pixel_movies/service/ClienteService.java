package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> listarClientes();
    void guardarCliente(Cliente cliente);
    void borrarCliente(Integer id);
    Cliente buscarCliente(Integer id);
}