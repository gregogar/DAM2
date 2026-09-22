package dao;

import java.util.List;
import model.Car;

public interface CarDAO {
    void createCar(Car c);

    List<Car> getAll();

    String getBrand(String b);
}
