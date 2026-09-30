package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.Producto;

public class ProductoDAO implements DAO {

    private String ruta;
    private File f;

    public ProductoDAO(String r) {
        this.f = new File(r);
    }

    public void guardarTodos(List<Producto> p){};

    public List<Producto> listarTodos(){
        List<Producto> p = new ArrayList<>();
        return p;
    };
}
