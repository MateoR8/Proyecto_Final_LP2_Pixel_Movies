package com.cibertec.proyecto_final_lp2_pixel_movies.service;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Salas;
import com.cibertec.proyecto_final_lp2_pixel_movies.repository.SalasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalasServiceImpl implements SalasService {

    private final SalasRepository salasRepository;

    @Override
    public List<Salas> listarSalas() {return salasRepository.findAll(); }

    @Override
    public void guardarSalas(Salas salas) { salasRepository.save(salas); }

    @Override
    public Salas obtenerSalas(Integer id) {
        return salasRepository.findById(id).orElseThrow( ()->new RuntimeException("Salas no encontrada por el ID : "+id));
    }

    @Override
    public void eliminarSalas(Integer id) {
        if(salasRepository.existsById(id)) {
            salasRepository.deleteById(id);
        }else{
            throw new RuntimeException("Sala no encontrada por el ID : "+id);
        }
    }
}
