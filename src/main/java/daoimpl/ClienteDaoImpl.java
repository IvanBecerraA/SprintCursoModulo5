package daoimpl;

import dao.ICliente;
import models.Cliente;
import conexion.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClienteDaoImpl implements ICliente{

    @Override
    public boolean create(Cliente cliente) {
        return false;
    }

    @Override
    public List<Cliente> read() {
        return null;
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
