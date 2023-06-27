package daoimpl;
import conexion.conexion;
import dao.IAdministrativo;
import models.Administrativo;
import models.Cliente;
import models.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdministrativoDaoImpl implements IAdministrativo {
    @Override
    public boolean create(int id_usuario, Administrativo administrativo) {
        boolean create = false;
        Connection con= null;
        Statement stmt= null;

        String sql= //"INSERT INTO usuario VALUES(null,"
                //+administrativo.getNombre()+","
                //+administrativo.getApellido1()+","
                //+administrativo.getApellido2()+","
                //+administrativo.getFechaNacimiento()+","
                //+administrativo.getRun()+","
                //+administrativo.getPassword()+","
                //+"2"+"); "+
                " INSERT INTO administrativo VALUES(null,'"
                +administrativo.getArea()+"','"
                +administrativo.getExperienciaPrevia()+"',"
                +id_usuario+");";
        try {
            con= conexion.conectar();
            stmt= con.createStatement();
            stmt.execute(sql);
            create=true;
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return create;
    }

    @Override
    public boolean update(int id_administrativo, Administrativo administrativo) {
        boolean update = false;
        Statement stmt=null;
        Connection con=null;
        String sql= "UPDATE administrativo SET area = '"
                +administrativo.getArea()
                +"', c_anios_experiencia = '" +administrativo.getExperienciaPrevia()
                + "' WHERE id_administrativo = "+id_administrativo;
        try {
            con= conexion.conectar();
            stmt= con.createStatement();
            stmt.execute(sql);
            update=true;
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    @Override
    public boolean delete(int id_administrativo) {
        boolean delete = false;
        Connection con= null;
        Statement stmt= null;

        String sql = "DELETE from administrativo where id_administrativo = "
                +id_administrativo;
        try {
            con= conexion.conectar();
            stmt= con.createStatement();
            stmt.execute(sql);
            delete=true;
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return delete;
    }
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
    }
}
