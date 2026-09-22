package dao;

import java.util.List;
import model.Car;

public interface CarDAO {
    public void createCar(Car c);

    public List<Car> getAll();

    public List<Car> getBrand(String b);
}
