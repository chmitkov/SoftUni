import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _3ALL_CAPITALS {
    public static void main(String[] args) {

        Path outputPath = Paths.get("C:\\TestFolder\\output.txt");
        try (BufferedReader br =
                     Files.newBufferedReader(
                             Paths.get("C:\\TestFolder\\input.txt"));
             PrintWriter out =
                     new PrintWriter(
                             new FileWriter("C:\\TestFolder\\output.txt"))
        ) {
                String line = br.readLine();

                while (line!=null){
                    String [] lineArray = line.split(" ");
                    for (String l :lineArray) {
                        out.printf("%s ",l.toUpperCase());
                    }
                    out.println();
                    line = br.readLine();
                }
        }catch (Exception er) {
            er.printStackTrace();
        }
    }
}
