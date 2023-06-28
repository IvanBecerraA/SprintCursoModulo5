package daoimpl;

import dao.ICliente;
import models.Cliente;
import conexion.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

       /* try {
            con = conexion.conectar(); //Esperando clase Conexion
            PreparedStatement pstmU = con.prepareStatement(updateUsuario);
            pstmU.executeQuery();
            pstmU.setString(2, usuario.getNombre());
            pstmU.setString(3, usuario.getApellido1());
            pstmU.setInt(4, usuario.getApellido2());
            pstmU.setString(5, usuario.getFechaNacimiento());
            pstmU.setString(6, usuario.getRun());
            pstmU.setString(7, usuario.getPassword());
            pstmU.setString(7, usuario.getTipo_usuario());


            PreparedStatement pstmC = con.prepareStatement(updateCliente);
            pstmC.executeQuery();
            pstmC.setString(2, cliente.getRazonSocial());
            pstmC.setString(3, cliente.getGiroEmpresa());
            pstmC.setInt(4, cliente.getRut());
            pstmC.setString(5, cliente.getTelefonoRepresentante());
            pstmC.setString(6, cliente.getDireccionEmpresa());
            pstmC.setString(7, cliente.getComunaEmpresa());


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
