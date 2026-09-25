package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import model.Car;

public class RemoteCarDAO implements CarDAO {

    private File base_datos;
    private String patron;

    public RemoteCarDAO(String ruta) {
        this.base_datos = new File(ruta);
        this.patron = ";";
    }

    public RemoteCarDAO(String ruta, String patron) {
        this.base_datos = new File(ruta);
        this.patron = patron;
    }

    @Override
    public void insertar(Car coche) {
        try (
            FileWriter fw = new FileWriter(this.base_datos, true);
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write(coche.getMarca() + patron + coche.getModelo() + patron + coche.getAnoFabricacion());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Car> obtenerTodos() {
        List<Car> coches = new ArrayList<>();
        try (
            FileReader fr = new FileReader(this.base_datos);
            BufferedReader br = new BufferedReader(fr);
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Car c = new Car(
                    linea.split(";")[0],
                    linea.split(";")[1],
                    Integer.parseInt(linea.split(";")[2])
                );
                coches.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return coches;
    }

    @Override
    public List<Car> obtenerMarca(String marca) {
        List<Car> coches = new ArrayList<>();
        try (
            FileReader fr = new FileReader(this.base_datos);
            BufferedReader br = new BufferedReader(fr);
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {

                String [] atributos = linea.split(";");
                if (atributos[0].equals(marca)){
                    Car c = new Car(
                        atributos[0],
                        atributos[1],
                        Integer.parseInt(atributos[2])
                    );
                    coches.add(c);
                }
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return coches;

        /*
        List<Car> coches = obtenerTodos();
        List<Car> coches_marca = new ArrayList<>();
        for (Car c : coches){
            if (c.getMarca().equals(marca)){
                coches_marca.add(c);
            }
        }
        return coches
        */
    }
    
}
