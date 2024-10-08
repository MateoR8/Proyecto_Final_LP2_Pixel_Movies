package com.cibertec.proyecto_final_lp2_pixel_movies.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "RESERVAS")
@Data
@Getter
@Setter
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESERVA")
    private Integer idReserva;

    @Column(name = "FECHA_RESERVA", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaReserva;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "ID_SALA")
    private Salas sala;

}
