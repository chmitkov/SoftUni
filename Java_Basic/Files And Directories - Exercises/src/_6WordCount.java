import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class _6WordCount {
    public static void main(String[] args) {


        try (
                BufferedReader br = Files.newBufferedReader(
                        Paths.get("C:\\TestFolder\\words.txt"));
                PrintWriter out = new PrintWriter(
                        new FileWriter("C:\\TestFolder\\results.txt"))
        ) {
            String[] words = br.readLine().split(" ");

            List<String> list = Files.readAllLines(Paths.get("C:\\TestFolder\\text.txt"));
            List<String> allWords = new ArrayList<>();
            list.forEach(x -> {
                String[] currentRow = x.split(" ");
                Arrays.asList(currentRow).forEach(el -> allWords.add(el));
            });

            Arrays.stream(words).forEach(x->{
                int currCounter = 0;
                while (allWords.contains(x)){
                    allWords.remove(x);
                    currCounter++;
                }
                out.printf("%s - %d%n", x, currCounter);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
