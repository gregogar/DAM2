import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        ProcessBuilder pBuilder = new ProcessBuilder("cmd", "/c", "./cuadrado.bat", "1", "2");
        ProcessBuilder pBuilder2 = new ProcessBuilder("cmd", "/c", "./suma.bat", "1", "2");

        try (Process p = pBuilder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

                Process p2 = pBuilder2.start();
                BufferedWriter w = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));

                BufferedReader r2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));) {
            String linea;
            while ((linea = r.readLine()) != null) {
                w.write(linea);
                w.newLine();
            }
            w.close();
            while ((linea = r2.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void conPipeLine() {
        ProcessBuilder pBuilder = new ProcessBuilder("cmd", "/c", "./cuadrado.bat", "1", "2");
        ProcessBuilder pBuilder2 = new ProcessBuilder("cmd", "/c", "./suma.bat", "1", "2");

        List<ProcessBuilder> listPB = new ArrayList<>();
        listPB.add(pBuilder);
        listPB.add(pBuilder2);
        try () {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
