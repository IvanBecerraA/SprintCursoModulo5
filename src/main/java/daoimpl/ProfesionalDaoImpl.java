package daoimpl;

import conexion.Conexion;
import dao.IProfesional;
import models.Profesional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalDaoImpl implements IProfesional {
    @Override
    public boolean create(Profesional profesional) {
        boolean create = false;
        Connection con = null;
        Statement stmt = null;

        String sqlUseSchema = "USE sql9628208";

        String sqlInsertUsuario = "INSERT INTO Usuario VALUES(null,\"" + profesional.getNombre() + "\"," +
                "\"" + profesional.getApellido1() + "\"," +
                "\"" + profesional.getApellido2() + "\"," +
                "\"" + profesional.getFechaNacimiento() + "\"," +
                "\"" + profesional.getRun() + "\"," +
                "\"" + profesional.getContrasenia() + "\"," +
                "\"" + profesional.getTipo_usuario() + "\");";

        String sqlInsertProfesional = "INSERT INTO Profesional (id_usuario, titulo,fecha_ingreso) VALUES" +
                "((SELECT id_usuario FROM Usuario WHERE run = '\" + profesional.getRun() + \"'),"+
                "\"" + profesional.getTitulo() + "\"," +
                "\"" + profesional.getFecha_ingreso() + "\");";
        try {
            con = Conexion.getConexion();
            stmt = con.createStatement();
            stmt.execute(sqlUseSchema);
            stmt.executeUpdate(sqlInsertUsuario);
            stmt.executeUpdate(sqlInsertProfesional);
            create = true;
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return create;
    }

    @Override
    public List<Profesional> read() {
        String sql = "SELECT id_profesional, id_user, titulo, fecha_ingreso from profesional" ;
        List<Profesional> profesional = new ArrayList<>();

/*
        try {
            connection = ConexionDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                profesional.add(new Profesional(resultSet.getInt("id_professional"),
                        resultSet.getString("id_user"),
                        resultSet.getString("titulo"),
                        resultSet.getString("fecha_ingreso"),));
            }

            statement.close();
            resultSet.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ProfesionalDaoImpl, método readAll");
            e.printStackTrace();
        }*/

        return profesional;

    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean update(Profesional profesional) {
        Connection con;
        boolean update = false;

        /* Consultas preparadas:
        -Permiten pasar parámetros a las sentencas sql
        -Previene de ataques de inyección sql
        -Tienen mejor rendimiento, son dinámicas (Al ser precompiladas y reutilizables)
         Probaré usar este tipo de consulta*/

        String updateUsuario = "UPDATE Usuario SET nombre =?, apellido1 =?, apellido2 =?," +
                "fecha_nacimiento =?, run =?, contrasenia =?, tipo_usuario =? WHERE id_usuario =?";
        String updateProfesional = "UPDATE Profesional SET titulo =?, fecha_ingreso =?" +
                " WHERE id_usuario =?";

        try {
            con = Conexion.getConexion();
            PreparedStatement pstmU = con.prepareStatement(updateUsuario);
            pstmU.executeQuery();
            pstmU.setString(1, profesional.getNombre());
            pstmU.setString(2, profesional.getApellido1());
            pstmU.setString(3, profesional.getApellido2());
            //pstmU.setDate(4, cliente.getFechaNacimiento()); TODO CASTEAR A LOCALDATE
            pstmU.setInt(5, profesional.getRun());
            pstmU.setString(6, profesional.getContrasenia());
            pstmU.setInt(7, profesional.getTipo_usuario()); //
            pstmU.setInt(8, profesional.getId_usuario()); //

            PreparedStatement pstmC = con.prepareStatement(updateProfesional);
            pstmC.executeQuery();
            pstmC.setString(1, profesional.getTitulo());
            pstmC.setDate(2, Date.valueOf(profesional.getFecha_ingreso()));

            update = pstmC.executeUpdate() > 0;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return update;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


}




