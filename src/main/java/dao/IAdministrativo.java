package dao;

import models.Administrativo;
import models.Profesional;
import models.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IAdministrativo {
    public boolean create(int id_usuario, Administrativo administrativo);
    public boolean update(int id_administrativo, Administrativo administrativo);
    public boolean delete(int id_administrativo);
    public List<Usuario> list() throws SQLException;
}
