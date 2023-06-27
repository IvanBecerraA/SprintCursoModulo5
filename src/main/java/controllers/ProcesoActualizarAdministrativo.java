package controllers;

import daoimpl.AdministrativoDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ActualizarAdministrativo")
public class ProcesoActualizarAdministrativo extends HttpServlet {
    private AdministrativoDaoImpl adm = new AdministrativoDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int IdUsuario = Integer.parseInt(req.getParameter("idUsuarioA"));
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Título de la página</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + IdUsuario + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
