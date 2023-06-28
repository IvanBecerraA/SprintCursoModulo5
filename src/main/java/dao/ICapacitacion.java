package dao;

import models.Capacitacion;

import java.util.List;

public interface ICapacitacion {

    boolean create(Capacitacion capacitacion);

    List<Capacitacion> read();

    boolean update(Capacitacion capacitacion);

    boolean delete(Capacitacion capacitacion);

}
