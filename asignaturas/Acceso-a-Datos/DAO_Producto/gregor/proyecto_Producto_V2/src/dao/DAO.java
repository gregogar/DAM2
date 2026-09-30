package dao;
import java.util.List;

import model.Producto;

public interface DAO {
    public void guardarTodos(List<Producto> p);
    public List<Producto> listarTodos();
}
