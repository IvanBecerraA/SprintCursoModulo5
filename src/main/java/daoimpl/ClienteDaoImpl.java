package daoimpl;

import dao.ICliente;
import models.Cliente;
import conexion.conexion;

import java.sql.*;
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
    public boolean update(Cliente cliente) {
        Connection con;
        boolean actualizar = false;

        /* Consultas preparadas:
        -Permiten pasar parámetros a las sentencas sql
        -Previene de ataques de inyección sql
        -Tienen mejor rendimiento, son dinámicas (Al ser precompiladas y reutilizables)
         Probaré usar este tipo de consulta*/

        String updateUsuario = "UPDATE usuario SET apellido1 =?, apellido2 =?, fecha_nacimiento =?," +
                "run =?, contrasenia =?, tipo_usuario =? WHERE id =?";
        String updateCliente = "UPDATE cliente SET razon_social =?, giro =?, rut=?," +
                "telefono =?, direccion =?, comuna =? WHERE id =?";
/*
        try {
            con = conexion.conectar(); //Esperando clase Conexion
            PreparedStatement pstmU = con.prepareStatement(updateUsuario);
            pstmU.executeQuery();
            pstmU.setString(1, cliente.getNombre());
            pstmU.setString(2, cliente.getApellido1());
            pstmU.setString(3, cliente.getApellido2());
            pstmU.setDate(4, (Date) cliente.getFechaNacimiento());
            pstmU.setInt(5, cliente.getRun());
            pstmU.setString(6, cliente.getPassword());
            pstmU.setInt(7, cliente.getIdUsuario());



            PreparedStatement pstmC = con.prepareStatement(updateCliente);
            pstmC.executeQuery();
            pstmC.setString(1, cliente.getRazonSocial());
            pstmC.setString(2, cliente.getGiroEmpresa());
            pstmC.setInt(3, cliente.getRut());
            pstmC.setString(4, cliente.getTelefonoRepresentante());
            pstmC.setString(5, cliente.getDireccionEmpresa());
            pstmC.setString(6, cliente.getComunaEmpresa());
            pstmU.setInt(7, cliente.getIdUsuario());
            actualizar = pstmC.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/

        return actualizar;
    }

    @Override
    public boolean delete(int id) {

            return false;
        }
    }
