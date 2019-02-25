import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class p01_ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\9999\\Desktop" +
                "\\StreamsFilesAndDirectories_Lab\\src\\resources\\input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();

            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
