package dao;
import models.Usuario;

import java.sql.SQLException;
import java.util.List;
public interface IUsuario {
    public List<Usuario> list() throws SQLException;
}
