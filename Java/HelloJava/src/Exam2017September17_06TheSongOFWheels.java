import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017September17_06TheSongOFWheels {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        int count = 0;
        String pass = "";

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int m = 1; m <= 9; m++) {
                        if ((i * j + k * m) == n && i < j && k > m) {
                            System.out.printf("%d%d%d%d ", i, j, k, m);
                            count++;
                            if (count == 4) {
                                pass = "" + i + j + k + m + "";
                            }
                            //     System.out.printf("Password: %d%d%d%d", i, j, k, m);
                            // } else {
                            //     System.out.println("No!");
                            // }
                        }
                    }
                }
            }
        }

        if (!("".equalsIgnoreCase(pass))) {
            System.out.printf("%nPassword: %s", pass);
        } else {
            System.out.println("No!");
        }
    }
}


