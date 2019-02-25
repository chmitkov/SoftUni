import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class p02_WriteFile {
    public static void main(String[] args) throws FileNotFoundException {
        String input = "C:\\Users\\9999\\Desktop\\" +
                "StreamsFilesAndDirectories_Lab\\src\\resources\\input.txt";

        String output = "C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab" +
                "\\src\\resources\\02.WriteToFileOutput.txt";

        List<Character> symbols = new ArrayList<>() {{
            add('.');
            add(',');
            add('!');
            add('?');
        }};

        try (InputStream in = new FileInputStream(input);
             OutputStream out = new FileOutputStream(output)) {

            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char)oneByte)){
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
