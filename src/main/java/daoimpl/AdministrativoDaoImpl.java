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
import java.time.LocalDate;
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
    public boolean update(Administrativo administrativo) {
        boolean update = false;
        Statement stmt=null;
        Connection con=null;
        String sqlUsu = "update usuario\n" +
                "set nombre= '"+administrativo.getNombre()+"',\n" +
                "apellido1 = '"+administrativo.getApellido1()+"',\n" +
                "apellido2 = '"+administrativo.getApellido2()+"',\n" +
                "fecha_nacimiento = '"+administrativo.getFechaNacimiento()+"',\n" +
                "contrasenia='"+administrativo.getPassword()+"'\n" +
                "where id_usuario = "+administrativo.getIdUsuario()+";";
        String sqlAdm= "UPDATE administrativo " +
                "SET area = '" +administrativo.getArea()
                +"', c_anios_experiencia = '" +administrativo.getExperienciaPrevia()
                + "' WHERE id_administrativo = "+administrativo.getIdAdministrativo();
        try {
            con= conexion.conectar();
            stmt= con.createStatement();
            stmt.executeUpdate(sqlUsu);
            stmt.executeUpdate(sqlAdm);
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

    @Override
    public boolean delete(int id_usuario) {
        boolean delete = false;
        Connection con= null;
        Statement stmt= null;

        String sqlAdm = "DELETE from administrativo where id_usuario = "
                +id_usuario+"; ";
        String sqlUsu = " Delete from Usuario where id_usuario = "+id_usuario;
        try {
            con= conexion.conectar();
            stmt= con.createStatement();
            stmt.execute(sqlAdm);
            stmt.execute(sqlUsu);
            delete=true;
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return delete;
    }

    @Override
    public Administrativo listOne(int id_usuario) {
        Administrativo adm = null;//instanciamos una clase Administrativo
        Statement stmt=null; //instanciamos el statement
        Connection con=null;//instanciamos el con
        ResultSet rs= null;//instanciamos el ResulSet que nos sirve para ejecutar comandos sql

        try {
            con= conexion.conectar();//llamamos a nuestra conexion de la bd
            stmt= con.createStatement();//llamamos a nuestros metodos executeQuery(), executeUpdate(),execute()
            rs = stmt.executeQuery("select * " +
                    "from usuario u " +
                    "inner join administrativo a " +
                    "on u.id_usuario = a.id_usuario " +
                    "where a.id_usuario = "+ id_usuario+
                    " Limit 1;");
            while (rs.next()){
                adm = new Administrativo(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4), LocalDate.parse(rs.getString(5)),
                        rs.getInt(6),rs.getString(7),rs.getInt(8),
                        rs.getInt(9),rs.getString(10),rs.getString(11));
                
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adm;
    }

}
