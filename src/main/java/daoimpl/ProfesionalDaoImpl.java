package daoimpl;

import conexion.Conexion;
import dao.IProfesional;
import models.Administrativo;
import models.Profesional;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalDaoImpl implements IProfesional {
    @Override
    public boolean create(Profesional profesional) {
        boolean create = false;
        Connection con = null;
        Statement stmt = null;

        //String sqlUseSchema = "USE sql9628208";

        String sqlInsertUsuario = "INSERT INTO Usuario VALUES(null,\"" + profesional.getNombre() + "\"," +
                "\"" + profesional.getApellido1() + "\"," +
                "\"" + profesional.getApellido2() + "\"," +
                "\"" + profesional.getFechaNacimiento() + "\"," +
                "\"" + profesional.getRun() + "\"," +
                "\"" + profesional.getContrasenia() + "\"," +
                "\"" + profesional.getTipo_usuario() + "\");";

        String sqlInsertProfesional = "INSERT INTO prueba_bootcamp.Profesional (id_profesional, id_usuario, titulo, fecha_ingreso) VALUES (" +
                "null, (SELECT id_usuario FROM Usuario WHERE run = " + profesional.getRun() + ")," +
                "\"" + profesional.getTitulo() + "\"," +
                "\"" + profesional.getFecha_ingreso() + "\");";
        try {
            con = Conexion.getConexion();
            stmt = con.createStatement();
            //stmt.execute(sqlUseSchema);
            stmt.executeUpdate(sqlInsertUsuario);
            stmt.executeUpdate(sqlInsertProfesional);
            create = true;
            stmt.close();
            //con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return create;
    }

    @Override
    public List<Profesional> read() {
        String sql = "SELECT id_profesional, id_user, titulo, fecha_ingreso from profesional" ;
        List<Profesional> profesional = new ArrayList<>();

/*
        try {
            connection = ConexionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                profesional.add(new Profesional(resultSet.getInt("id_professional"),
                        resultSet.getString("id_user"),
                        resultSet.getString("titulo"),
                        resultSet.getString("fecha_ingreso"),));
            }

            statement.close();
            resultSet.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ProfesionalDaoImpl, método readAll");
            e.printStackTrace();
        }*/

        return profesional;

    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean update(Profesional profesional) {
        boolean update = false;
        Statement stmt = null;
        Connection con = null;

        String sqlUsu = "UPDATE Usuario " +
                "SET nombre = '" + profesional.getNombre() + "', " +
                "apellido1 = '" + profesional.getApellido1() + "', " +
                "apellido2 = '" + profesional.getApellido2() + "', " +
                "fecha_nacimiento = '" + profesional.getFechaNacimiento() + "', " +
                "contrasenia = '" + profesional.getContrasenia() + "' " +
                "WHERE id_usuario = " + profesional.getId_usuario();

        String sqlAdm = "UPDATE Profesional " +
                "SET titulo = '" + profesional.getTitulo() + "', " +
                "fecha_ingreso = '" + profesional.getFecha_ingreso() + "' " +
                "WHERE id_usuario = " + profesional.getId_usuario();

        try {
            con = Conexion.getConexion();
            stmt = con.createStatement();
            stmt.executeUpdate(sqlUsu);
            stmt.executeUpdate(sqlAdm);
            update = true;
            stmt.close();
            //con.close();
            System.out.println("Se actualizó correctamente profesional.");
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
    public Object listOne(int idUsuario) {

        Profesional pro = null;//instanciamos una clase Administrativo
        Statement stmt=null; //instanciamos el statement
        Connection con=null;//instanciamos el con
        ResultSet rs= null;//instanciamos el ResulSet que nos sirve para ejecutar comandos sql
        System.out.println(pro);
        System.out.println(idUsuario);

        try {
            con= Conexion.getConexion();//llamamos a nuestra conexion de la bd
            stmt= con.createStatement();//llamamos a nuestros metodos executeQuery(), executeUpdate(),execute()
            rs = stmt.executeQuery("select * " +
                    "from Usuario u " +
                    "inner join Profesional p " +
                    "on u.id_usuario = p.id_usuario " +
                    "where p.id_usuario = "+ idUsuario+
                    " Limit 1;");

            if(rs.next()){
                pro = new Profesional(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4), LocalDate.parse(rs.getString(5)),
                        rs.getInt(6),rs.getString(7),rs.getInt(8),
                        rs.getInt(9),rs.getString(11),LocalDate.parse(rs.getString(12)));
                pro.setId_usuario(rs.getInt(1));
            }


            stmt.close();
            //con.close();
            System.out.println("List ID::"+pro.getId_usuario() +" Campo 2:"+pro.getNombre());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pro;
    }

}




