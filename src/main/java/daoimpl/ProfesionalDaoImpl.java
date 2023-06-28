package daoimpl;

import dao.IProfesional;
import models.Administrativo;
import models.Capacitacion;
import models.Profesional;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfesionalDaoImpl implements IProfesional {
    @Override
    public boolean create(Profesional profesional) {
        boolean create = false;
        Connection con = null;
        Statement stmt = null;

        String sqlUseSchema = "USE nombre_esquema"; //TODO realizar ajustes cuando base de datos esté funcionando

        String sqlInsertUsuario = "INSERT INTO Usuario VALUES(null,\"" + profesional.getNombre() + "\"," +
                "\"" + profesional.getApellido1() + "\"," +
                "\"" + profesional.getApellido2() + "\"," +
                "\"" + profesional.getFechaNacimiento() + "\"," +
                "\"" + profesional.getRun() + "\"," +
                "\"" + profesional.getPassword() + "\"," +
                "\"" + profesional.getTipo_usuario() + "\");";

        String sqlInsertProfesional = "INSERT INTO Profesional (id_professional, id_user, titulo, fecha_ingreso) VALUES" +
                "(null,\"" + profesional.getTipo_usuario() + "\"," +
                "\"" + profesional.getFecha_ingreso() + "\"," +
                "(SELECT id_usuario FROM Usuario WHERE run = '" + profesional.getRun() + "'));";

        /*try {
            con = conexion.conectar(); //TODO cambiar nombre de clase que maneja singleton cuando haya sido crada
            stmt = con.createStatement();
            stmt.execute(sqlUseSchema);
            stmt.executeUpdate(sqlInsertUsuario);
            stmt.executeUpdate(sqlInsertprofesional);
            create = true;
            stmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/

        return create;
    }
    @Override
    public List<Profesional> read() {
        String sql = "SELECT id_profesional, id_user, titulo, fecha_ingreso";
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
    public boolean delete(int id) {
        return false;
    }


}




