package dao;

import models.Profesional;

import java.util.List;

public interface IProfesional {
    public boolean crear(Profesional profesional);

    public boolean actualizar(int id);
    public boolean eliminar (int id);
    public List<Profesional> lista();
}
