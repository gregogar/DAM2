import java.util.List;

import dao.localDAO;
import dao.remotoDAO;
import model.Producto;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("-------------------------------");
        System.out.println(" Productos");
        System.out.println("-------------------------------");


        localDAO local = new localDAO("src/data/data.txt", ";");


    }
}
