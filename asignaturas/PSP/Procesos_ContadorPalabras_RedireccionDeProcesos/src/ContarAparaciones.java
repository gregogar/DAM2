import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ContarAparaciones {
    public static void main(String[] args) {

        ProcessBuilder pBuilder = new ProcessBuilder("./contar_palabras.bat", "loreipsum.txt", "in");
        pBuilder.redirectInput(new File("loreipsum.txt"));
        pBuilder.redirectOutput(new File("resultados.txt"));

        try (
                Process p = pBuilder.start();) {
            p.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
