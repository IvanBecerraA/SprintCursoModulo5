package daoimpl;

import conexion.conexion;
import dao.IUsuario;
import models.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements IUsuario {

    /*@Override
    public List<Usuario> list() throws SQLException {
        List<Usuario> usuarios =  new ArrayList<>();
        Statement stmt=null;
        Connection con=null;
        ResultSet rs= null;
        Usuario usu;
        try {
            con= conexion.conectar();
            stmt= con.createStatement();
            rs = stmt.executeQuery("select id_usuario, nombre, apellido1, apellido2, " +
                    "fecha_nacimiento, run, tipo_usuario from usuario;");
            while (rs.next()){
                usu = new Usuario(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getDate(5),
                        rs.getInt(6),rs.getInt(7));
                usuarios.add(usu);
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }*/
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
                        rs.getString(3),rs.getString(4),rs.getDate(5),
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
}
