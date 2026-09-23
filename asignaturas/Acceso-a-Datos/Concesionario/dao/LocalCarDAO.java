package dao;

import java.util.*;
import java.nio.*;
import java.io.IOException;

import model.Car;

public class LocalCarDAO implements CarDAO {
    
    private List<Car> base_datos;

    public LocalCarDAO(List<Car> coches) {
        this.base_datos = coches;
    } 

    public void createCar(Car c)
    {
        this.base_datos.add(c);
    }
    
      public void getAll()
    {
        return this.base_datos;
    }  
    
    public void getBrand(String b)
    {
        List<Car> coches_marca = new ArrayList<>();
        for (Car c : this.base_datos)
        {
            if (c.getBrand().equals(b))
            {
                coches_marca.add(c);
            }
        }
    }
}
