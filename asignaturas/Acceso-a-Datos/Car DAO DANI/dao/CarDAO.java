package dao;

import java.util.List;
import model.Car;

public interface CarDAO {
    
    public void insertar(Car coche);
    public List<Car> obtenerTodos();
    public List<Car> obtenerMarca(String marca);

}
