import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\9999\\Desktop\\chat.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        int oneByte = fileInputStream.read();

        while (oneByte >= 0) {
            System.out.println((char)oneByte);
            oneByte = fileInputStream.read();
        }
    }
}
