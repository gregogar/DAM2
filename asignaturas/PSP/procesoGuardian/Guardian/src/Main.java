// IO operators r-w
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> comando = new ArrayList<>();
        comando.add("tasklist.exe");
        List<String> comando2 = new ArrayList<>();
        comando2.add("cmd.exe");
        comando2.add("/c");
        comando2.add("findstr java");

        // Proceso1
        ProcessBuilder pb = new ProcessBuilder(comando);
        String salida1 = "";
        BufferedReader br1 = null;

        // Proceso2 
        // ME HE QUEDADO AQUI HAY QUE HACER EL SEGUNDO PROCESO
        ProcessBuilder pb2 = new ProcessBuilder(comando2);
        String salida2 = "";
        BufferedReader br2 = null;
        

        try {
            Process p1 = pb.start();
            InputStream input1 = p1.getInputStream();
            InputStreamReader sr1 = new InputStreamReader(input1);
            br1 = new BufferedReader(sr1);
            String linea;
            while ((linea = br1.readLine()) != null) {
                salida1 = salida1 + linea + "\n";
            }
        } catch (Exception e) {
            System.out.println(" 3RR0R");
        } finally {
            if (br1 != null) {
                br1.close();
            }
        }

        try {
            Process p2 = pb2.start();
            
        } catch (Exception e) {
            // TODO: handle exception
        }

}
