
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.smartcardio.Card;

import dao.CarDAO;
import dao.LocalCarDAO;
import dao.RemoteCarDAO;
import model.Car;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("---------");
        System.out.println("Lope Cars");
        System.out.println("---------");
        
        CarDAO remoto = new RemoteCarDAO("Coches.txt");
        List<Car> automoviles = remoto.obtenerTodos();
        CarDAO local = new LocalCarDAO(automoviles);

        boolean ok = true;
        while (ok) {
            System.out.println("------------------------");
            System.out.println("1 - Insertar coche");
            System.out.println("2 - Ver todos los coches");
            System.out.println("3 - Filtrar por marca");
            System.out.println("------------------------");

            int in = Integer.parseInt(IO.readln("Opcion : "));

            switch (in) {
                case 1:
                    String marca = IO.readln("Introduce la marca : ");
                    String modelo = IO.readln("Introduce el modelo : ");
                    int ano = Integer.parseInt(IO.readln("Introduce el año de matriculacion : "));
                    Car c = new Car(marca, modelo, ano);
                    local.insertar(c);
                    remoto.insertar(c);
                break;
                case 2:
                    List<Car> coches = local.obtenerTodos();
                    for (Car coche : coches){
                        System.out.println(coche.getMarca() + " - " + coche.getModelo());
                    }
                break;
                case 3:
                    String m2 = IO.readln("Introduce la marca : ");
                    List<Car> porMarca = local.obtenerMarca(m2);
                    for (Car coche : porMarca){
                        System.out.println(coche.getModelo());
                    }
                break;
                default: 
                    ok = false;
                break;
            }
        }
        

    }

}
