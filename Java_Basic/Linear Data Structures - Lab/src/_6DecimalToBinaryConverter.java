import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6DecimalToBinaryConverter {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(Integer.toBinaryString(num));

    }
}
