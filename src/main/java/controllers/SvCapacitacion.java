package controllers;

import daoimpl.CapacitacionClienteDaoImpl;
import daoimpl.CapacitacionDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Capacitacion;
import models.Cliente;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
		List<Cliente> clientes = new ArrayList<>();
		CapacitacionClienteDaoImpl capacitacionClienteDaoImpl = new CapacitacionClienteDaoImpl();
		CapacitacionDaoImpl capacitacionDaoImpl = new CapacitacionDaoImpl();

		switch (action) {
			case "create":

				//obtener id de cliente mediante el RUT ingresado en el JSP
				clientes = capacitacionClienteDaoImpl.read();
				int id_cliente = 0;
				for (Cliente cliente : clientes) {
					if (cliente.getRut() == Integer.parseInt(request.getParameter("rutCliente"))) {
						id_cliente = cliente.getId_cliente();
					}
				}

				Capacitacion capacitacion = new Capacitacion();
				capacitacion.setRutCliente(id_cliente);
				capacitacion.setFecha(LocalDate.parse(request.getParameter("fecha")));
				capacitacion.setHora(LocalTime.parse(request.getParameter("hora")));
				capacitacion.setLugar(request.getParameter("lugar"));
				capacitacion.setDuracion(Integer.parseInt(request.getParameter("duracion")));
				capacitacion.setCantidadAsistentes(Integer.parseInt(request.getParameter("cantidadAsistentes")));

				capacitacionDaoImpl.create(capacitacion);

			case "read":

				read(request, response);
				break;

			case "update":

				//obtener RUT de cliente mediante el id ingresado en la DB
				clientes = capacitacionClienteDaoImpl.read();
				int id_clienteUpd = 0;
				for (Cliente cliente : clientes) {
					if (cliente.getRut() == Integer.parseInt(request.getParameter("rutCliente"))) {
						id_clienteUpd = cliente.getId_cliente();
					}
				}

				Capacitacion capacitacionUpdate = new Capacitacion();
				capacitacionUpdate.setId(Integer.parseInt(request.getParameter("id")));
				capacitacionUpdate.setRutCliente(id_clienteUpd);
				capacitacionUpdate.setFecha(LocalDate.parse(request.getParameter("fecha")));
				capacitacionUpdate.setHora(LocalTime.parse(request.getParameter("hora")));
				capacitacionUpdate.setLugar(request.getParameter("lugar"));
				capacitacionUpdate.setDuracion(Integer.parseInt(request.getParameter("duracion")));
				capacitacionUpdate.setCantidadAsistentes(Integer.parseInt(request.getParameter("cantidadAsistentes")));

				capacitacionDaoImpl.update(capacitacionUpdate);

				read(request, response);
				break;

			case "delete":

				int id = Integer.parseInt(request.getParameter("idDelete"));
				capacitacionDaoImpl.delete(id);

				read(request, response);
				break;

			default:
				System.out.println("Error en el CRUD de Capacitacion");
		}

	}

	private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> clientes;
		CapacitacionClienteDaoImpl capacitacionClienteDaoImpl = new CapacitacionClienteDaoImpl();
		CapacitacionDaoImpl capacitacionDaoImpl = new CapacitacionDaoImpl();

		clientes = capacitacionClienteDaoImpl.read();
		List<Capacitacion> capacitaciones = capacitacionDaoImpl.read();
		List<Capacitacion> capacitacionesRut = new ArrayList<>();

		for (Cliente cliente : clientes) {
			for (Capacitacion capacitacion1 : capacitaciones) {
				if (cliente.getId_cliente() == capacitacion1.getRutCliente()) {
					capacitacion1.setRutCliente(cliente.getRut());
				}
				capacitacionesRut.add(capacitacion1);
			}
		}

		request.setAttribute("capacitaciones", capacitacionesRut);
		request.getRequestDispatcher("views/listarCapacitaciones.jsp").forward(request, response);
	}

}
