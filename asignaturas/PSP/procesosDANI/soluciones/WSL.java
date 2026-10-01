import java.io.IOException;

public class WSL {
    
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("wsl.exe", "bash" ,"-c", "pwd");
        pb.inheritIO();
        try {
            pb.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
