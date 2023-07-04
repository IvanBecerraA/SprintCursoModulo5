package dao;

import models.Administrativo;
import models.Profesional;

import java.util.List;

public interface IProfesional {
    public boolean create(Profesional profesional);
    public List<Profesional> read();
    public boolean update(int id);

    boolean update(Profesional profesional);

    public boolean delete (int id);


    Object listOne(int idUsuario);
}

