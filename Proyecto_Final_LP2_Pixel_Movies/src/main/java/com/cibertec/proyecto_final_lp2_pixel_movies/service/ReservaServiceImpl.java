package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Reservas;
import com.cibertec.proyecto_final_lp2_pixel_movies.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public List<Reservas> listarReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public void guardarReserva(Reservas reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public void borrarReserva(Integer id) {
        if(reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró la reserva con el id: " + id);
        }
    }

    @Override
    public Reservas buscarReserva(Integer id) {
        return reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la reserva con el id: " + id));
    }

    @Override
    public List<Reservas> buscarReservasPorMovie(Integer idPelicula) {
        return reservaRepository.findReservasByIdPeliculas(idPelicula);
    }
}
