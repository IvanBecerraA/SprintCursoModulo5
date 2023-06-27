package controllers;

import daoimpl.CapacitacionDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Capacitacion;

import java.io.IOException;
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

		Capacitacion capacitacion = new Capacitacion();
		capacitacion.setRutCliente(request.getParameter("rutCliente"));
		capacitacion.setDia(request.getParameter("dia"));
		capacitacion.setHora(request.getParameter("hora"));
		capacitacion.setLugar(request.getParameter("lugar"));
		capacitacion.setDuracion(request.getParameter("duracion"));
		capacitacion.setCantidadAsistentes(Integer.parseInt(request.getParameter("cantidadAsistentes")));

		CapacitacionDaoImpl capacitacionDaoImpl = new CapacitacionDaoImpl();
		capacitacionDaoImpl.create(capacitacion);

		List<Capacitacion> capacitaciones = capacitacionDaoImpl.read();
		
		HttpSession session = request.getSession();
		session.setAttribute("capacitaciones", capacitaciones);
		
		response.sendRedirect("views/listaCapacitacion.jsp");
	}

}
