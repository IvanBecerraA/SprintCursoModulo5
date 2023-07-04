package daoimpl;


import conexion.Conexion;
import dao.ICliente;
import models.Administrativo;
import models.Cliente;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class ClienteDaoImpl implements ICliente{

    @Override
    public boolean create(Cliente cliente) {
        boolean create = false;
        Connection con = null;
        Statement stmt = null;

        //String sqlUseSchema = "USE sql9628208";

        String sqlInsertUsuario = "INSERT INTO Usuario VALUES(null,\"" + cliente.getNombre() + "\"," +
                "\"" + cliente.getApellido1() + "\"," +
                "\"" + cliente.getApellido2() + "\"," +
                "\"" + cliente.getFechaNacimiento() + "\"," +
                "\"" + cliente.getRun() + "\"," +
                "\"" + cliente.getContrasenia() + "\"," +
                "\"" + cliente.getTipo_usuario() + "\");";

        String sqlInsertCliente = "INSERT INTO Cliente VALUES" +
                "(null,\"" + cliente.getRazonSocial() + "\"," +
                "\"" + cliente.getGiroEmpresa() + "\"," +
                "\"" + cliente.getRut() + "\"," +
                "\"" + cliente.getTelefonoRepresentante() + "\"," +
                "\"" + cliente.getDireccionEmpresa() + "\"," +
                "\"" + cliente.getComunaEmpresa() + "\"," +
                "(SELECT id_usuario FROM Usuario WHERE run = '" + cliente.getRun() + "'));";
        try {
            con = Conexion.getConexion();
            stmt = con.createStatement();
            //stmt.execute(sqlUseSchema);
            stmt.executeUpdate(sqlInsertUsuario);
            stmt.executeUpdate(sqlInsertCliente);
            create = true;
            stmt.close();
            // con.close();
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
        boolean update = false;
        Statement stmt = null;
        Connection con = null;

        String sqlUsu = "UPDATE Usuario " +
                "SET nombre = '" + cliente.getNombre() + "', " +
                "apellido1 = '" + cliente.getApellido1() + "', " +
                "apellido2 = '" + cliente.getApellido2() + "', " +
                "fecha_nacimiento = '" + cliente.getFechaNacimiento() + "', " +
                "contrasenia = '" + cliente.getContrasenia() + "' " +
                "WHERE id_usuario = " + cliente.getId_usuario();

        String sqlCli = "UPDATE Cliente " +
                "SET razon_social = '" + cliente.getRazonSocial() + "', " +
                "giro = '" + cliente.getGiroEmpresa() + "', " +
                "rut = '" + cliente.getRut() + "', " +
                "telefono = '" + cliente.getTelefonoRepresentante() + "', " +
                "direccion = '" + cliente.getDireccionEmpresa() + "', " +
                "comuna = '" + cliente.getComunaEmpresa() + "' " +
                "WHERE id_usuario = " + cliente.getId_usuario();


        try {
            con = Conexion.getConexion();
            stmt = con.createStatement();
            stmt.executeUpdate(sqlUsu);
            stmt.executeUpdate(sqlCli);
            update = true;
            stmt.close();
            //con.close();
            System.out.println("Se actualizó correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    @Override
    public boolean delete(int id) {
        boolean delete = false;
        Statement stmt = null;
        Connection con = null;

        String sqlUsuario = "DELETE FROM Usuario WHERE id_usuario = " + id + ";";
        String sqlCliente = "DELETE FROM Cliente WHERE id_usuario = " + id + ";";

        try {
            con = Conexion.getConexion();
            stmt = con.createStatement();
            stmt.executeUpdate(sqlCliente);
            stmt.executeUpdate(sqlUsuario);
            delete = true;
            stmt.close();
            System.out.println("Eliminación Cliente Correcta");
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar");
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public Cliente listOne(int id_usuario) {
        Cliente cl = null;//instanciamos una clase Cliente
        Statement stmt=null; //instanciamos el statement
        Connection con=null;//instanciamos el con
        ResultSet rs= null;//instanciamos el ResulSet que nos sirve para ejecutar comandos sql

        try {
            con= Conexion.getConexion();//llamamos a nuestra conexion de la bd
            stmt= con.createStatement();//llamamos a nuestros metodos executeQuery(), executeUpdate(),execute()
            rs = stmt.executeQuery("select * " +
                    "from prueba_bootcamp.Usuario u " +
                    "inner join prueba_bootcamp.Cliente c " +
                    "on u.id_usuario = c.id_usuario " +
                    "where c.id_usuario = "+ id_usuario+
                    " Limit 1;");
            while (rs.next()){
                cl = new Cliente(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4), LocalDate.parse(rs.getString(5)),
                        rs.getInt(6),rs.getString(7),rs.getInt(8),

                        rs.getInt(9),rs.getString(10),rs.getString(11),
                        rs.getInt(12),rs.getString(13),rs.getString(14),rs.getString(15));
                cl.setId_usuario(rs.getInt(1));

            }
            System.out.println("List Cliente "+cl.getId_usuario() );
            stmt.close();
            //con.close();
            System.out.println("List ID::"+cl.getId_usuario() +" Campo 2:"+cl.getNombre());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cl;
    }
}
