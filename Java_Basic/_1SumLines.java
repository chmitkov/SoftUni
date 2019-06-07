import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _1SumLines {
    public static void main(String[] args) {
        Path inputPath = Paths.get("C:\\TestFolder\\input.txt");


        try (BufferedReader br = Files.newBufferedReader(inputPath);) {
            String line = br.readLine();
            while (line != null) {
                long sum = 0L;
                for (char c : line.toCharArray()) {
                    sum+=c;
                }
                System.out.println(sum);
                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
