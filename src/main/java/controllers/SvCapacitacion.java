package controllers;

import daoimpl.CapacitacionDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Capacitacion;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Servlet implementation class SvCapacitacion
 */
@WebServlet(name = "SvCapacitacion", urlPatterns = {"/SvCapacitacion"})
public class SvCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		CapacitacionDaoImpl capacitacionDaoImpl = new CapacitacionDaoImpl();

		switch (action) {
			case "create":

				Capacitacion capacitacion = new Capacitacion();
				capacitacion.setIdCliente(Integer.parseInt(request.getParameter("rutCliente")));
				capacitacion.setFecha(LocalDate.parse(request.getParameter("fecha")));
				capacitacion.setHora(LocalTime.parse(request.getParameter("hora")));
				capacitacion.setLugar(request.getParameter("lugar"));
				capacitacion.setDuracion(Integer.parseInt(request.getParameter("duracion")));
				capacitacion.setCantidadAsistentes(Integer.parseInt(request.getParameter("cantidadAsistentes")));

				capacitacionDaoImpl.create(capacitacion);
				break;

			case "read":

				List<Capacitacion> capacitaciones = capacitacionDaoImpl.read();

				request.setAttribute("capacitaciones", capacitaciones);
				request.getRequestDispatcher("views/listarCapacitaciones.jsp").forward(request, response);

				break;

			case "update":

				Capacitacion capacitacionUpdate = new Capacitacion();
				capacitacionUpdate.setIdCliente(Integer.parseInt(request.getParameter("rutCliente")));
				capacitacionUpdate.setFecha(LocalDate.parse(request.getParameter("fecha")));
				capacitacionUpdate.setHora(LocalTime.parse(request.getParameter("hora")));
				capacitacionUpdate.setLugar(request.getParameter("lugar"));
				capacitacionUpdate.setDuracion(Integer.parseInt(request.getParameter("duracion")));
				capacitacionUpdate.setCantidadAsistentes(Integer.parseInt(request.getParameter("cantidadAsistentes")));

				capacitacionDaoImpl.update(capacitacionUpdate);
				break;

			case "delete":
				capacitacionDelete(request);
				break;

			default:
				System.out.println("Error en el CRUD de Capacitacion");
		}

	}

	private void capacitacionDelete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));

		CapacitacionDaoImpl capacitacionDaoImpl = new CapacitacionDaoImpl();
		capacitacionDaoImpl.delete(id);
	}

}
