package dao;

import models.Cliente;
import java.util.List;

public interface ICliente {
    public boolean create(Cliente cliente);
    public List<Cliente> read();
    public boolean update(int id);
    public boolean delete(int id);
}