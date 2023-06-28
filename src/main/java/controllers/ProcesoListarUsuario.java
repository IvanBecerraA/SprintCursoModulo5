package controllers;
import daoimpl.UsuarioDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Usuario;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ListarUsuario")//NOMBRE DE MI SERVLET
public class ProcesoListarUsuario extends HttpServlet{
    // Creo una variable para llamar los metodos de mi  Dao implement
    private UsuarioDaoImpl usu = new UsuarioDaoImpl();

    //creo el metodo doGET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //Envio mi lista de usuarios a la pagina de jps a través de la variable en html llamada usuariosHtml
        try {
            request.setAttribute("usuariosHtml", this.usu.list());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // redirigir a página "/listarUsuarios.jsp" con la lista de usuariosHtml
        getServletContext().getRequestDispatcher("/listarUsuarios.jsp").forward(request,response);
    }
}
