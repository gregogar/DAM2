import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String archivoSh = "script/contar_palabras.sh";
        String palabra = "in";
        String ficheroTexto = "data/data.txt";
        ProcessBuilder pb = new ProcessBuilder(archivoSh, ficheroTexto, palabra);

        try {
           
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}