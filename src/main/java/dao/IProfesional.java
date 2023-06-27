package dao;

import models.Profesional;

import java.util.List;

public interface IProfesional {
    public boolean create(Profesional profesional);
    public boolean update(int id);
    public boolean delete (int id);
    public List<Profesional> list();
}