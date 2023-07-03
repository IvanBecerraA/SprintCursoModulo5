package controllers;

import daoimpl.AdministrativoDaoImpl;
import daoimpl.ClienteDaoImpl;
import daoimpl.ProfesionalDaoImpl;
import daoimpl.UsuarioDaoImpl;
import jakarta.servlet.http.HttpSession;
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
//@WebServlet("/")
@WebServlet(name = "SvUsuario", urlPatterns = {"/usuario", "/update", "/delete", "/create"})
public class SvUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDaoImpl clienteDao = new ClienteDaoImpl();
    private ProfesionalDaoImpl profesionalDao = new ProfesionalDaoImpl();
    private AdministrativoDaoImpl administrativoDao = new AdministrativoDaoImpl();
    private PrintWriter out;
    private UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
    private boolean enviado;

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
                System.out.println("ENTRÉ AL DOGET - UPDATE");
                //rescatamos el IdUsuario y tipo usuario
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                String tipoUsuario = request.getParameter("tipoUsuario");
                //enviamos a sus respectivos formularios segun su tipousuario
                switch (tipoUsuario) {
                    case "Cliente":
                        /*Cliente cli = clienteDao.listOne(idUsuario);
                        HttpSession misesion = request.getSession();
                        misesion.setAttribute("editarCliente", cli);
                        response.sendRedirect("/views/editarCliente.jsp");
                        */
                        request.setAttribute("editarCliente", this.clienteDao.listOne(idUsuario));
                        getServletContext().getRequestDispatcher("/views/editarCliente.jsp").forward(request, response);
                        break;
                    case "Profesional":
                        break;
                    case "Administrativo":
                        //llamamos los campos de nuestra tabla Administrativo + Usuario filatrado por el idUsuario y lo enviamos al HTML
                        request.setAttribute("administrativosHtml", this.administrativoDao.listOne(idUsuario));
                        //Nos dirigimos a nuestro formulario para modificar
                        getServletContext().getRequestDispatcher("/views/editarAdministrativo.jsp").forward(request, response);
                        break;
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

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
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
                enviado = clienteDao.create(cliente);
                crear = "Cliente";
                break;

            case 2:

                String titulo = request.getParameter("titulo");
                String fecha_ingreso = request.getParameter("fechaIngreso");

                LocalDate fechaIngreso = LocalDate.parse(fecha_ingreso, formatter);

                Profesional profesional = new Profesional(nombre, apellido1,apellido2,fecha_Nacimiento,run,contrasena,tipoDeUsuario,titulo,fechaIngreso);
                enviado = profesionalDao.create(profesional);
                crear = "Profesional";
                break;

            case 3:

                String area = request.getParameter("area");
                int expPrevia = Integer.parseInt(request.getParameter("experienciaPrevia"));

                Administrativo administrativo = new Administrativo(
                        nombre, apellido1, apellido2, fecha_Nacimiento, run,
                        contrasena, tipoDeUsuario, area, expPrevia);
                enviado = administrativoDao.create(administrativo);
                crear = "Administrativo";
                break;
        }

        // Envío de Alerta por Usuario registrado
        try {
            if (enviado) {
                String mensaje = crear + " ha sido creado correctamente";
                request.setAttribute("valido", mensaje);
            } else {
                String mensaje = "Ha ocurrido un error al crear el usuario";
                request.setAttribute("error", mensaje);
            }

            request.getRequestDispatcher("/usuario").forward(request, response);
        } catch (Exception ex) {
            // Manejar cualquier excepción que pueda ocurrir
        }
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
                administrativoDao.delete(id); // TODO Implementar médoto delete() en dao
                break;
        }

        out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Usuario Eliminado con exito');");
        out.println("location='/list'");
        out.println("</script>");

        //response.sendRedirect("list");

    }


        private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        // todo este método tiene que ser solo para el DOPOST, el doget tiene el código del update en el mismo case
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
                        request.setAttribute("clienteHtml", this.clienteDao.listOne(idUsuario));
                        getServletContext().getRequestDispatcher("/views/editarCliente.jsp").forward(request, response);
                        break;
                    case "Profesional":
                        break;
                    case "Administrativo":
                        //llamamos los campos de nuestra tabla Administrativo + Usuario filatrado por el idUsuario y lo enviamos al HTML
                        request.setAttribute("administrativosHtml", this.administrativoDao.listOne(idUsuario));
                        //Nos dirigimos a nuestro formulario para modificar
                        getServletContext().getRequestDispatcher("/views/actualizarAdministrativo.jsp").forward(request, response);
                        break;
                }

            } else {
                //Cargamos todos los campos de Usuario que se tendra por defecto en cada update
                int idUsuario = Integer.parseInt(request.getParameter("floatingSelect"));//recuperando id
                int idTipo = Integer.parseInt(request.getParameter("idtipo"));//recuperando id tipo usuario
                String nombre = (request.getParameter("nombre"));
                String apellido1 = (request.getParameter("apellido1"));
                String apellido2 = (request.getParameter("apellido2"));
                String password = (request.getParameter("contrasenia"));
                LocalDate FechaNacimiento = (LocalDate.parse(request.getParameter("fechaNac")));
                String tipoUsuario = idTipo==1?(idTipo==2?"Profesional":"Cliente"):"Administrativo";
                switch (tipoUsuario) {
                    case "Cliente":

                        cli.setNombre(nombre); cli.setApellido1(apellido1);
                        cli.setApellido2(apellido2); cli.setContrasenia(password); cli.setFechaNacimiento(FechaNacimiento);
                        cli.setId_cliente(Integer.parseInt(request.getParameter("idCliente")));
                        cli.setRazonSocial(request.getParameter("razonSocial"));
                        cli.setGiroEmpresa(request.getParameter("giroEmpresa"));
                        cli.setRut(Integer.parseInt(request.getParameter("rut")));
                        cli.setTelefonoRepresentante(request.getParameter("telefonoRepresentante"));
                        cli.setDireccionEmpresa(request.getParameter("direccionEmpresa"));
                        cli.setComunaEmpresa(request.getParameter("comunaEmpresa"));

                        this.clienteDao.update(cli);
                        break;
                    case "Profesional":
                        /* Codigo si es Profesional*/
                        break;
                    case "Administrativo":
                        //hacemos un Set para nuestra clase Administrador
                        adm.setId_usuario(idUsuario); adm.setNombre(nombre); adm.setApellido1(apellido1);
                        adm.setApellido2(apellido2);adm.setContrasenia(password);adm.setFechaNacimiento(FechaNacimiento);
                        //recuperamos los datos que pertenecen a nuestra propia clase desde el formulario
                        adm.setId_administrativo(Integer.parseInt(request.getParameter("idAdministrativo")));
                        adm.setArea(request.getParameter("area"));
                        adm.setExperienciaPrevia(Integer.parseInt(request.getParameter("experiencia")));
                        //lo enviamos a nuestro metodo udpate
                        this.administrativoDao.update(adm);
                        break;
                }
            }
            //Nos envia a Listar usuario solo si no entra al if
            response.sendRedirect("listarUsuarios.jsp");
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
