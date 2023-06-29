package controllers;

import daoimpl.CapacitacionClienteDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvCapacitacionCreate", urlPatterns = {"/SvCapacitacionCreate"})
public class SvCapacitacionCreate extends HttpServlet {

    public SvCapacitacionCreate() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        CapacitacionClienteDaoImpl capacitacionClienteDaoImpl = new CapacitacionClienteDaoImpl();
        List<Cliente> clientes = capacitacionClienteDaoImpl.read();

        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("views/crearCapacitacion.jsp").forward(request, response);

    }
}
