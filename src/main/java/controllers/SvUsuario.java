package controllers;

import daoimpl.AdministrativoDaoImpl;
import daoimpl.ClienteDaoImpl;
import daoimpl.ProfesionalDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Administrativo;
import models.Cliente;
import models.Profesional;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class SvUsuarios
 */
@WebServlet("/")
public class SvUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDaoImpl clienteDao;
    private ProfesionalDaoImpl profesionalDao;
    private AdministrativoDaoImpl administrativoDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath(); // Devuelve un string con el nombre o ruta del request (nombre del action del form)"
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/create":
                System.out.println("Hello from POST!");
                // implementacion
                try {
                    create(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/update":
                try {
                    update(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/delete":
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    listUsers(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath(); // Devuelve un string con el nombre o ruta del request (nombre del action del form)"
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/create":
                System.out.println("Hello from GET!");
                // Redirecciona a crearUsuario
                getServletContext().getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
                break;
            case "/update":
                try {
                    update(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/delete":
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    listUsers(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }


/*

    Esto es un esqueleto de servlet sujeto a modificaciones

    La idea sería usar este servlet para el crud de los 3 usuarios
    faltaría editar el switch, los métodos, links de redireccionamientos, etc

    dejé espacio entre los métodos para no pisar líneas cuando hagamos modificaciones
    pero ojalá coordinarnos para trabajar sobre ese servlet
*
*
* */




    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }










    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        // Datos básicos del Usuario, transversal a todas las clases
        int  tipoDeUsuario = Integer.parseInt(request.getParameter("floatingSelect"));// ID del Select
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String fechaNacimiento = request.getParameter("fechaNacimiento"); // TODO Debe ser de tipo DATE o LOCALDATE
        int run = Integer.parseInt(request.getParameter("run")); //TODO DEBE SER INT
        String contrasena = request.getParameter("contrasena");

        switch (tipoDeUsuario){

            case 1:
                //TODO CLIENTE
                String razonSocial = request.getParameter("razonSocial");
                String giroEmpresa = request.getParameter("giroEmpresa");
                int rut = Integer.parseInt(request.getParameter("rut")); // TODO DEBE SER INT?
                String telefonoRepresentante = request.getParameter("telefonoRepresentante");
                String direccionEmpresa = request.getParameter("direccionEmpresa");
                String comunaEmpresa = request.getParameter("comunaEmpresa");

                //Cliente cliente = new Cliente(nombre, apellido1,apellido2,fechaNacimiento,run,contrasena,tipoDeUsuario,razonSocial,giroEmpresa,rut,telefonoRepresentante,direccionEmpresa,comunaEmpresa);
                //clienteDao.create(cliente);
                break;

            case 2:
                String titulo = request.getParameter("titulo");
                String fecha_ingreso = request.getParameter("fechaIngreso");

                Profesional profesional = new Profesional(nombre, apellido1,apellido2,fechaNacimiento,run,contrasena,tipoDeUsuario,titulo,fecha_ingreso);
                profesionalDao.create(profesional);
                break;

            case 3:
                // TODO ADMINISTRATIVO
                String area = request.getParameter("area");
                String expPrevia = request.getParameter("experienciaPrevia");

//                Administrativo administrativo = new Administrativo(nombre, apellido1, apellido2,
//                                                fechaNacimiento, run, contrasena, tipoDeUsuario,
//                                                area, expPrevia);
//                administrativoDao.create(administrativo); //TODO DESCOMENTAR CUANDO TIPOS DE DATOS HAYAN SIDO ARREGLADOS
                break;
        }

        response.sendRedirect("list"); // Redije a lista de usuarios


    }











    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            clienteDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




        // Editar para modificar los 3 tipos de usarios
        private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
            String razonSocial = request.getParameter("razonSocial");
            String giroEmpresa = request.getParameter("giroEmpresa");
            int rut = Integer.parseInt(request.getParameter("rut"));
            String telefonoRepresentante = request.getParameter("telefonoRepresentante");
            String direccionEmpresa = request.getParameter("direccionEmpresa");
            String comunaEmpresa = request.getParameter("comunaEmpresa");

            Cliente cliente = new Cliente(razonSocial, giroEmpresa,rut,telefonoRepresentante,direccionEmpresa,comunaEmpresa);

            clienteDao.update(cliente);
            response.sendRedirect("list");


        }


















    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        /*
        try{
            List<Cliente> listaClientes = clienteDao.list();
            request.setAttribute("listaClientes", listaClientes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

         */

    }








}
