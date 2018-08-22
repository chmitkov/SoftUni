import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10IndexOfLetters {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            System.out.printf("%s -> %d%n",str.charAt(i),str.charAt(i)-97);
        }
    }
}
