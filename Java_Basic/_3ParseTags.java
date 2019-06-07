import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] arr = line.split("<upcase>|</upcase>");
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                System.out.printf("%s", arr[i].toUpperCase());
            } else {
                System.out.printf("%s", arr[i]);
            }
        }
    }
}
