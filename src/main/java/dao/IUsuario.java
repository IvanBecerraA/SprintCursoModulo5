package dao;

import models.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuario {
    public List<Usuario> list() throws SQLException;

    public Usuario listOne(int id_usuario);
    public boolean update(Usuario usuario);
}
