package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Reservas;
import com.cibertec.proyecto_final_lp2_pixel_movies.service.ReservaService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import org.hibernate.Session;
import jakarta.persistence.EntityManager;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;
    private final EntityManager entityManager;

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

    @GetMapping("/reporteReservas")
    public void reporteReservas(HttpServletResponse response) throws JRException, SQLException, IOException {
        // Obtén la conexión JDBC desde el EntityManager
        Session session = entityManager.unwrap(Session.class);
        Connection conn = session.doReturningWork(connection -> connection.unwrap(Connection.class));

        // Cargar el reporte .jasper
        InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptReservas.jasper");
        Map<String, Object> params = new HashMap<>();

        // Cargar el reporte
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

        // Llenar el reporte con la conexión JDBC obtenida
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

        // Configuración para devolver el reporte PDF en la respuesta HTTP
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=reservas_report.pdf");

        // Enviar el reporte como respuesta
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        // Cerrar la conexión
        conn.close();
    }
}
