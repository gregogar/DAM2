package dao;
import java.util.List;

public interface genericDAO<E, ID>
{
    public void guardarTodos(List<E> e);
    public List<E> listarTodos();
}
