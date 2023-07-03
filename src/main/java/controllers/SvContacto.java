package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/contactosv")
public class SvContacto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String mensaje = request.getParameter("mensaje");


        System.out.println("El formulario se ha enviado correctamente!!!");
        System.out.println("----------------------------------------------");
        System.out.println("Los datos ingresados en el formulario de contacto son los sgte:\n"+"Nombre: "+ nombre+ " " +apellidos+"\ncontacto: "+telefono +" "+email+"\nMensaje: "+mensaje);
        // Redireccionando a una página de confirmación
        response.sendRedirect("/usuario");
    }
}