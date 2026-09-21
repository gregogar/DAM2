import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TaskList {

    public void taskList() throws IOException {

        String cmd = "tasklist";
        ProcessBuilder pb = new ProcessBuilder(cmd);
        Process p = pb.start();

        InputStream is = p.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        int contador = 0;
        String linea;

        while ((linea = br.readLine()) != null) {
            contador++;
        }

        /*
         * /
         * List<String> lineas = br.readAllLines();
         * contador = lineas.size();
         */
        reader.close();
        br.close();
        System.out.println("Hay un total de " + (contador - 4) + " de recursos vivos");

    }

}
