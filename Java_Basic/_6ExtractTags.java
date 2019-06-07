import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _6ExtractTags {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Pattern regex = Pattern.compile("<.+?>");
        while (!"END".equals(input)){
            Matcher matcher = regex.matcher(input);
            while (matcher.find()){
                System.out.println(matcher.group());
            }
            input=br.readLine();
        }
    }
}
