import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3TreasureFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = br.readLine();

        while (!input.equals("find")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                sb.append((char)
                        (input.charAt(i) - numbers[i % numbers.length]));
            }
            String decode = sb.toString();
            String material = decode.substring(decode.indexOf("&") + 1,
                    decode.lastIndexOf("&"));
            String location = decode.substring(decode.indexOf("<") + 1,
                    decode.lastIndexOf(">"));

            System.out.printf("Found %s at %s%n", material,location);
            input = br.readLine();
        }
    }
}
