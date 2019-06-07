import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

public class _1ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\TestFolder\\input.txt";

        try(FileInputStream fileStream = new FileInputStream(path)){
            int oneByte = fileStream.read();
            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));

                oneByte = fileStream.read();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
