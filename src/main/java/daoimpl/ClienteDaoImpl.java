package daoimpl;

import conexion.Conexion;
import dao.ICliente;
import models.Cliente;

import java.sql.*;
import java.util.List;

public class ClienteDaoImpl implements ICliente{

    @Override
    public boolean create(Cliente cliente) {
        boolean create = false;
        Connection con = null;
        Statement stmt = null;

        String sqlUseSchema = "USE sql9628208"; //TODO realizar ajustes cuando base de datos esté funcionando

        String sqlInsertUsuario = "INSERT INTO Usuario VALUES(null,\"" + cliente.getNombre() + "\"," +
                "\"" + cliente.getApellido1() + "\"," +
                "\"" + cliente.getApellido2() + "\"," +
                "\"" + cliente.getFechaNacimiento() + "\"," +
                "\"" + cliente.getRun() + "\"," +
                "\"" + cliente.getContrasenia() + "\"," +
                "\"" + cliente.getTipo_usuario() + "\");";

        String sqlInsertCliente = "INSERT INTO Cliente (titulo, fecha_ingreso) VALUES" + // TODO hola, checkear los atributos de la tabla
                "(null,\"" + cliente.getRazonSocial() + "\"," +
                "\"" + cliente.getGiroEmpresa() + "\"," +
                "\"" + cliente.getRut() + "\"," +
                "\"" + cliente.getTelefonoRepresentante() + "\"," +
                "\"" + cliente.getDireccionEmpresa() + "\"," +
                "\"" + cliente.getComunaEmpresa() + "\"," +
                "(SELECT id_usuario FROM Usuario WHERE run = '" + cliente.getRun() + "'));";
        try {
            con = Conexion.getConexion(); //TODO cambiar nombre de clase que maneja singleton cuando haya sido crada
            stmt = con.createStatement();
            stmt.execute(sqlUseSchema);
            stmt.executeUpdate(sqlInsertUsuario);
            stmt.executeUpdate(sqlInsertCliente);
            create = true;
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return create;
    }

    @Override
    public List<Cliente> read() {
        return null;
    }

    @Override
    public boolean update(Cliente cliente) {
        Connection con;
        boolean update = false;

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
            pstmU.setInt(7, cliente.getIdUsuario()); // TODO USUARIO YA NO TIENE ID?

            PreparedStatement pstmC = con.prepareStatement(updateCliente);
            pstmC.executeQuery();
            pstmC.setString(1, cliente.getRazonSocial());
            pstmC.setString(2, cliente.getGiroEmpresa());
            pstmC.setInt(3, cliente.getRut());
            pstmC.setString(4, cliente.getTelefonoRepresentante());
            pstmC.setString(5, cliente.getDireccionEmpresa());
            pstmC.setString(6, cliente.getComunaEmpresa());
            pstmU.setInt(7, cliente.getIdUsuario()); // TODO USUARIO YA NO TIENE ID?
            actualizar = pstmC.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/

        return update;
    }

    @Override
    public boolean delete(Cliente cliente) {

        Connection con;
        boolean delete = false;
        String deleteUsuario = "DELETE FROM usuario WHERE id_usuario =?";
        String deleteCliente = "DELETE FROM cliente WHERE id_usuario =?";

  /*      try{
            con = Conexion.getConexion();
            PreparedStatement pstmU = con.prepareStatement(deleteUsuario);
            pstmU.setInt(1, cliente.getRun()); // TODO EN VEZ DE USAR EL ID USÉ EL RUN

            PreparedStatement pstmC = con.prepareStatement(deleteCliente);
            pstmC.setInt(1, cliente.getRut()); // VER QUÉ SE TOMA POR PARÁMETRO PARA ELIMINAR
                                                            // CLIENTE DE LA TABLA CLIENTE ...

            delete = pstmU.executeUpdate() > 0 && pstmC.executeUpdate() > 0;
            // Si se realizó la consulta el método executeUpdate
            // retorna 1, si 1 > 0 = true => delete() retorna true

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

   */

        return delete;
        }
    }
