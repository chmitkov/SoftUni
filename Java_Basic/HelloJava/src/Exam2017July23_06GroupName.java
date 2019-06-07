import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017July23_06GroupName {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        char bigC = b.readLine().charAt(0);
        char char1 = b.readLine().charAt(0);
        char char2 = b.readLine().charAt(0);
        char char3 = b.readLine().charAt(0);
        int n = Integer.parseInt(b.readLine());
        int count = 0;


        for (char i = 'A'; i <= bigC; i++) {
            for (char j = 'a'; j <= char1; j++) {
                for (char k = 'a'; k <= char2; k++) {
                    for (char m = 'a'; m <= char3; m++) {
                        for (int l = 0; l <= n; l++) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count - 1);
    }
}
