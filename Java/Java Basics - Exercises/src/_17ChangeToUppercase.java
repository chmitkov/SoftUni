import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17ChangeToUppercase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();

        StringBuilder sb = new StringBuilder();
        while (text.contains("<upcase>")){
            int currIndex = text.indexOf("<upcase>");
            int secondIndex = text.indexOf("</upcase>");
            sb.append(text.substring(0,currIndex));
            sb.append(text.substring(currIndex+8,secondIndex).toUpperCase());
            text=text.substring(secondIndex+9);
        }
        sb.append(text);
        System.out.println(sb);
    }
}
