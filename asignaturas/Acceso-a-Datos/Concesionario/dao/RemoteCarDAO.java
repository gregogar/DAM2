package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class RemoteCarDAO implements CarDAO {

    private File base_datos;

    public RemoteCarDAO(String ruta) {
        this.base_datos = new File(ruta);
    }

    public void createCar(Car c) {
        try (
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(c.getBrand() + ";" + c.getModel() + ";" + c.getYear() + "\n");

        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
        }
    }

    public List<Car> getAll() {
        List<Car> lista_aux = new ArrayList<>();
        try (BufferedReader br = new FileReader(base_datos)) {
            String linea;
            while (linea = br.readLine() != null) {
                String[] aux = linea.split(";");
                int i = Integer.parseInt(aux[2]);
                Car new_car = new Car(aux[0], aux[1], i);
                lista_aux.add(new_car);
            }
        } catch (Exception e) {
            System.out.println(" ERROR ");
        }
        return lista_aux;
    }

    public void getBrand(String b) {
        
    }
}
