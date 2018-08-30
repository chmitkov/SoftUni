import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class _10MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^\\+359(-| )\\d\\1\\d{3}\\1\\d{4}$";
        String line = br.readLine();

        while (!"end".equals(line)){

            if (Pattern.matches(regex,line)) {
                System.out.println(line);
            }
            line=br.readLine();
        }
    }
}
