package daoimpl;

import conexion.conexion;
import dao.IUsuario;
import models.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements IUsuario {
    @Override
    public List<Usuario> list() throws SQLException {
        List<Usuario> usuarios =  new ArrayList<>();
        Statement stmt=null;
        Connection con=null;
        ResultSet rs= null;
        Usuario usu;
        try {
            con= conexion.conectar();
            stmt= con.createStatement();
            rs = stmt.executeQuery("select * from usuario;");
            while (rs.next()){
                usu = new Usuario(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4), LocalDate.parse(rs.getString(5)),
                        rs.getInt(6),rs.getString(7),rs.getInt(8));
                usuarios.add(usu);
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public Usuario listOne(int id_usuario) {
        Statement stmt=null;
        Connection con=null;
        ResultSet rs= null;
        Usuario usu=null;
        try {
            con= conexion.conectar();
            stmt= con.createStatement();
            rs = stmt.executeQuery("select * from usuario where id_usuario= "+id_usuario+" limit 1" );
            if (rs.next()) { // Verificar si hay filas en el conjunto de resultados
                usu = new Usuario(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), LocalDate.parse(rs.getString(5)),
                        rs.getInt(6), rs.getString(7), rs.getInt(8));
            }else {
                usu = new Usuario();
            }

            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usu;
    }

    @Override
    public boolean update(Usuario usuario) {
        boolean update = false;
        Statement stmt=null;
        Connection con=null;
        String sqlUsu = "update usuario\n" +
                "set nombre= '"+usuario.getNombre()+"',\n" +
                "apellido1 = '"+usuario.getApellido1()+"',\n" +
                "apellido2 = '"+usuario.getApellido2()+"',\n" +
                "fecha_nacimiento = '"+usuario.getFechaNacimiento()+"',\n" +
                "contrasenia='"+usuario.getPassword()+"'\n" +
                "where id_usuario = "+usuario.getIdUsuario()+";";

        try {
            con= conexion.conectar();
            stmt= con.createStatement();
            stmt.executeUpdate(sqlUsu);
            update=true;
            stmt.close();
            con.close();
            System.out.println("Se actualizo correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("No se pudo actualizar");
        return update;
    }
}
