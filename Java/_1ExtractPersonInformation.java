import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1ExtractPersonInformation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(br.readLine());

        while (counter-- > 0) {
            String input = br.readLine();
            String name = input.substring(input.indexOf("@") + 1, input.indexOf("|"));
            int age = Integer.parseInt(input.substring(input.indexOf("#") + 1
                    , input.indexOf("*")));

            System.out.printf("%s is %d years old.%n", name, age);
        }
    }
}
