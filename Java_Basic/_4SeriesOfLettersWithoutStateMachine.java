import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4SeriesOfLettersWithoutStateMachine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        sb.append(prev);
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current != prev) {
                sb.append(current);
                prev = current;
            }
        }
        System.out.println(sb.toString());
    }
}
