import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        ProcessBuilder pBuilder = new ProcessBuilder(
                "cmd", "/c",
                "cuadrados.bat", "1", "2", "3", "4");

        ProcessBuilder pBuilder2 = new ProcessBuilder(
                "cmd", "/c",
                "suma.bat");
        File f = new File("soluciones.txt");
        pBuilder2.redirectOutput(f);

        // opcion 1
        List<ProcessBuilder> lista1 = List.of(pBuilder, pBuilder2);
        // opcion 2
        ArrayList<ProcessBuilder> lista2 = new ArrayList<>();
        lista2.add(pBuilder);
        lista2.add(pBuilder2);

        try {
            List<Process> lp = ProcessBuilder.startPipeline(lista1);
            Process last = lp.getLast();
            last.waitFor();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
