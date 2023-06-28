package controllers;


import daoimpl.AdministrativoDaoImpl;
import daoimpl.ProfesionalDaoImpl;
import daoimpl.UsuarioDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    private ProfesionalDaoImpl profesionalDao;
    private UsuarioDaoImpl usu =new UsuarioDaoImpl();;
    private AdministrativoDaoImpl adm =new AdministrativoDaoImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath(); // Devuelve un string con el nombre o ruta del request (nombre del action del form)"
        System.out.println(action);
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
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
            case "/get":
                try {
                    get(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarUsuario.jsp");
        dispatcher.forward(request, response);
    }










    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String  tipoDeUsuario = request.getParameter("floatingSelect");// ID del Select
        PrintWriter out = response.getWriter();
        switch (tipoDeUsuario){
            case "1":
                out.println("<script type=\"text/javascript\">");
                out.println("consol.log('funciona cliente')");
                out.println("location='index.jsp';");
                out.println("</script>");
                break;
            case "2":
                String nombre = request.getParameter("nombre");
                String apellido1 = request.getParameter("apellido1");
                String apellido2 = request.getParameter("apellido2");
                String fechaNacimiento = request.getParameter("fechaNacimiento");
                String run = request.getParameter("run");
                String cotrasena = request.getParameter("contrasena");

                String titulo = request.getParameter("titulo");
                String fecha_ingreso = request.getParameter("fechaIngreso");
                //Profesional profesional = new Profesional(nombre, apellido1,apellido2,fechaNacimiento,run,cotrasena,titulo,fecha_ingreso);
                //profesionalDao.create(profesional);
                break;
            case "3":

                out.println("<script type=\"text/javascript\">");
                out.println("consol.log('funciona administrador')");
                out.println("location='index.jsp';");
                out.println("</script>");
                break;
        }


        int idCliente = Integer.parseInt(request.getParameter("252"));
        String razonSocial = request.getParameter("razonSocial");
        String giroEmpresa = request.getParameter("giroEmpresa");
        int rut = Integer.parseInt(request.getParameter("rut"));
        String telefonoRepresentante = request.getParameter("telefonoRepresentante");
        String direccionEmpresa = request.getParameter("direccionEmpresa");
        String comunaEmpresa = request.getParameter("comunaEmpresa");

        /*Cliente cliente = new Cliente(idCliente,razonSocial, giroEmpresa, rut, telefonoRepresentante, direccionEmpresa, comunaEmpresa);
        clienteDao.create(cliente);
        response.sendRedirect("list");*/
    }











    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        String TipoUsuario = request.getParameter("tipoUsuario");
        System.out.println(id);
        System.out.println(TipoUsuario);
        switch (TipoUsuario){
            case "Administrativo":
                adm.delete(id);
                break;
            case "Cliente":
                //cli.delete(id); El implemento de CLiente delete
                break;
            case "Profesional":
                //pro.delete(id); El implemento de Profesional delete
                break;
        }
        response.sendRedirect("list");
    }










    // Método que se puede eliminar
    private void get(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
       /* int id = Integer.parseInt(request.getParameter("id"));
        Cliente clienteExistente;

       try {

            clienteExistente = clienteDao.seleccionarId(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            request.setAttribute("user", clienteExistente);
            dispatcher.forward(request, response);

        }catch (Exception e) {
            e.printStackTrace();
        }

        */

    }











    // Editar para modificar los 3 tipos de usarios
    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String razonSocial = request.getParameter("razonSocial");
        String giroEmpresa = request.getParameter("giroEmpresa");
        int rut = Integer.parseInt(request.getParameter("rut"));
        String telefonoRepresentante = request.getParameter("telefonoRepresentante");
        String direccionEmpresa = request.getParameter("direccionEmpresa");
        String comunaEmpresa = request.getParameter("comunaEmpresa");


        //Cliente cliente = new Cliente(razonSocial, giroEmpresa, rut, telefonoRepresentante, direccionEmpresa, comunaEmpresa);

        //El parámetro para modificar tiene que ser un id int
        /*
        clienteDao.update(cliente);
        response.sendRedirect("list");
        */


    }















    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{

        //Envio mi lista de usuarios a la pagina de jps a través de la variable en html llamada usuariosHtml
        try {
            request.setAttribute("usuariosHtml", this.usu.list());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // redirigir a página "/listarUsuario.jsp" con la lista de usuariosHtml
        getServletContext().getRequestDispatcher("/listarUsuario.jsp").forward(request,response);



    }








}