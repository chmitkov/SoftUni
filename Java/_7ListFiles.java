import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class _7ListFiles {
    public static void main(String[] args) {

        File file = new File("C:\\TestFolder\\Files-and-Streams");

        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()){
                        System.out.printf("%s: %d%n",f.getName(),f.length());
                    }
                }
            }
        }


    }
}
