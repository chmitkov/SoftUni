import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class p09_SerializableObject {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab" +
                "\\src\\resources\\p09_output.txt";
        Cube cube = new Cube("green", 15.3d, 12.4d, 3d);

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
