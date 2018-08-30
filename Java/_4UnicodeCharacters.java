import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); 
        StringBuilder sb = new StringBuilder();
        for (char c:str.toCharArray())
        {
            sb.append(String.format("%1$4d", (int)c));
        }

        System.out.println(sb.toString());
    }
}
