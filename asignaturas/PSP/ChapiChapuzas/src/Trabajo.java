
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Trabajo {

    Path srcPath;
    Path dstPath;
    String language;
    Path bat1 = Paths.get("src/bat/check.bat");
    Path bat2 = Paths.get("src/bat/translate.bat");

    public Trabajo(Path src, Path dst, String lang) {
        this.srcPath = src;
        this.dstPath = dst;
        this.language = lang;
    }

    public void processText() {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", this.bat1.toString());
        File f = srcPath.toFile();
        pb.redirectInput(f);
        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", bat2.toString(), language);
        pb2.redirectOutput(dstPath.toFile());
        List<ProcessBuilder> processBuilders_list = List.of(pb, pb2);
        try {
            List<Process> process_list = ProcessBuilder.startPipeline(processBuilders_list);
            Process last = process_list.getLast();
            last.waitFor();            
        } catch (Exception e) {
            System.out.println("=============================================================");
            System.out.println("|| - [ERROR] - Input-Output Exception (ficheros corruptos) ||");
            System.out.println("=============================================================");
        }
    }
}
