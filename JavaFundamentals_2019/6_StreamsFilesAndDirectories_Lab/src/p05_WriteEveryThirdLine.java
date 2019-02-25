import java.io.*;

public class p05_WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab" +
                "\\src\\resources\\input.txt";
        String outputPath = "C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab\\" +
                "src\\resources\\05.WriteEveryThirdLineOutput.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))
        ) {
            int counter = 1;
            String line;

            while ((line = in.readLine()) != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
