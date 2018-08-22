import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _15CensorEmailAddress {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mail = br.readLine();
        String neededName = mail.substring(0, mail.indexOf("@"));
        String stars = "";
        for (int i = 0; i < neededName.length(); i++) {
            stars += "*";
        }
        String domain = mail.substring(mail.indexOf("@"));
        stars += domain;
        String[] text = br.readLine().split(" ");
        for (int i = 0; i < text.length; i++) {
            if (text[i].equals(mail)) {
                text[i] = stars;
            }

        }
        for (String word : text) {
            System.out.printf("%s ",word);
        }


    }
}
