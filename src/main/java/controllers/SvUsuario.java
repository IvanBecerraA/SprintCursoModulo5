package controllers;

import daoimpl.AdministrativoDaoImpl;
import daoimpl.ClienteDaoImpl;
import daoimpl.ProfesionalDaoImpl;
import daoimpl.UsuarioDaoImpl;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class SvUsuarios
 */
@WebServlet("/usuario")
public class SvUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDaoImpl clienteDao = new ClienteDaoImpl();
    private ProfesionalDaoImpl profesionalDao = new ProfesionalDaoImpl();
    private AdministrativoDaoImpl administrativoDao = new AdministrativoDaoImpl();
    private PrintWriter out;
    private UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();


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

            case "/create":
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

            case "/create":
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



    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String crear = null;
        // Datos básicos del Usuario, transversal a todas las clases
        int  tipoDeUsuario = Integer.parseInt(request.getParameter("floatingSelect"));// ID del Select
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        int run = Integer.parseInt(request.getParameter("run"));
        String contrasena = request.getParameter("contrasena");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate fecha_Nacimiento = LocalDate.parse(fechaNacimiento, formatter);

        switch (tipoDeUsuario){

            case 1:

                String razonSocial = request.getParameter("razonSocial");
                String giroEmpresa = request.getParameter("giroEmpresa");
                int rut = Integer.parseInt(request.getParameter("rut"));
                String telefonoRepresentante = request.getParameter("telefonoRepresentante");
                String direccionEmpresa = request.getParameter("direccionEmpresa");
                String comunaEmpresa = request.getParameter("comunaEmpresa");

                Cliente cliente = new Cliente(nombre, apellido1,apellido2,fecha_Nacimiento,run,contrasena,tipoDeUsuario,razonSocial,giroEmpresa,rut,telefonoRepresentante,direccionEmpresa,comunaEmpresa);

                clienteDao.create(cliente);
                crear = "Cliente";
                break;

            case 2:

                String titulo = request.getParameter("titulo");
                String fecha_ingreso = request.getParameter("fechaIngreso");

                LocalDate fechaIngreso = LocalDate.parse(fecha_ingreso, formatter);

                Profesional profesional = new Profesional(nombre, apellido1,apellido2,fecha_Nacimiento,run,contrasena,tipoDeUsuario,titulo,fechaIngreso);
                profesionalDao.create(profesional);
                crear = "Profesional";
                break;

            case 3:

                String area = request.getParameter("area");
                int expPrevia = Integer.parseInt(request.getParameter("experienciaPrevia"));

                Administrativo administrativo = new Administrativo(
                        nombre, apellido1, apellido2, fecha_Nacimiento, run,
                        contrasena, tipoDeUsuario, area, expPrevia);
                administrativoDao.create(administrativo);
                crear = "Administrativo";
                break;
        }

        out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Usuario creado con exito');");
        out.println("location='/list'");
        out.println("</script>");

        //response.sendRedirect("list"); // Redije a lista de usuarios


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int  tipoDeUsuario = Integer.parseInt(request.getParameter("floatingSelect"));
        int id = Integer.parseInt(request.getParameter("id_usuario"));

        switch (tipoDeUsuario){
            case 1:
                clienteDao.delete(id);
                break;

            case 2:
                profesionalDao.delete(id);
                break;

            case 3:
                administrativoDao.delete(id);
                break;
        }

        out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Usuario Eliminado con exito');");
        out.println("location='/list'");
        out.println("</script>");

        //response.sendRedirect("list");

    }


        private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
            // Datos básicos del Usuario, transversal a todas las clases
            int  tipoDeUsuario = Integer.parseInt(request.getParameter("floatingSelect"));// ID del Select
            String nombre = request.getParameter("nombre");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            int run = Integer.parseInt(request.getParameter("run"));
            String contrasena = request.getParameter("contrasena");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha_Nacimiento = LocalDate.parse(fechaNacimiento, formatter);

            switch (tipoDeUsuario){

                case 1:

                    String razonSocial = request.getParameter("razonSocial");
                    String giroEmpresa = request.getParameter("giroEmpresa");
                    int rut = Integer.parseInt(request.getParameter("rut"));
                    String telefonoRepresentante = request.getParameter("telefonoRepresentante");
                    String direccionEmpresa = request.getParameter("direccionEmpresa");
                    String comunaEmpresa = request.getParameter("comunaEmpresa");

                    Cliente cliente = new Cliente(nombre, apellido1,apellido2,fecha_Nacimiento,run,contrasena,tipoDeUsuario,razonSocial,giroEmpresa,rut,telefonoRepresentante,direccionEmpresa,comunaEmpresa);
                    clienteDao.update(cliente);
                    break;

                case 2:

                    String titulo = request.getParameter("titulo");
                    String fecha_ingreso = request.getParameter("fechaIngreso");

                    LocalDate fechaIngreso = LocalDate.parse(fecha_ingreso, formatter);

                    Profesional profesional = new Profesional(nombre, apellido1,apellido2,fecha_Nacimiento,run,contrasena,tipoDeUsuario,titulo,fechaIngreso);
                    profesionalDao.update(profesional.getId_usuario());
                    break;

                case 3:

                    String area = request.getParameter("area");
                    int expPrevia = Integer.parseInt(request.getParameter("experienciaPrevia"));

                    Administrativo administrativo = new Administrativo(
                            nombre, apellido1, apellido2, fecha_Nacimiento, run,
                            contrasena, tipoDeUsuario, area, expPrevia);
                    System.out.println(administrativo);
                    System.out.println(administrativo.getFechaNacimiento());
                    administrativoDao.update(administrativo.getId_usuario());
                    break;
            }

            //response.sendRedirect("list"); // Redije a lista de usuarios

        }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        //Envio mi lista de usuarios a la pagina de jps a través de la variable en html llamada usuariosHtml
        try {
            request.setAttribute("usuariosHtml", this.usuarioDao.list());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // redirigir a página "/listarUsuarios.jsp" con la lista de usuariosHtml
        getServletContext().getRequestDispatcher("/views/listarUsuarios.jsp").forward(request,response);


    }






}
