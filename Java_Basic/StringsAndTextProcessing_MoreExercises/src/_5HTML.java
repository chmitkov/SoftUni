import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class _5HTML {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new LinkedHashSet<>();

        String title = br.readLine();

        String article = br.readLine();

        String input = br.readLine();

        while (!input.equals("end of comments")) {
            set.add(input);
            input = br.readLine();
        }

        System.out.printf("<h1>\n" +
                "    %s\n" +
                "</h1>\n" +
                "<article>\n" +
                "    %s\n" +
                "</article>\n", title, article);

        set.forEach(x -> System.out.printf("<div>\n" +
                "    %s\n" +
                "</div>\n", x));
    }
}
