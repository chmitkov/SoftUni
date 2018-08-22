import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017September03_06Profit {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int mon1 = Integer.parseInt(b.readLine());
        int mon2 = Integer.parseInt(b.readLine());
        int mon5 = Integer.parseInt(b.readLine());
        int sum = Integer.parseInt(b.readLine());
        String total = "";

        for (int i = 0; i <= mon1; i++) {
            for (int j = 0; j <= mon2; j++) {
                for (int k = 0; k <= mon5; k++) {
                    if (i + j * 2 + k * 5 == sum) {
                        total += i + " * 1 lv. + " + j + " * 2 lv. + " + k + " * 5 lv. = " + sum + " lv.\n";
                        //System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.",i,j,k,sum);
                    }
                }
            }
        }
        System.out.println(total);
    }
}


