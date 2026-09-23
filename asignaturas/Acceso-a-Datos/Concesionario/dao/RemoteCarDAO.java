package dao;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RemoteCarDAO implements CarDAO {

    private File base_datos;

    public RemoteCarDAO(String ruta) {
        this.base_datos = new File(ruta);
    }

    public void createCar(Car c) {
        
    }

    public void getAll() {
    }

    public void getBrand(String b) {
        
    }
}
