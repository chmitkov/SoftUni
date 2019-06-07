import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _9MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line =br.readLine();
        Pattern regex = Pattern.compile("^([A-Z][a-z]+ [A-Z][a-z]+)$");

        while (!"end".equals(line)){
            Matcher matcher = regex.matcher(line);

            if (matcher.find()){
                System.out.println(matcher.group());
            }

            line = br.readLine();
        }
    }
}
