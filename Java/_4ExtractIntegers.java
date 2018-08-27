import java.io.*;
import java.util.Scanner;

public class _4ExtractIntegers {
    public static void main(String[] args) throws IOException{
        String inputPath = "C:\\TestFolder\\input.txt";
        String outputPath = "C:\\TestFolder\\output.txt";

        Scanner scanner = new Scanner(new FileInputStream(inputPath));

        PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));


        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }


    }
}
