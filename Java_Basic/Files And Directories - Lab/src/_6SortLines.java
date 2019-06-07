import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _6SortLines {
    public static void main(String[] args) throws IOException {

        Path inputPath =Paths.get("C:\\TestFolder\\input.txt");
        Path outputPath =Paths.get("C:\\TestFolder\\output.txt");
        try (BufferedReader br = Files.newBufferedReader(inputPath))
        {
            List<String> list = Files.readAllLines(inputPath);
            Collections.sort(list);
            Files.write(outputPath,list);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
