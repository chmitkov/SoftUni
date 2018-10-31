import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2AsciiSumator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = br.readLine().charAt(0);
        int num2 = br.readLine().charAt(0);

        String input = br.readLine();

        int sum = 0;

        for (char c : input.toCharArray()) {
            if (c > num1 && c < num2) {
                sum += c;
            }
        }

        System.out.println(sum);
    }
}
