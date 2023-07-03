package dao;

import models.Administrativo;
import models.Profesional;

import java.util.List;

public interface IProfesional {
    public boolean create(Profesional profesional);

    public boolean update(Profesional profesional);
    public boolean delete (int id);
    public List<Profesional> list();
    public Profesional listOne(int id_usuario);
    public boolean createPro(int id_usuario,Profesional profesional);
}
