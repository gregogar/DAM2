package dao;

import model.Producto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class remotoDAO implements genericDAO<Producto, Integer> {

    private String ruta, patron;
    private File fichero;

    public remotoDAO(String r, String p) {
        this.fichero = new File(r);
        this.patron = p;
    }

    @Override
    public void guardarTodos(List<Producto> e)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero)))
        {
            for (Producto p : e)
            {
                bw.write(p.getId() + patron + p.getPrecio() + patron + p.getNombre());
                bw.newLine();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        try (
            BufferedReader br = new BufferedReader(new FileReader(fichero));
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String [] atributos = linea.split(patron);
                if (atributos.length == 3) {
                    Producto p = new Producto (Integer.parseInt(atributos[0]), atributos[1],Double.parseDouble(atributos[2]));
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return productos;
    }

}