package controllers;

import daoimpl.AdministrativoDaoImpl;
//import daoimpl.ClienteDaoImpl;
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
import models.Usuario;

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
    //private ClienteDaoImpl clienteDao = new ClienteDaoImpl();
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
        /*String action = request.getServletPath(); // Devuelve un string con el nombre o ruta del request (nombre del action del form)"

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
        }*/
        String option = request.getParameter("option");
        switch (option){
            case "create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    update(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "delete":
                System.out.println("Estoy en delete");
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
        String option = request.getParameter("option");
        switch (option){
            case "create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    update(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "delete":
                System.out.println("Estoy en delete");
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
        /*String crear = null;
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

                *//**//*Cliente cliente = new Cliente(nombre, apellido1,apellido2,fecha_Nacimiento,run,contrasena,tipoDeUsuario,razonSocial,giroEmpresa,rut,telefonoRepresentante,direccionEmpresa,comunaEmpresa);

                clienteDao.create(cliente);
                crear = "Cliente";
                break;*//**//*

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
                break;*//*
        }

        out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Usuario creado con exito');");
        out.println("location='/list'");
        out.println("</script>");

        //response.sendRedirect("list"); // Redije a lista de usuarios*/


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String  tipoDeUsuario = request.getParameter("tipoUsuario");
        int id = Integer.parseInt(request.getParameter("id_usuario"));
        System.out.println(tipoDeUsuario);
        System.out.println(id);
        switch (tipoDeUsuario){
            case "CLiente":
                //clienteDao.delete(id);
                break;

            case "Profesional":
                //profesionalDao.delete(id);
                break;

            case "Administrativo":
                System.out.println("estoy por eliminar");
                administrativoDao.delete(id);
                break;
        }

        out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Usuario eliminado con exito');");
        out.println("location='/../SprintCursoModulo5/usuario?option=List'");
        out.println("</script>");

        //response.sendRedirect("list");

    }


        private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

            //Instanciamos las clases
            Administrativo adm = new Administrativo(); //Administrativo
            Cliente cli = new Cliente(); //CLiente
            Profesional pro = new Profesional(); //Profesional
            Usuario usu = new Usuario(); //Usuario
            /* La variable botonFormulario es para saber si la accion de entrar al update es a través
            de la listarUsuarios
            */
            String botonFormulario = request.getParameter("actualizarFormulario");

            //preguntamos si entramos desde la lista
            if (botonFormulario != "" && botonFormulario != null) {
                botonFormulario="";
                System.out.println("Entro desde editar");
                //rescatamos el IdUsuario y tipo usuario
                int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
                String tipoUsuario = request.getParameter("tipoUsuario");
                //enviamos el usuario seleccionado
                request.setAttribute("usuariosHtml",this.usuarioDao.listOne(id_usuario));
                request.setAttribute("profesionalesHtml",this.profesionalDao.listOne(id_usuario));
                request.setAttribute("administrativosHtml", this.administrativoDao.listOne(id_usuario));
                getServletContext().getRequestDispatcher("/views/actualizarAdministrativo.jsp").forward(request, response);
                //enviamos a sus respectivos formularios segun su tipousuario
                /*switch (tipoUsuario) {
                    case "Cliente":
                        System.out.println("Cliente");
                        break;
                    case "Profesional":
                        request.setAttribute("profesionalesHtml",this.profesionalDao.listOne(id_usuario));
                        getServletContext().getRequestDispatcher("/views/actualizarAdministrativo.jsp").forward(request,response);
                        break;
                    case "Administrativo":
                        //llamamos los campos de nuestra tabla Administrativo + Usuario filatrado por el idUsuario y lo enviamos al HTML
                        request.setAttribute("administrativosHtml", this.administrativoDao.listOne(id_usuario));
                        //Nos dirigimos a nuestro formulario para modificar
                        getServletContext().getRequestDispatcher("/views/actualizarAdministrativo.jsp").forward(request, response);
                        break;
                }*/

            } else {
                System.out.println("Entro adm------------>");
                //Cargamos todos los campos de Usuario que se tendra por defecto en cada update
                int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));//recuperando id
                int id_tipoUsuario = Integer.parseInt(request.getParameter("id_tipoUsuario"));//recuperando id tipo usuario
                String nombre = (request.getParameter("nombre"));
                String apellido1 = (request.getParameter("apellido1"));
                String apellido2 = (request.getParameter("apellido2"));
                String password = (request.getParameter("contrasenia"));
                LocalDate FechaNacimiento = (LocalDate.parse(request.getParameter("fechaNac")));
                String tipoUsuario = id_tipoUsuario==1?(id_tipoUsuario==2?"Profesional":"Cliente"):"Administrativo";
                //hacemos un Set para nuestra clase Usuario
                usu.setIdUsuario(id_usuario); usu.setNombre(nombre); usu.setApellido1(apellido1);
                usu.setApellido2(apellido2);usu.setPassword(password);usu.setFechaNacimiento(FechaNacimiento);
                switch (tipoUsuario) {
                    case "Cliente":
                        /* Codigo si es CLiente*/
                        break;
                    case "Profesional":
                        /* Codigo si es Profesional*/
                        break;
                    case "Administrativo":
                        //recuperamos los datos que pertenecen a nuestra propia clase desde el formulario
                        adm.setIdAdministrativo(Integer.parseInt(request.getParameter("idAdministrativo")));
                        adm.setArea(request.getParameter("area"));
                        adm.setExperienciaPrevia((request.getParameter("experiencia")));
                        //lo enviamos a nuestro metodo udpate
                        this.administrativoDao.update(adm);
                        this.usuarioDao.update(usu);
                        break;
                }
            }
            //Nos envia a Listar usuario solo si no entra al if
            System.out.println("Imprimiendo lista");
            listUsers(request,response);
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
