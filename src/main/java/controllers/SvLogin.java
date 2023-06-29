package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/loginServlet")
public class SvLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final String RUN = "admin";
    private final String PASSWORD = "1234";

    /**
     * @see HttpServlet#HttpServlet()
     */

    public SvLogin() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestUsuario = "";
        String requestPassword = "";

        PrintWriter out = response.getWriter();

        requestUsuario = request.getParameter("run");
        requestPassword = request.getParameter("password");

        if(!RUN.contentEquals(requestUsuario) || !PASSWORD.contentEquals(requestPassword)) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('RUN o password incorrectos');");
            out.println("location='views/login.jsp';"); //el profe lo tenía como .jsp
            out.println("</script>");

        } else {
            HttpSession sesionUsuario= request.getSession(true);
            sesionUsuario.setAttribute("Nombre", requestUsuario);
            RequestDispatcher rd = request.getRequestDispatcher("views/listarCapacitaciones.jsp"); //el profe lo tenía cómo .jsp
            rd.forward(request, response);
        }
    }

}
