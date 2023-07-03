package daoimpl;

import conexion.conexion;
import dao.IProfesional;
import models.Administrativo;
import models.Profesional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class ProfesionalDaoImpl implements IProfesional {
    @Override
    public boolean create(Profesional profesional) {
        return false;
    }

    @Override
    public boolean update(Profesional profesional) {
        boolean update = false;
        Statement stmt=null;
        Connection con=null;

        String sqlAdm= "UPDATE administrativo " +
                "SET titulo = '" +profesional.getTitulo()
                +"', fecha_ingreso = '" +profesional.getTitulo()
                + "' WHERE id_usuario = "+profesional.getId_user();
        try {
            con= conexion.conectar();
            stmt= con.createStatement();
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
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Profesional> list() {
        return null;
    }

    @Override
    public Profesional listOne(int id_usuario) {
        Profesional pro = null;//instanciamos una clase Administrativo
        Statement stmt=null; //instanciamos el statement
        Connection con=null;//instanciamos el con
        ResultSet rs= null;//instanciamos el ResulSet que nos sirve para ejecutar comandos sql

        try {
            con= conexion.conectar();//llamamos a nuestra conexion de la bd
            stmt= con.createStatement();//llamamos a nuestros metodos executeQuery(), executeUpdate(),execute()
            rs = stmt.executeQuery("select * "
                    +"from profesional "
                    +"where id_usuario = "+ id_usuario
                    +" Limit 1");
            if (rs.next()) { // Verificar si hay filas en el conjunto de resultados
                pro = new Profesional(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        LocalDate.parse( rs.getString(4)));
            }else{
                pro = new Profesional();
            }

            stmt.close();

            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pro;
    }

    @Override
    public boolean createPro(int id_usuario, Profesional profesional) {
        boolean create = false;
        Connection con= null;
        Statement stmt= null;

        String sql=
                " INSERT INTO Profesional VALUES(null, "
                        +id_usuario+", '"
                        +profesional.getTitulo()+"',"
                        +profesional.getFecha_ingreso()+"');";
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
}
