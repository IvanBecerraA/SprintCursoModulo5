package controllers;

import daoimpl.AdministrativoDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Administrativo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/ActualizarAdministrativo")
public class ProcesoActualizarAdministrativo extends HttpServlet {
    private AdministrativoDaoImpl adm = new AdministrativoDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Administrativo adm = new Administrativo();
        adm.setIdAdministrativo(Integer.parseInt(req.getParameter("idAdministrativo")));
        adm.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
        adm.setNombre(req.getParameter("nombre"));
        adm.setApellido1(req.getParameter("apellido1"));
        adm.setApellido2(req.getParameter("apellido2"));
        adm.setArea(req.getParameter("area"));
        adm.setExperienciaPrevia(req.getParameter("experiencia"));
        adm.setPassword(req.getParameter("contrasenia"));
        String fechaNacimientoStr = req.getParameter("fechaNac");
        adm.setFechaNacimiento(LocalDate.parse(fechaNacimientoStr));
        this.adm.update(adm);
        getServletContext().getRequestDispatcher("/ListarUsuario").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //rescatamos el IdUsuario para poder actualizar de la vista ListarUsuario
        int IdUsuario = Integer.parseInt(req.getParameter("idUsuarioA"));

        //llamamos a nuestra lista creada en AdministrativoDaoImpl y enviamos el Id que fue rescatado
        req.setAttribute("administrativosHtml", this.adm.listOne(IdUsuario));
        //Llevamos todos nuestros datos al formulario siguiente
        getServletContext().getRequestDispatcher("/actualizarAdministrativo.jsp").forward(req,resp);
    }
}
