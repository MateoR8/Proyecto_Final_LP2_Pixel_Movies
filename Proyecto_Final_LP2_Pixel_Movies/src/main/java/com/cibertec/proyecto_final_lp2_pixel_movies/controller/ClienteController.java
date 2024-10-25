package com.cibertec.proyecto_final_lp2_pixel_movies.controller;

import com.cibertec.proyecto_final_lp2_pixel_movies.model.Cliente;

import com.cibertec.proyecto_final_lp2_pixel_movies.service.ClienteService;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Clientes")
@RequiredArgsConstructor
@SessionAttributes("admin")

public class ClienteController {

    private final ClienteService clienteService;
    private final EntityManager entityManager;

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

    @GetMapping("/reporteClientes")
    public void reporteClientes(HttpServletResponse response) throws JRException, SQLException, IOException {
        // Obtén la conexión JDBC desde el EntityManager
        Session session = entityManager.unwrap(Session.class);
        Connection conn = session.doReturningWork(connection -> connection.unwrap(Connection.class));

        // Cargar el reporte .jasper
        InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/rptClientes.jasper");
        Map<String, Object> params = new HashMap<>();

        // Cargar el reporte
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

        // Llenar el reporte con la conexión JDBC obtenida
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

        // Configuración para devolver el reporte PDF en la respuesta HTTP
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=clientes_report.pdf");

        // Enviar el reporte como respuesta
        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        // Cerrar la conexión
        conn.close();
    }
}
