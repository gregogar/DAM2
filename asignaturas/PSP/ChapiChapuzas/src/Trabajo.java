import java.util.Scanner;

public class Trabajo {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("-- Menu de Seleccion ------------");
            System.out.println("---------------------------------");
            System.out.println("-- Escoge una opcion:  ");
            System.out.println("-- [1] -- Espanol     ");
            System.out.println("-- [2] -- Ingles       ");
            System.out.println("-- [3] -- Italiano     ");
            int i = sc.nextInt();
            sc.nextLine();
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");

            switch (i) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println(" Por fa introduce una opcion valida <3");
                    break;
            }
        }

    }
}
