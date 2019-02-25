import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class p06_SortLines {
    public static void main(String[] args) throws IOException {
        Path inPath = Paths.get("C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab" +
                "\\src\\resources\\input.txt");
        Path outPath = Paths.get("C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab" +
                "\\src\\resources\\06.SortLinesOutput.txt");

        try {
            List<String> lines = Files.readAllLines(inPath);

            Collections.sort(lines);


            Files.write(outPath,
                    lines.stream()
                            .filter(x -> !x.isEmpty())
                            .collect(Collectors.toList()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
