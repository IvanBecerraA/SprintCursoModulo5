package dao;

import models.Administrativo;
import models.Profesional;
import models.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IAdministrativo {
    public boolean create(int id_usuario, Administrativo administrativo);
    public boolean update(Administrativo administrativo);
    public boolean delete(int id_usuario);
    public Administrativo listOne(int id_usuario);
    public boolean createAdm(int id_usuario,Administrativo administrativo);
}
