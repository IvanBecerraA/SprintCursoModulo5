package daoimpl;

import dao.IAdministrativo;
import models.Administrativo;
import conexion.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AdministrativoDaoImpl
        implements IAdministrativo {

    @Override
    public boolean create(Administrativo administrativo) {
        boolean create = false;
        Connection con = null;
        Statement stmt = null;

        String sqlUseSchema = "USE nombre_esquema"; //TODO realizar ajustes cuando base de datos esté funcionando

        String sqlInsertUsuario = "INSERT INTO Usuario VALUES(null,\"" + administrativo.getNombre() + "\"," +
                "\"" + administrativo.getApellido1() + "\"," +
                "\"" + administrativo.getApellido2() + "\"," +
                "\"" + administrativo.getFechaNacimiento() + "\"," +
                "\"" + administrativo.getRun() + "\"," +
                "\"" + administrativo.getPassword() + "\"," +
                "\"" + administrativo.getTipo_usuario() + "\");";

        String sqlInsertAdministrativo = "INSERT INTO Administrativo (id_administrativo, area, c_anios_experiencia, id_usuario) VALUES" +
                "(null,\"" + administrativo.getArea() + "\"," +
                "\"" + administrativo.getExperienciaPrevia() + "\"," +
                "(SELECT id_usuario FROM Usuario WHERE run = '" + administrativo.getRun() + "'));";

        /*try {
            con = conexion.conectar(); //TODO cambiar nombre de clase que maneja singleton cuando haya sido crada
            stmt = con.createStatement();
            stmt.execute(sqlUseSchema);
            stmt.executeUpdate(sqlInsertUsuario);
            stmt.executeUpdate(sqlInsertAdministrativo);
            create = true;
            stmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/

        return create;
    }

    @Override
    public List<Administrativo> read() {
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
