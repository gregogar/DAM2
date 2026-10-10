
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Trabajo t;
    public static Path srcPath = Paths.get("src/text/textoSinProcesar.txt");
    public static Path dstPath = Paths.get("src/text/textoProcesado.txt");
    public static String l;

    public static void main(String[] args) throws Exception {

        boolean b = true;
        while (b) {
            System.out.println("=============================================================");
            System.out.println("|| Bienvenido a ChapiChapuzas Editoriales                  ||");
            System.out.println("=============================================================");
            System.out.println("|| Corregimos y traducimos textos!                         ||");
            System.out.println("|| :)                                                      ||");
            System.out.println("=============================================================");
            System.out.println("|| Configuracion                                           ||");
            System.out.println("|| [1] - Español                                           ||");
            System.out.println("|| [2] - Ingles                                            ||");
            System.out.println("|| [3] - Italiano                                          ||");
            System.out.println("|| [4] - Salir :(                                          ||");
            System.out.println("=============================================================");
            int option = pedirEntero("|| Por favor, indica a que idioma deseas traducir tu texto ||\n");

            switch (option) {
                case 1:
                    l = "es";
                    t = new Trabajo(srcPath, dstPath, l);
                    processText();
                    break;
                case 2:
                    l = "eng";
                    t = new Trabajo(srcPath, dstPath, l);
                    processText();
                    break;
                case 3:
                    l = "ita";
                    t = new Trabajo(srcPath, dstPath, l);
                    processText();
                    break;
                case 4:
                    b = false;
                    System.out.println("=============================================================");
                    System.out.println("|| Hasta luego                                             ||");
                    System.out.println("=============================================================");
                    sc.nextLine();
                    limpiarTerminal();
                    break;
                default:
                    limpiarTerminal();
                    System.out.println("||                      ERROR                              ||");
                    System.out.println("||        La opcion introducida no es válida               ||");
                    System.out.println("||             Pulsa ENTER para continuar                  ||");
                    sc.nextLine();
                    break;
            }
        }
    }

    public static void processText() {
        limpiarTerminal();
        System.out.println("=============================================================");
        System.out.println("|| Pulsa ENTER para corregir                               ||");
        System.out.println("=============================================================");
        sc.nextLine();
        t.correctText();

        System.out.println("=============================================================");
        System.out.println("|| Pulsa ENTER para traducir                               ||");
        System.out.println("=============================================================");
        sc.nextLine();
        t.translateText();
        System.out.println("=============================================================");
        System.out.println("|| Texto procesado correctamente.                           ||");
        System.out.println("|| Puedes encontrarlo en:                                   ||");
        System.out.println("=============================================================");
        System.out.println("|| Pulsa ENTER para volver al MENU principal                ||");
        System.out.println("||                                                          ||");
        System.out.println("=============================================================");
        sc.nextLine();
        limpiarTerminal();
    }

    public static int pedirEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                String s1 = sc.nextLine().trim();
                int o = Integer.parseInt(s1);
                return o;
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número entero válido.");
            }
        }
    }

    public static Path getRutaAbsoluta()
    {
        return srcPath;
    }

    public static void limpiarTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n");
        System.out.println("\n");
    }
}
