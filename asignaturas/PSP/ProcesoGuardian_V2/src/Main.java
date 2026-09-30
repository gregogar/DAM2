public class Main {
    public static void main(String[] args) throws Exception {
        
        //Proceso 1
        ProcessBuilder pb1 = new ProcessBuilder("ps, -ef");

        try (Process p1 = pb1.start()) {
            
        } catch (Exception e) {
            // TODO: handle exception
        }


        // Proceso 2
        ProcessBuilder pb2 = new ProcessBuilder("grep, java");
    }
}
