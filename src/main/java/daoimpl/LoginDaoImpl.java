package daoimpl;

import conexion.Conexion;
import dao.ILogin;
import models.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDaoImpl implements ILogin {

    @Override
    public Usuario userLogin(int run) {
        Usuario user1 = new Usuario();

        try {
            String sqlLogin = "SELECT id_usuario, nombre, apellido1, apellido2, fecha_nacimiento, run, contrasenia, tipo_usuario FROM sql9628208.Usuario WHERE run = "+run ;

            Connection conexion = Conexion.getConexion();
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sqlLogin);

            user1 = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getDate("fecha_nacimiento"), rs.getInt("run"), rs.getString("contrasenia"), rs.getInt("tipo_usuario"));

        }catch(SQLException e) {
            System.out.println("Error al consultar la BD");
            e.printStackTrace();
        }

        return null;
    }
}
