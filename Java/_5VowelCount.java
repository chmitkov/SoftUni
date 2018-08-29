import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _5VowelCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Pattern regex = Pattern.compile("[AEIOUYaeiouy]");
        Matcher matcher = regex.matcher(input);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.printf("Vowels: %d",counter);
    }
}
