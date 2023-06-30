package daoimpl;

import conexion.Conexion;
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
            con= Conexion.getConexion();
            stmt= con.createStatement();
            rs = stmt.executeQuery("select * from Usuario;");
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

}
