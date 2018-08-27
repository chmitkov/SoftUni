import java.io.*;

public class _5WriteEveryThirdLine {
    public static void main(String[] args) {

        String inputPath = "C:\\TestFolder\\input.txt";
        String outputPath = "C:\\TestFolder\\output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath));
        ) {
            int counter = 1;
            String line = br.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
