package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/SvCliente")
public class SvCliente {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String razonSocial = request.getParameter("razonSocial");
        String giroEmpresa = request.getParameter("giroEmpresa");
        String rut = request.getParameter("rut");
        String telefonoRepresentante = request.getParameter("telefonoRepresentante");
        String direccionEmpresa = request.getParameter("direccionEmpresa");
        String comunaEmpresa = request.getParameter("comunaEmpresa");
    }
}
