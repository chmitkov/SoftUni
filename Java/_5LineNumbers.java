import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _5LineNumbers {
    public static void main(String[] args) {

        int counter = 1;

        try (
                BufferedReader br = Files.newBufferedReader(
                        Paths.get("C:\\TestFolder\\inputLineNumbers.txt"));
                PrintWriter out = new PrintWriter(new FileWriter(
                        "C:\\TestFolder\\output.txt"
                ));
        ) {
            String line = br.readLine();

            while (line!=null){
                out.printf("%d. %s%n",counter,line);
                counter++;
                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
