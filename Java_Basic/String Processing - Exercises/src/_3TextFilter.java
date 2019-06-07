import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] bannedWords = br.readLine().split(", ");
        String text = br.readLine();
        for (String b : bannedWords) {
            String stars = "";
            for (int i = 0; i < b.length(); i++) {
                stars = stars.concat("*");
            }
            text = text.replaceAll(b,stars);
        }
        System.out.println(text);
    }
}
