
import dao.ProductoDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        
        ProductoDAO dao = new ProductoDAO("src/data/data.txt");
        
        System.out.println("----------------------");
        System.out.println("GESTOR STOCK");
        System.out.println("----------------------");

    }
}
