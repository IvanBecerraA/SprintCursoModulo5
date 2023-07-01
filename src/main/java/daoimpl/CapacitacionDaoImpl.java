package daoimpl;

import conexion.Conexion;
import dao.ICapacitacion;
import models.Capacitacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionDaoImpl implements ICapacitacion {

    Connection connection = null;


    @Override
    public boolean create(Capacitacion capacitacion) {
        boolean crear = false;

        String sql = "INSERT INTO Capacitacion VALUES " +
                "(null, '"+
                capacitacion.getRutCliente() +"', '"+
                capacitacion.getFecha() +"', '"+
                capacitacion.getHora() +"', '"+
                capacitacion.getLugar() +"', '"+
                capacitacion.getDuracion() +"', '"+
                capacitacion.getCantidadAsistentes() +"')";

        try {
            connection = Conexion.getConexion();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            crear = true;
            statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase CapacitacionDaoImpl, método create");
            e.printStackTrace();
        }
        return crear;
    }

    @Override
    public List<Capacitacion> read() {
        String sql = "SELECT id_capacitacion, id_cliente, fecha_capacitacion, hora, lugar, duracion, c_asistentes FROM Capacitacion";
        List<Capacitacion> capacitaciones = new ArrayList<>();


        try {
            connection = Conexion.getConexion();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                capacitaciones.add(new Capacitacion(resultSet.getInt("id_capacitacion"),
                        resultSet.getInt("id_cliente"),
                        LocalDate.parse(resultSet.getString("fecha_capacitacion")),
                        LocalTime.parse(resultSet.getString("hora")),
                        resultSet.getString("lugar"),
                        resultSet.getInt("duracion"),
                        resultSet.getInt("c_asistentes")));
            }
            statement.close();
            resultSet.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase CapacitacionDaoImpl, método read");
            e.printStackTrace();
        }

        return capacitaciones;
    }

    @Override
    public boolean update(Capacitacion capacitacion) {

        boolean actualizar = false;

        String sql = "UPDATE Capacitacion\n" +
                "SET\n" +
                "id_capacitacion = "+ capacitacion.getId() +", " +
                "id_cliente = "+ capacitacion.getRutCliente() +", " +
                "fecha_capacitacion = \""+ capacitacion.getFecha() +"\", " +
                "hora = \""+ capacitacion.getHora() +"\", " +
                "lugar = \""+ capacitacion.getLugar() +"\", " +
                "duracion = "+ capacitacion.getDuracion() +", " +
                "c_asistentes = "+ capacitacion.getCantidadAsistentes() +"\n" +
                "WHERE id_capacitacion = "+ capacitacion.getId() +";";

        try {
            connection = Conexion.getConexion();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            actualizar = true;
            statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase CapacitacionDaoImpl, método update");
            e.printStackTrace();
        }

        return actualizar;
    }

    @Override
    public boolean delete(int id) {

        boolean eliminar = false;

        String sql = "DELETE FROM Capacitacion WHERE id_capacitacion = "+ id +";";

        try {
            connection = Conexion.getConexion();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            eliminar = true;
            statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase CapacitacionDaoImpl, método delete");
            e.printStackTrace();
        }

        return eliminar;
    }
}
