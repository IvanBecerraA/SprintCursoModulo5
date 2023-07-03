package dao;

import models.Administrativo;
import models.Cliente;
import java.util.List;

public interface ICliente {
    public boolean create(Cliente cliente);
    public List<Cliente> read();
    public boolean update(Cliente cliente);
    public boolean delete(int id);
    public Cliente listOne(int id_usuario);
}