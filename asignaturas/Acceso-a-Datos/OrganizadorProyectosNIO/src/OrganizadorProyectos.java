import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.lang.model.type.NullType;

public class OrganizadorProyectos {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("MENU DE SELECCION");
        System.out.println(" [1] - Crear fichero");
        System.out.println(" [2] - Buscar directorio");
        System.out.println(" Qué quieres hacer:");
        int i = sc.nextInt();
        sc.nextLine();

        while (true) {
            switch (i) {
                case 1:
                    System.out.println("Introduce el nombre del directorio raiz");
                    String nombre = sc.nextLine();
                    Path rutaRaiz = Paths.get(nombre);
                    crearDirectorio(rutaRaiz);
                    crearFichero(rutaRaiz);
                    break;
                case 2:
                    System.out.println("Que directorio estás buscando?");
                    String name = sc.nextLine();
                    Path p = Paths.get(name);
                    mostrarEstructuraCarpetas(p);

                    break;
                case 3:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Introduce una opcion válida");
                    break;
            }
        }

    }

    public static void mostrarEstructuraCarpetas(Path p) {
        /*
         * try {
         * Stream<Path> rutas = Files.walk(p);
         * Path[] array = (Path[])rutas.toArray();
         * for (int i = 0; i < array.length; i++){
         * System.out.println(i + ":" + array[i]);
         * }
         * rutas.close();
         * } catch (Exception e) {
         * // TODO: handle exception
         * }
         */
        try (Stream<Path> rutas = Files.walk(p)) {
            rutas.forEach(r -> System.out.println(r));
        } catch (Exception e) {
            System.out.println("[ERROR]");
        }
    }

    public static void crearDirectorio(Path p) {

        if (Files.exists(p)) {
            System.out.println("El fichero raiz ya existe, no se ha creado nada");
        } else {
            try {
                Files.createDirectory(p);
                System.out.println("[OK] : El fichero raíz se ha creado");
            } catch (Exception e) {
                System.out.println("[ERROR] : Error creando el fichero raiz");
            }
        }

        System.out.println("Introduce el numero de subcarpetas");
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.println("Introduce el nombre de la subcarpeta");
            String nomSubCarpeta = sc.nextLine();
            Path rutaSubCarpeta = p.resolve(nomSubCarpeta);
            try {
                Files.createDirectories(rutaSubCarpeta);
                System.out.println("[OK] : Subcarpeta Creada");
            } catch (Exception e) {
                System.out.println("[ERROR]");
            }
        }
    }

    public static void crearFichero(Path p) {
        Path rutaReadme = p.resolve("readMe.md");
        try {
            Files.createFile(rutaReadme);
            System.out.println("[OK] : Fichero creado");
        } catch (Exception e) {
            System.out.println("[ERROR]");
        }
    }
}
