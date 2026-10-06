package dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductoDAOBinario implements ProductoDAO {

    private File fichero;

    public ProductoDAOBinario(String r) {
        this.fichero = new File(r);
    }

    @Override
    public void guardarTodos(List<Producto> productos) {
        try (FileOutputStream fos = new FileOutputStream(this.fichero);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Producto p : productos) {
                oos.writeObject(p);
            }
            System.out.println(" -- Todo ok :) ");
        } catch (Exception e) {
            System.out.println(" -- Ha habido un problema");
        }
    }

    @Override
    public List<Producto> listarTodos() {
        List<Producto> p = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(this.fichero);
                ObjectInputStream oos = new ObjectInputStream(fis)) {
            while (true) {
                Object pr = oos.readObject();
                Producto pa = (Producto) pr;
                p.add(pa);
            }
        } 
        catch(EOFException e){
            System.out.println(" [OK] ");
        }
        catch (Exception e){
            // TODO: handle exception
        }
        return p;
    }
}
