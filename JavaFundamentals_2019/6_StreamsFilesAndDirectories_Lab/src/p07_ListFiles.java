import java.io.File;
import java.util.Arrays;

public class p07_ListFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab\\src\\resources\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
