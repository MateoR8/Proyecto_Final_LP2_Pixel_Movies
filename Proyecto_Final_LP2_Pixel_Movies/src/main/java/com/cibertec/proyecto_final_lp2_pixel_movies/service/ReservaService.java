package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Reservas;

import java.util.List;

public interface ReservaService {
    List<Reservas> listarReservas();
    void guardarReserva(Reservas reserva);
    void borrarReserva(Integer id);
    Reservas buscarReserva(Integer id);
}
