import java.io.*;

public class p03_CopyBytes {
    public static void main(String[] args) throws FileNotFoundException {
        String input = "C:\\Users\\9999\\Desktop\\" +
                "StreamsFilesAndDirectories_Lab\\src\\resources\\input.txt";

        String output = "C:\\Users\\9999\\Desktop\\StreamsFilesAndDirectories_Lab" +
                "\\src\\resources\\03.CopyBytesOutput.txt";


        try (InputStream in = new FileInputStream(input);
             OutputStream out = new FileOutputStream(output);
        ) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                String digits = String.valueOf(oneByte);
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                    continue;
                }
                for (int i = 0; i < digits.length(); i++) {
                    out.write(digits.charAt(i));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
