package controllers;

import daoimpl.AdministrativoDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EliminarAdministrativo")
public class ProcesoEliminarAdministrativo extends HttpServlet {
    private AdministrativoDaoImpl adm = new AdministrativoDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int IdUsuario = Integer.parseInt(req.getParameter("idUsuarioE"));
        adm.delete(IdUsuario);
        resp.sendRedirect(req.getContextPath() + "/ListarUsuario");
    }
}
