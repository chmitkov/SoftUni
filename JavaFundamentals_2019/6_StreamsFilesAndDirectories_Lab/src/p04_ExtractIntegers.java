import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class p04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab" +
                "\\src\\resources\\input.txt";
        String outputPath = "C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab" +
                "\\src\\resources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(path));

        PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                out.write(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
