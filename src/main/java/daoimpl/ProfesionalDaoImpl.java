package daoimpl;

import conexion.Conexion;
import dao.IProfesional;
import models.Profesional;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
                "\"" + profesional.getContrasenia() + "\"," +
                "\"" + profesional.getTipo_usuario() + "\");";

        String sqlInsertAdministrativo = "INSERT INTO Profesional (titulo, fecha_ingreso) VALUES" +
                "(null,\"" + profesional.getTitulo() + "\"," +
                "\"" + profesional.getFecha_ingreso() + "\"," +
                "(SELECT id_usuario FROM Usuario WHERE run = '" + profesional.getRun() + "'));";
        try {
            con = Conexion.getConexion(); //TODO cambiar nombre de clase que maneja singleton cuando haya sido crada
            stmt = con.createStatement();
            stmt.execute(sqlUseSchema);
            stmt.executeUpdate(sqlInsertUsuario);
            stmt.executeUpdate(sqlInsertAdministrativo);
            create = true;
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return create;
    }

    @Override
    public boolean update(int id) {


        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Profesional> list() {
        return null;
    }
}
