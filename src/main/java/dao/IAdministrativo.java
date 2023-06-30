package dao;

import models.Administrativo;

import java.util.List;

public interface IAdministrativo {

    public boolean create(Administrativo administrativo);

    public List<Administrativo> read();

    public boolean update(int id);

    public boolean delete(int id);
    public Administrativo listOne(int id_usuario);

}
