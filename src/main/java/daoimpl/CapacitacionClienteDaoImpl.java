package daoimpl;

import conexion.Conexion;
import dao.ICliente;
import models.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionClienteDaoImpl implements ICliente {

    Connection connection = null;

    @Override
    public boolean create(Cliente cliente) {
        return false;
    }

    @Override
    public List<Cliente> read() {

        String sql = "SELECT id_cliente, rut FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();

        try {
            connection = Conexion.getConexion();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setRut(resultSet.getInt("rut"));
                clientes.add(cliente);
            }
            statement.close();
            resultSet.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase CapacitacionClienteDaoImpl, método read");
            e.printStackTrace();
        }

        return clientes;

    }

    @Override
    public boolean update(Cliente cliente) {
        return false;
    }

    @Override
    public boolean delete(int id) { //Cambié el tipo de dato pero no afecta en tu código
        return false;              // Cualquier cosas me hablas o borras este comentario jeje salutes
    }
}
