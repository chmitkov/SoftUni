import java.io.FileInputStream;
import java.io.FileOutputStream;

public class _3CopyBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\TestFolder\\input.txt";
        String outputPath = "C:\\TestFolder\\output.txt";

        try (FileInputStream inputStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)) {

            int bite = inputStream.read();

            while (bite >= 0) {
                if (bite == 10 || bite == 32) {
                    outputStream.write(bite);
                } else {
                    String digits = String.valueOf(bite);
                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }
                bite = inputStream.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
