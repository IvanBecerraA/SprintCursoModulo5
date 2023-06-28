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
import models.Administrativo;
import models.Cliente;
import models.Profesional;
import models.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarUsuarios.jsp");
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
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));//Recuperamos el id del Usuario
        String TipoUsuario = request.getParameter("tipoUsuario");//recuperamos tipo de usuario en texto
        switch (TipoUsuario){ //evaluamos que tipo de usuario es
            case "Administrativo":
                adm.delete(idUsuario); //llamamos al metodo que eliminará en nuestro el registro en SQL
                break;
            case "Cliente":
                //cli.delete(id); El implemento de CLiente delete
                break;
            case "Profesional":
                //pro.delete(id); El implemento de Profesional delete
                break;
        }
        response.sendRedirect("listUsers"); //Le damos un nombre que no existe para que nos
                                                // lleve a la función ListUser
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
    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        //Instanciamos las clases
        Administrativo adm = new Administrativo(); //Administrativo
        Cliente cli = new Cliente(); //CLiente
        Profesional pro = new Profesional(); //Profesional
        /* La variable botonFormulario es para saber si la accion de entrar al update es a través
        de la listarUsuarios
        */
        String botonFormulario = request.getParameter("actualizarFormulario");

        //preguntamos si entramos desde la lista
        if (botonFormulario != "" && botonFormulario != null) {
            //rescatamos el IdUsuario y tipo usuario
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String tipoUsuario = request.getParameter("tipoUsuario");
            //enviamos a sus respectivos formularios segun su tipousuario
            switch (tipoUsuario) {
                case "Cliente":
                    break;
                case "Profesional":
                    break;
                case "Administrativo":
                    //llamamos los campos de nuestra tabla Administrativo + Usuario filatrado por el idUsuario y lo enviamos al HTML
                    request.setAttribute("administrativosHtml", this.adm.listOne(idUsuario));
                    //Nos dirigimos a nuestro formulario para modificar
                    getServletContext().getRequestDispatcher("/views/actualizarAdministrativo.jsp").forward(request, response);
                    break;
            }

        } else {
            //Cargamos todos los campos de Usuario que se tendra por defecto en cada update
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));//recuperando id
            int idTipo = Integer.parseInt(request.getParameter("idtipo"));//recuperando id tipo usuario
            String nombre = (request.getParameter("nombre"));
            String apellido1 = (request.getParameter("apellido1"));
            String apellido2 = (request.getParameter("apellido2"));
            String password = (request.getParameter("contrasenia"));
            LocalDate FechaNacimiento = (LocalDate.parse(request.getParameter("fechaNac")));
            String tipoUsuario = idTipo==1?(idTipo==2?"Profesional":"Cliente"):"Administrativo";
            switch (tipoUsuario) {
                case "Cliente":
                    /* Codigo si es CLiente*/
                    break;
                case "Profesional":
                    /* Codigo si es Profesional*/
                    break;
                case "Administrativo":
                    //hacemos un Set para nuestra clase Administrador
                    adm.setIdUsuario(idUsuario); adm.setNombre(nombre); adm.setApellido1(apellido1);
                    adm.setApellido2(apellido2);adm.setPassword(password);adm.setFechaNacimiento(FechaNacimiento);
                    //recuperamos los datos que pertenecen a nuestra propia clase desde el formulario
                    adm.setIdAdministrativo(Integer.parseInt(request.getParameter("idAdministrativo")));
                    adm.setArea(request.getParameter("area"));
                    adm.setExperienciaPrevia(request.getParameter("experiencia"));
                    //lo enviamos a nuestro metodo udpate
                    this.adm.update(adm);
                    break;

            }
        }
        //Nos envia a Listar usuario solo si no entra al if
        response.sendRedirect("listUsers");

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
        // redirigir a página "/listarUsuarios.jsp" con la lista de usuariosHtml
        getServletContext().getRequestDispatcher("/views/listarUsuarios.jsp").forward(request,response);



    }








}