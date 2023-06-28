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
        boolean create = false;
        Connection con = null;
        Statement stmt = null;

        String sqlUseSchema = "USE nombre_esquema"; //TODO realizar ajustes cuando base de datos esté funcionando

        String sqlInsertUsuario = "INSERT INTO Usuario VALUES(null,\"" + cliente.getNombre() + "\"," +
                "\"" + cliente.getApellido1() + "\"," +
                "\"" + cliente.getApellido2() + "\"," +
                "\"" + cliente.getFechaNacimiento() + "\"," +
                "\"" + cliente.getRun() + "\"," +
                "\"" + cliente.getPassword() + "\"," +
                "\"" + cliente.getTipo_usuario() + "\");";

        String sqlInsertAdministrativo = "INSERT INTO Profesional (titulo, fecha_ingreso) VALUES" +
                "(null,\"" + cliente.getRazonSocial() + "\"," +
                "\"" + cliente.getGiroEmpresa() + "\"," +
                "\"" + cliente.getRut() + "\"," +
                "\"" + cliente.getTelefonoRepresentante() + "\"," +
                "\"" + cliente.getDireccionEmpresa() + "\"," +
                "\"" + cliente.getComunaEmpresa() + "\"," +
                "(SELECT id_usuario FROM Usuario WHERE run = '" + cliente.getRun() + "'));";
        return create;
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
