package daoimpl;

import dao.ICapacitacion;
import models.Capacitacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionDaoImpl implements ICapacitacion {

    Connection connection = null;


    @Override
    public boolean create(Capacitacion capacitacion) {
        boolean crear = false;

        String sql = "INSERT INTO capacitacion VALUES " +
                "(null, '"+
                capacitacion.getRutCliente() +"', '"+
                capacitacion.getDia() +"', '"+
                capacitacion.getHora() +"', '"+
                capacitacion.getLugar() +"', '"+
                capacitacion.getDuracion() +"', '"+
                capacitacion.getCantidadAsistentes() +"')";

/*
        try {
            connection = ConexionDB.getConnection(); // cambiar el nombre de la clase Singleton de la DB
            Statement statement = connection.createStatement();
            statement.execute(sql);
            crear = true;
            statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase CapacitacionDaoImpl, método create");
            e.printStackTrace();
        }*/
        return crear;
    }

    @Override
    public List<Capacitacion> read() {
        String sql = "SELECT id, rut_empresa, dia, hora, lugar, duracion, cantidad_asistentes FROM capacitacion";
        List<Capacitacion> capacitaciones = new ArrayList<>();

/*
        try {
            connection = ConexionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                capacitaciones.add(new Capacitacion(resultSet.getInt("id"),
                        resultSet.getString("rut_empresa"),
                        resultSet.getString("dia"),
                        resultSet.getString("hora"),
                        resultSet.getString("lugar"),
                        resultSet.getString("duracion"),
                        resultSet.getInt("cantidad_asistentes")));
            }
            statement.close();
            resultSet.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase CapacitacionDaoImpl, método readAll");
            e.printStackTrace();
        }*/

        return capacitaciones;
    }

    @Override
    public boolean update(Capacitacion capacitacion) {
        return false;
    }

    @Override
    public boolean delete(Capacitacion capacitacion) {
        return false;
    }
}
