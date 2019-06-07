import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _2SumBytes {
    public static void main(String [] args) {

        Path inputPath = Paths.get("C:\\TestFolder\\input.txt");

        try (BufferedReader br = Files.newBufferedReader(inputPath)){
            long sum = 0;
            String line = br.readLine();
            while (line!=null){
                for (char c : line.toCharArray()) {
                    sum+=c;
                }
                line = br.readLine();
            }
            System.out.println(sum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
