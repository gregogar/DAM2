// IO operators r-w

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> comando = new ArrayList<>();
        comando.add("ps");
        comando.add("-ef");
        List<String> comando2 = new ArrayList<>();
        comando2.add("grep");
        comando2.add("java");

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
            OutputStream output1 = p2.getOutputStream();
            PrintWriter pw = new PrintWriter(output1, true);
            pw.println(salida1);
            pw.close();

            br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String linea2;
            while ((linea2 = br2.readLine()) != null) {
                System.out.println(linea2 + '\n');
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (br2 != null) {
                br2.close();
            }
        }
    }
}
