import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017May07_06NumberGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int m = Integer.parseInt(b.readLine());
        int n = Integer.parseInt(b.readLine());
        int l = Integer.parseInt(b.readLine());
        int special = Integer.parseInt(b.readLine());
        int control = Integer.parseInt(b.readLine());
        int count = 0;


        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                for (int k = l; k >= 1; k--) {
                    String num = "" + i + j + k;
                    int num2 = Integer.parseInt(num);
                    if (num2 % 3 == 0) {
                        special += 5;
                    } else if (num2 % 10 == 5) {
                        special -= 2;
                    } else if (num2 % 2 == 0) {
                        special *= 2;
                    }
                    if (special >= control) {
                        count++;
                        System.out.printf("Yes! Control number was reached! Current special number is %d.", special);
                        return;

                    }

                }


            }

        }

        if (count == 0) {
            System.out.printf("No! %d is the last reached special number.", special);
        }

    }
}