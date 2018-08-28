import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class _7MergeTwoFiles {
    public static void main(String[] args) throws IOException {


        List<String> listOne = Files.readAllLines(
                Paths.get("C:\\TestFolder\\inputOne.txt"));
        List<String> listTwo = Files.readAllLines(
                Paths.get("C:\\TestFolder\\inputTwo.txt"));

        listOne.addAll(listTwo);

        try (PrintWriter out = new PrintWriter(
                new FileWriter("C:\\TestFolder\\output.txt"));){

            listOne.forEach(out::println);
        }catch (Exception e ){
            e.printStackTrace();
        }


    }
}
