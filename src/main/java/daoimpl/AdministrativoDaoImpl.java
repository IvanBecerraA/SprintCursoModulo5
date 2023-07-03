package daoimpl;

import conexion.Conexion;
import dao.IAdministrativo;
import models.Administrativo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class AdministrativoDaoImpl
        implements IAdministrativo {

    @Override
    public boolean create(Administrativo administrativo) {
        boolean create = false;
        Connection con = null;
        Statement stmt = null;

        //String sqlUseSchema = "USE sprint_m5";

        String sqlInsertUsuario = "INSERT INTO Usuario VALUES(null,\"" + administrativo.getNombre() + "\"," +
                "\"" + administrativo.getApellido1() + "\"," +
                "\"" + administrativo.getApellido2() + "\"," +
                "\"" + administrativo.getFechaNacimiento() + "\"," +
                "\"" + administrativo.getRun() + "\"," +
                "\"" + administrativo.getContrasenia() + "\"," +
                "\"" + administrativo.getTipo_usuario() + "\");";

        String sqlInsertAdministrativo = "INSERT INTO Administrativo (id_administrativo, area, c_anios_experiencia, id_usuario) VALUES" +
                "(null,\"" + administrativo.getArea() + "\"," +
                "\"" + administrativo.getExperienciaPrevia() + "\"," +
                "(SELECT id_usuario FROM Usuario WHERE run = '" + administrativo.getRun() + "'));";

        try {
            con = Conexion.getConexion();
            stmt = con.createStatement();
            //stmt.execute(sqlUseSchema);
            stmt.executeUpdate(sqlInsertUsuario);
            stmt.executeUpdate(sqlInsertAdministrativo);
            create = true;
            stmt.close();
            //con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return create;
    }

    @Override
    public List<Administrativo> read() {
        return null;
    }

    @Override
    public boolean update(Administrativo administrativo) {
        boolean update = false;
        Statement stmt = null;
        Connection con = null;

        String sqlUsu = "UPDATE Usuario " +
                "SET nombre = '" + administrativo.getNombre() + "', " +
                "apellido1 = '" + administrativo.getApellido1() + "', " +
                "apellido2 = '" + administrativo.getApellido2() + "', " +
                "fecha_nacimiento = '" + administrativo.getFechaNacimiento() + "', " +
                "contrasenia = '" + administrativo.getContrasenia() + "' " +
                "WHERE id_usuario = " + administrativo.getId_usuario();

        String sqlAdm = "UPDATE Administrativo " +
                "SET area = '" + administrativo.getArea() + "', " +
                "c_anios_experiencia = '" + administrativo.getExperienciaPrevia() + "' " +
                "WHERE id_usuario = " + administrativo.getId_usuario();

        try {
            con = Conexion.getConexion();
            stmt = con.createStatement();
            stmt.executeUpdate(sqlUsu);
            stmt.executeUpdate(sqlAdm);
            update = true;
            stmt.close();
            //con.close();
            System.out.println("Se actualizó correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }


    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Administrativo listOne(int id_usuario) {

        Administrativo adm = null;//instanciamos una clase Administrativo
        Statement stmt=null; //instanciamos el statement
        Connection con=null;//instanciamos el con
        ResultSet rs= null;//instanciamos el ResulSet que nos sirve para ejecutar comandos sql

        try {
            con= Conexion.getConexion();//llamamos a nuestra conexion de la bd
            stmt= con.createStatement();//llamamos a nuestros metodos executeQuery(), executeUpdate(),execute()
            rs = stmt.executeQuery("select * " +
                    "from Usuario u " +
                    "inner join Administrativo a " +
                    "on u.id_usuario = a.id_usuario " +
                    "where a.id_usuario = "+ id_usuario+
                    " Limit 1;");

            if(rs.next()){
                adm = new Administrativo(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4), LocalDate.parse(rs.getString(5)),
                        rs.getInt(6),rs.getString(7),rs.getInt(8),
                        rs.getInt(9),rs.getString(10),rs.getInt(11));
                adm.setId_usuario(rs.getInt(1));
            }

            stmt.close();
            //con.close();
            System.out.println("List ID::"+adm.getId_usuario() +" Campo 2:"+adm.getNombre());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adm;
    }
}
